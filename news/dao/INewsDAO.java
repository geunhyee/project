
package com.carina.cbs.board.news.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.carina.cbs.board.news.vo.NewsVO;


/**
 * Class Name  : INewsDAO
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   환경뉴스
 * Description:  환경뉴스DAO
 */
@Mapper
public interface INewsDAO {
	
	public List<NewsVO> getNewsList();

}
