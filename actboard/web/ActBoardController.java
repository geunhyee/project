package com.carina.cbs.board.actboard.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.ResponseEntity;

import com.carina.cbs.board.actboard.service.ActBoardService;
import com.carina.cbs.board.actboard.vo.ActBoardVO;
import com.carina.cbs.board.freeboard.vo.FreeBoardVO;
import com.carina.cbs.board.freeboard.vo.ReplyVO;
import com.carina.cbs.board.freeboard.vo.SearchVO;
import com.carina.cbs.member.vo.MemberVO;


/**
 * Class Name  : ActBoardController
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 21.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */
@Controller
public class ActBoardController {
	@Autowired
	ActBoardService actboardService;
	
	@RequestMapping("/actboard")
	public String actboard(Model model,  @ModelAttribute("searchVO") SearchVO searchVO) {
		//List<ActBoardVO> actboardList = actboardService.getactboardList();
		List<ActBoardVO> actboardList = actboardService.searchBoardList(searchVO);
		model.addAttribute("actboardList", actboardList);
//		System.out.println(actboardList);
		
		return "/actboard";
	}
	
	@RequestMapping("/actboardwrite")
	public String actboardwrite(HttpSession session, Model model, HttpServletRequest request) {
		if(session.getAttribute("login") == null){

			return "redirect:/loginView";
	}
		return "/actboardwrite";
	}
	


	
	@RequestMapping("/actboardwriteDo")
	public String actboardwrite(ActBoardVO actboard, HttpSession session) throws Exception{
		MemberVO login = (MemberVO) session.getAttribute("login");
		actboard.setMemId(login.getMemId());
		actboardService.actboardwrite(actboard);
		
		return "redirect:/actboard";
	}
	
//좋아요
	
	@PostMapping("/actGood")
	public ResponseEntity<String> actGood( int boardNo){
		System.out.println(boardNo);
		try {
			actboardService.actGood(boardNo);
			return ResponseEntity.ok("Success");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
		}
	}
	 
	
//	@RequestMapping("/actdetail")
//	public String actdetail(Model model, HttpServletRequest request, @RequestParam("boardNo")int boardNo) throws Exception {
//		System.out.println(request);
//	    String actBoardNoString = request.getParameter("boardNo");
//	    System.out.println(actBoardNoString);
//	    if (actBoardNoString != null && !actBoardNoString.isEmpty()) {
//	        try {
//	            int actBoardNo = Integer.parseInt(actBoardNoString);
//	            ActBoardVO actboardVO = actboardService.getActBoard(actBoardNo);
//	            System.out.println(actboardVO);
//	            
//	            
//	            model.addAttribute("actboard", actboardVO);
//	        } catch (NumberFormatException e) {
//	            // actBoardNo를 숫자로 변환할 수 없는 경우 처리
//	            e.printStackTrace(); // 또는 로깅
//	        }
//	    } else {
//	        // actBoardNo가 null 또는 빈 문자열인 경우 처리
//	    }
//
//	    return "/actdetail";
//	}
	
	//게시글 상세화면, 조회수 증가
	@RequestMapping("/actdetail")
	public String actdetail(Model model, @RequestParam("boardNo") int boardNo) throws Exception {
	    ActBoardVO actboardVO = actboardService.getActBoard(boardNo);
	   model.addAttribute("likeCount", actboardVO.getActGood());
	  
	    actboardService.actHit(boardNo);
	    model.addAttribute("actboard", actboardVO);
	    System.out.println(model);
	    return "/actdetail";
	}
	
	//수정
	@RequestMapping("/actboardEdit")
	  public String freeboardEdit(Model model,int boardNo) throws Exception{ 
		 ActBoardVO actboardVO = actboardService.getActBoard(boardNo);
		 model.addAttribute("actboard", actboardVO);
	  
	  return "/actboardEdit";
	 
	  }
	
	 @PostMapping("/actboardEditDo")
		public String actboardEditDo(ActBoardVO actboard) throws Exception {
		 System.out.println(actboard);
		 actboardService.updateactBoard(actboard);
			return "redirect:/actboard";
		}
	 
