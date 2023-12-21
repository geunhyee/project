
package com.carina.cbs.board.news.service;

import java.util.List;

import com.carina.cbs.board.news.vo.NewsVO;

/**
 * Class Name  : NewsServcie
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   환경뉴스
 * Description: Service
 */
public interface NewsServcie {
	List<NewsVO> getNewsList(String query);
}
