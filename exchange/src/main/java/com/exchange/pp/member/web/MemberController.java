package com.exchange.pp.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exchange.pp.member.vo.exMemberVO;
import com.exchange.pp.member.service.exMemberService;

@Controller
public class MemberController {
	
	@Autowired
	exMemberService exMemberService;

	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

	@RequestMapping("/registDo")
	public String registDo(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nm = request.getParameter("nm");
		String email = request.getParameter("email");
		System.out.println(nm);
	
		exMemberVO member = new exMemberVO(id,pw,nm,email);
		try {
			 exMemberService.registMember(member); 
		
		} catch (Exception e) {
			e.printStackTrace();
			return "errorView";
		}
		return "redirect:/";
	}

	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, Model model) {

		// 현재 request 객체의 요청이 어느 URL로 부터 왔는지
		String requestUrl = request.getHeader("Referer");
		// Controller와 view 사이에 데이터를 전달하는 객체
		// model에 addAttribute 로 key-value 쌍의 형태로 데이터를 저장하면
		// view에서 해당 key로 사용가능함.
		model.addAttribute("fromUrl", requestUrl);

		return "member/loginView";
	}

	@RequestMapping("/loginDo")
	public String loginDo(exMemberVO member, HttpSession session, boolean remember, String fromUrl,
			HttpServletResponse response) {
		System.out.println(member);
		
		exMemberVO login = exMemberService.loginMember(member);
		if (login == null) {
			
			return "redirect:/";
		}
		session.setAttribute("login", login);
		if (remember) {
			// true 쿠기 생성
			Cookie cookie = new Cookie("rememberId", member.getMemId());
			response.addCookie(cookie); // 응답하는 객체에 담아서 전달
		} else {
			// 쿠키 삭제
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie); // 응답하는 객체에 담아서 전달
		}
		return "redirect:" + fromUrl;
	}

	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		// 세션 종료
		session.invalidate();
		// 현재 요청이 어느 URL을 바라보는지
		String requestToURL = request.getRequestURL().toString();
		System.out.println(requestToURL);
		String requestUrl = request.getHeader("Referer");
		System.out.println(requestUrl);
		return "redirect:" + requestUrl;
	}
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		if(session.getAttribute("login")== null) {
			return "redirect:/loginView";
		}
		exMemberVO login = (exMemberVO) session.getAttribute("login");
		model.addAttribute("member", login);
		return "member/mypage";
	}
	@PostMapping("/files/upload")
	public ResponseEntity<?> uploadFiles(
			@RequestParam("uploadImage")MultipartFile uploadImage
			,@RequestParam Map<String, Object> map, HttpSession session) throws Exception {
			//웹 전근경로
		String webPath = "/resources/memberProfile/";
		//서버 저장 경로
		String folderPath = session.getServletContext().getRealPath(webPath);
		exMemberVO login= (exMemberVO) session.getAttribute("login");
		String imgPath = exMemberService.uploadProfile(login, folderPath, webPath, uploadImage);
		Map<String, Object> response = new HashMap<>();
		response.put("message", "success");
		response.put("imagePath", imgPath);
		return new ResponseEntity<>(response, HttpStatus.OK);
			}
	
	
	
}