	 //삭제
		@PostMapping("/actboardDel")
		public String actboardDel(int boardNo) throws Exception {
			actboardService.deleteactBoard(boardNo);

			return "redirect:/actboard";
		}
//	 @PostMapping("/actboardDel")
//	 public String actboardDel(int boardNo, RedirectAttributes redirectAttributes) {
//	     try {
//	         // 이미지 파일 경로는 서비스 내에서 가져오거나 필요한 경우에 전달할 수 있습니다.
//	         actboardService.deleteactBoard(boardNo);
//	         return "redirect:/actboard";
//	     } catch (Exception e) {
//	         // 예외가 발생한 경우 로깅
//	         e.printStackTrace();
//	         
//	         // 사용자에게 오류 메시지 전달
//	         redirectAttributes.addFlashAttribute("error", "게시글 삭제 중 오류가 발생했습니다.");
//	         
//	         // 다시 해당 페이지로 리다이렉트
//	         return "redirect:/actboard";
//	     }
//	 }

	
	
	
	
	
	//실천일지 사진파일 업로드
	
	@PostMapping("/uploadImage")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile uploadImage,
							 ActBoardVO actboardVO,
	                                     HttpSession session) throws Exception {
		System.out.println(actboardVO);
	    // 웹 전근경로
	    String webPath = "/resources/uploadImage/";
	    // 서버 저장 경로
	    String folderPath = session.getServletContext().getRealPath(webPath);
	    
//	    ActBoardVO actboardVO = new ActBoardVO();
	    actboardVO.setMemId(((MemberVO) session.getAttribute("login")).getMemId());
	
	    
	    String imgPath = actboardService.uploadProfile(actboardVO, folderPath, webPath, uploadImage);
	    
	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "success");
	    response.put("imagePath", imgPath);
	    
	    return new ResponseEntity<>(response, HttpStatus.OK);
	    
	}
	private static String CURR_IMATE_PATH = getPath();
	
	public static String getPath() {
	    String os = System.getProperty("os.name").toLowerCase();
        String path = "";
        if (os.contains("win")) {
            // Windows 운영 체제인 경우
            path = "c:\\dev\\image_repo";
        } else if (os.contains("nux") || os.contains("nix")) {
            // Linux/Unix 운영 체제인 경우 (Ubuntu 포함)
            path = "/home/carina/image_repo";
        } else {
            System.out.println("where?");
        }
        System.out.println("Path is set to: " + path);
		return path;
	}
	//	---------- 파일 업로드, 다운로드 
//	private static String CURR_IMATE_PATH= "c:\\dev\\image_repo";
	//	private static String CURR_IMATE_PATH= "서버경로";
	
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName
			          , HttpServletResponse response) throws IOException {
		 OutputStream out = response.getOutputStream();
		 String downFile = CURR_IMATE_PATH + File.separator +imageFileName;
		 File file = new File(downFile);
		 if(!file.exists()) {
			 response.sendError(HttpServletResponse.SC_NOT_FOUND, "file not found");
		 }
		 response.setHeader("Cache-Control", "no-cache");
		 response.setHeader("Content dispostion","attachment; fileName=" + imageFileName);
		 try(FileInputStream in = new FileInputStream(file)){
			 byte[] buffer = new byte[1024 * 8];
			 while(true) {
				 int count = in.read(buffer);
				 if(count == -1) { // 버퍼에 마지막에 도달했는지 도달 시 종료 
					 break;
				 }
				 out.write(buffer, 0, count); // 실시간 전송 
			 }
		 }catch(IOException ex) {
			 //
		 }finally {
			out.close();
		 }
		 
	}
	@RequestMapping("/multiImgUpload")
	public void multiImgUpload(MultipartHttpServletRequest req, HttpServletResponse res) {
		//저장 후 정보 전달내용		
		try {
			Iterator<String> itr = req.getFileNames();
			
			
		    while(itr.hasNext()) {
		    	
                String uploadedFile = itr.next();
                String sFileInfo = "";
                MultipartFile file = req.getFile(uploadedFile);
                String mimeType = file.getContentType();
                String fileName = file.getOriginalFilename();
                
                String prifix = fileName.substring(fileName.lastIndexOf(".") + 1);
    			prifix = prifix.toLowerCase();
    			String path = CURR_IMATE_PATH;
    			String realName = UUID.randomUUID().toString() + "." + prifix;
                
                byte[] bytes = file.getBytes();
                // 파일 저장
                File  outFile = new File(path + File.separator + realName);
                FileOutputStream fos = new FileOutputStream(outFile);
                fos.write(bytes);
                fos.close();
                  			
    			sFileInfo +="sFileName="+fileName;
    			sFileInfo +="&sFileURL=/download?imageFileName=" + realName;
    			PrintWriter print = res.getWriter();
    			print.print(sFileInfo);
    			print.flush();
    			print.close();
    			
            }
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	 
	

}


