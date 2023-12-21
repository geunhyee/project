
package com.carina.cbs.board.news.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carina.cbs.board.news.dao.INewsDAO;
import com.carina.cbs.board.news.vo.NewsVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class Name  : NewsServiceImpl
 * Author      : ParkGeunHye
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   환경뉴스
 * Description: Service 구현체
 */
@Service
public class NewsServiceImpl implements NewsServcie {
	@Autowired
	INewsDAO dao;
	
	
	private String apiUrl = "https://openapi.naver.com/v1/search/news";
	private String clientId = "ugZJpWLTI5E5CLAVmEZ6";
	private String clientSecret = "2A7McIdvhC";

	@Override
	@Transactional
	public List<NewsVO> getNewsList(String query) {
		  List<NewsVO> enewsList = new ArrayList<>();

		    try {
		        String urlString = apiUrl + "?query=" + query;
		        URL url = new URL(urlString);
		        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		        connection.setRequestMethod("GET");
		        connection.setRequestProperty("X-Naver-Client-Id", clientId);
		        connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);

		        int responseCode = connection.getResponseCode();
		        if (responseCode == HttpURLConnection.HTTP_OK) {
		            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		            String inputLine;
		            StringBuilder content = new StringBuilder();

		            while ((inputLine = in.readLine()) != null) {
		                content.append(inputLine);
		            }
		            in.close();

		            // Jackson ObjectMapper를 사용하여 JSON 파싱
		            ObjectMapper objectMapper = new ObjectMapper();
		            JsonNode responseNode = objectMapper.readTree(content.toString());

		            // items 배열에 있는 각각의 뉴스 아이템을 EnewsVO 객체로 변환하여 리스트에 추가
		            JsonNode itemsNode = responseNode.get("items");
		            if (itemsNode != null && itemsNode.isArray()) {
		                for (JsonNode itemNode : itemsNode) {
		                    NewsVO newsVO = objectMapper.treeToValue(itemNode, NewsVO.class);
		                    enewsList.add(newsVO);
		                    
		                    
         
		                    
		                }
		            }

		        } else {
		            System.out.println("HTTP request failed: " + responseCode);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    return enewsList;
	}
}
