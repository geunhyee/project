package com.carina.cbs.board.freeboard.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carina.cbs.board.freeboard.service.FreeBoardService;
import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.ReplyVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;
import com.carina.cbs.member.vo.MemberVO;

/**
 * Class Name : FreeBoardController Author : ParkGeunHye Created Date: 2023. 11.
 * 29. Version: 1.0 Purpose: 자유게시판 controller Description: 자유게시판 controller부분
 */
@Controller
public class FreeBoardController {
	@Autowired
	FreeBoardService freeboardService;

	@RequestMapping("/freeboard")
	public String freeboard(Model model, HttpSession session, @ModelAttribute("searchVO") SearchVO searchVO) {
		System.out.println(searchVO);
		List<FreeBoardVO> freeboardList = freeboardService.searchBoardList(searchVO);
		System.out.println(freeboardList);
		model.addAttribute("freeboardList", freeboardList);
		return "/freeboard";
	}

//	게시글 쓰기
	@RequestMapping("/freeboardwrite")
	public String freeboardwrite(HttpSession session, Model model) {
		if (session.getAttribute("login") == null) {
			return "redirect:/loginView";
		}
//		 // 현재 시간을 가져오기
//        Date currentDate = new Date();
//
//        // SimpleDateFormat을 사용하여 원하는 형식으로 포맷팅
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = dateFormat.format(currentDate);
//        model.addAttribute("now", formattedDate);

		return "/freeboardwrite";
	}

	@RequestMapping("/freeboardwriteDo")
	public String freeboardwrite(FreeBoardVO freeboard, HttpSession session) throws Exception {
		MemberVO login = (MemberVO) session.getAttribute("login");
		freeboard.setMemId(login.getMemId());
		freeboardService.freeboardwrite(freeboard);
		return "redirect:/freeboard";
	}

	
//	 @RequestMapping("/freeboardDetail") 
//	 public String freeboardDetail(Model model, int boardNo) throws Exception{ 
//		 FreeBoardVO freeboardVO =freeboardService.getFreeBoard(boardNo); 
//		 List<ReplyVO> replyList=freeboardService.getReplyList(boardNo);
//		 model.addAttribute("replyList",replyList);
//		 model.addAttribute("freeboard", freeboardVO);
//		 
//	 return "/freeboardDetail"; 
//	 }
	
	
	//게시판 상세화면, 댓글, 조회수
	@RequestMapping("/freeboardDetail")
	public String freeboardDetail(Model model, @RequestParam("boardNo") int boardNo) throws Exception {
	    FreeBoardVO freeboard = freeboardService.getFreeBoard(boardNo);

	    if (freeboard != null) {
	        // 조회수 증가
	        freeboardService.boardHit(boardNo);

	        // 댓글 목록 가져오기
	        List<ReplyVO> replyList = freeboardService.getReplyList(boardNo);

	        // 모델에 추가
	        model.addAttribute("replyList", replyList);
	        model.addAttribute("freeboard", freeboard);

	        return "/freeboardDetail";
	    } else {
	        return "redirect:/freeboard";
	    }
	}

	 

	 @RequestMapping("/freeboardEdit")
	  public String freeboardEdit(Model model,int boardNo) throws Exception{ 
		 FreeBoardVO freeboardVO = freeboardService.getFreeBoard(boardNo);
		 model.addAttribute("freeboard", freeboardVO);
	  
	  return "/freeboardEdit";
	 
	  }
	
	 @PostMapping("/freeboardEditDo")
		public String freeboardEditDo(FreeBoardVO freeboard) throws Exception {
			freeboardService.updateBoard(freeboard);
			return "redirect:/freeboard";
		}
		@PostMapping("/freeboardDel")
		public String freeboardDel(int boardNo) throws Exception {
			freeboardService.deleteBoard(boardNo);
			return "redirect:/freeboard";
		}
		//조회수 부분
//		@RequestMapping("/freeboardDetail")
//		public String freeboardDetail(Model model, @RequestParam("boardNo") int boardNo) throws Exception{
//		FreeBoardVO freeboard = freeboardService.getFreeBoard(boardNo);
//			if(freeboard != null) {
//				freeboardService.boardHit(boardNo);
//			}else {
//				return "redirect:/freeboard";
//			}
//			model.addAttribute("freeboard", freeboard);
//			return "/freeboardDetail";
//		}
		
		//검색부분
		@RequestMapping("/searchBoard")
		public String searchBoard(Model model, SearchVO search ) {
			System.out.println(search);
			List<FreeBoardVO> freeboardList = freeboardService.searchBoardList(search);
			model.addAttribute("freeboardList", freeboardList);
			System.out.println(freeboardList);
			return "/freeboard";
		}
		
//		@PostMapping("/freeboard")
//		public String searchFreeboard(@ModelAttribute("searchVO") SearchVO searchVO, Model model) {
//		    // 검색 조건에 따라 데이터를 필터링하고 결과를 모델에 추가하는 로직
//		    List<FreeBoardVO> filteredList = freeboardService.searchBoardList(searchVO);
//		    model.addAttribute("freeboardList", filteredList);
//
//		    // 필요한 경우 페이징 로직도 추가
//
//		    return "freeboard"; // 검색 결과를 보여주는 페이지로 이동
//		}

		
		//댓글부분
		
		@ResponseBody
		@PostMapping("/writeReplyDo")
		public ReplyVO writeReplyDo(@RequestBody ReplyVO reply) throws Exception {
			System.out.println(reply);
			//replyno 생성
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
			String uniquId =sdf.format(date);
			System.out.println(uniquId);
			//임의의 아이디 생성후 저장 reply_no에 담아주기
			reply.setReplyNo(uniquId);
			
			// SimpleDateFormat을 사용하여 포맷 지정 12/15 17:47
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
	        String dateString = dateFormat.format(date);
			reply.setReplyDate(dateString);
			//댓글 저장
			System.out.println(reply);
			freeboardService.writeReply(reply);
			//저장된 댓글 조회
			ReplyVO result = freeboardService.getReply(uniquId);
			//조회결과 리턴(저장 댓글을 화면에 바로 출력하기 위해)
			return reply;
		}
		@ResponseBody
		@PostMapping("/delReplyDo")
		public String delReplyDo(@RequestBody ReplyVO reply) throws Exception {
			String result = "fail";
			freeboardService.delReply(reply.getReplyNo());
			result="success";
			return result;
		}
		

	 
}
