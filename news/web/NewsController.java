package com.carina.cbs.board.news.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carina.cbs.board.news.service.NewsServcie;
import com.carina.cbs.board.news.vo.NewsVO;

/**
 * Class Name  : NewsController
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   환경뉴스
 * Description: controller
 */
@Controller
public class NewsController {
	@Autowired
	NewsServcie newsService;
	
	@RequestMapping("/news")
    public String getEnewsList(Model model) {
		//UTF-8로 인코딩
		try {
			String keyword= URLEncoder.encode("환경문제,탄소", "UTF-8");
			List<NewsVO> enewsList = newsService.getNewsList(keyword);
			model.addAttribute("enewsList", enewsList);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
        return "/news"; // 뷰의 경로와 파일명
    }
	
}
