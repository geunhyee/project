package com.carina.cbs.board.news.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carina.cbs.board.news.service.NewsServcie;
import com.carina.cbs.board.news.vo.NewsVO;

@RestController
@RequestMapping("/app/news") // 기본 URL 경로 설정
public class NewsRestController {
    @Autowired
    NewsServcie newsService;
    
    @GetMapping
    public List<NewsVO> getEnewsList() {
        // UTF-8로 인코딩
        try {
            String keyword = URLEncoder.encode("환경문제,탄소", "UTF-8");
            return newsService.getNewsList(keyword);
        } catch (UnsupportedEncodingException e) {
            // 예외 처리
            e.printStackTrace();
            return null; // 적절한 예외 처리 로직을 추가하십시오.
        }
    }
}
