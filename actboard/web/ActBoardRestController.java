package com.carina.cbs.board.actboard.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carina.cbs.board.actboard.service.ActBoardService;
import com.carina.cbs.board.actboard.vo.ActBoardVO;


@RestController
@RequestMapping("/app/actboard")
public class ActBoardRestController {
    @Autowired
    ActBoardService actboardService;

    @GetMapping
    public ResponseEntity<List<ActBoardVO>> actboard() {
        List<ActBoardVO> actboardList = actboardService.getactboardList();
        return ResponseEntity.ok(actboardList);
    }


	
//	@RequestMapping("/actboardwrite")
//	public String actboardwrite(HttpSession session, Model model) {
//		if(session.getAttribute("login") == null){
//			return "redirect:/loginview";
//	}
//		return "/actboardwrite";
//	} 이부분은 따로 구현할 예정 버튼을 누르면 다른 스크린으로 넘어가게 
	
	
	/*
	 * @RequestMapping("/actdetail") public String actdetail( ) { return
	 * "/actdetail"; // View의 이름이 "freeboardEdit"일 경우 }
	 */

	 
	

}
