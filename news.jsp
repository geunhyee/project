<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CARINA - carbon reduce now</title>

</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>
<div class="section section-news">
       <!--  <div class="news-container">
            <div class="row-custom align-items-center">
                <div class="col-md-6 col-lg-6 text-center">
                 -->
                
                
                <!-- 카드 열 반복 부분 -->
               <div class="row">
                <c:forEach var="index" begin="0" end="5">
				    <div class="col-md-6  col-lg-6 text-center">
				        <div class="card bg-primary shadow-soft border-light mb-41 custom-card">
				            <div class="card-news py-5">
				                
				                <!-- 수정된 부분: 뉴스 내용 표시 -->
				                <h4>${enewsList[index].title}</h4>
				                
				                <p>${enewsList[index].pubDate}</p>
				                <p>${enewsList[index].description}</p>
				                <!-- ... (나머지 내용은 그대로 유지) ... -->
				                <a href="${enewsList[index].link }" class="btn btn-primary text-dark btn-icon">
				                    <span class="btn-inner-icon"><span class="far fa-eye"></span></span>
				                    <span class="btn-inner-text font-weight-bold"  >more</span>
				                </a>
				            </div>
				        </div>
				    </div>
				</c:forEach>
				</div>
	              </div>
                <!-- </div>
                </div>
                </div>
                 -->
      
            		
               
<%@include file="/WEB-INF/inc/footer.jsp"%>


<script>
    $(document).ready(function(){
        const maxResults = 6;

       
            let q = "환경문제, 탄소"; // 이상기후로 고정했음

            $.ajax({
                url: '<c:url value="/news"/>',
                type: 'GET',
                data: { query: q, maxResults: maxResults },
                success: function(enewsList) {
                    // 받아온 뉴스 목록을 처리
                    let enewsListContainer = $("#enewsList");
                    enewsListContainer.empty();

                    for (let i = 0; i < Math.min(maxResults, enewsList.length); i++) {
                        let newsItem = enewsList[i];
                        // 이후 뉴스 항목을 처리하는 코드 작성
                        enewsListContainer.append(
                        	<div>
                        		<a href="${newsItem.originallink}" target="_blank">
                           			 <h4>${newsItem.title}</h4>
                           			 
		                        </a>
		                        <p>${newsItem.pubDate}</p>
		                        <p>${newsItem.description}</p>
		                    </div>
                        	`);
                    }
                },
                error: function(error){
                    console.error(error);
                    alert("뉴스를 불러올 수 없습니다.");
                }
            });
        });
   
</script>


</body>
</html>