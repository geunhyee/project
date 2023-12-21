<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
	 <main><!-- Section -->
        <section class="section section-lg">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-12 col-lg-12 mb-5"><!-- Contact Card -->
                        <div class="card bg-primary shadow-soft border-light p-2 p-md-3 p-lg-5">
                            <div class="card-header">
                                <div class="row justify-content-center" style="display: block">
                                    <div class="container text-center mb-5">
                                    	
                                        <h1><strong>실천 일지</strong></h1>
                                    </div>

                                    <div class="container mb-5">
                                        <table class="table shadow-soft rounded text-center ">
                                            <colgroup>
                                                <col width="25%" />
                                                <col width="25%" />
                                                <col width="25%" />
                                                <col width="25%" />
                                            </colgroup>

                                            <thead>
                                                <tr>
                                                    <th>
                                                        제목
                                                    </th>
                                                    <th colspan="3">
                                                        우리집 가전제품 수준
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>
                                                        카테고리
                                                    </th>
                                                    <th colspan="3">
                                                        <fieldset disabled="disabled">
                                                            <div class="form-group1"><select id="category"
                                                                    class="form-control">
                                                                    <option>${actboard.category}</option>
                                                                    <option>카테고리2</option>
                                                                    <option>카테고리3</option>
                                                                </select></div>
                                                        </fieldset>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>이름</th>
                                                    <th>등록일</th>
                                                    <th>수정일</th>
                                                    <th>조회수</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${actboard.memId }</td>
                                                    <td>${actboard.createDate}</td>
                                                    <td>${actboard.updateDate }</td>
                                                    <td>${actboard.actHit }</td>
                                                </tr>


                                                <!-- 다른 행들 추가 가능 -->
                                            </tbody>
                                        </table>
                                    </div>

                                    <div class="col-12">
                                        <div class="shadow-inset p-4 mb-5 rounded">
                                           <!--  <img src="\image_repo"> -->
                                           <%-- <img src="${pageContext.request.contextPath}/image_repo/${actboard.actImg}" alt="Act Image"> --%>
                                       <div class="d-flex justify-content-center align-items-center">
                                       <img src="<c:url value='${actboard.actImg}' />" > 
                                       	
                                       

                        				</div>
                                            



                                            <div class="shadow-inset p-4 mt-7 rounded text-center"  id="boardContent" >
                                                ${actboard.boardContent }
                                            </div>

                                            <div class="container ml-5 mt-5 mb-5">
                                                <div class="col-12 col-md-10 mx-auto text-center">
                                                    <div class="d-flex justify-content-center">
                                                    <c:if test="${sessionScope.login.memId == actboard.memId  }">
                                                        <button class="btn btn-lg btn-primary mr-6" type="button"
                                                            aria-label="love button" title="love button" onclick="actGood(${actboard.boardNo})">
                                                            <span aria-hidden="true" class="far fa-heart"></span>
                                                             <span class="mr-0"><p id="likeCountNum">${actboard.actGood}</p></span>
                                                        </button>
                                                        </c:if>
                                                        <!-- <button class="btn btn-lg btn-primary mr-6" type="button"
                                                            aria-label="love button" title="love button">
                                                            <span aria-hidden="true" class="far fa-smile    "></span>
                                                        </button>
                                                        <button class="btn btn-lg btn-primary mr-6" type="button"
                                                            aria-label="love button" title="love button">
                                                            <span aria-hidden="true" class="far fa-thumbs-up"></span>
                                                        </button>
                                                        <button class="btn btn-lg btn-primary mr-6" type="button"
                                                            aria-label="love button" title="love button">
                                                            <span aria-hidden="true" class="far fa-grin-stars"></span>
                                                        </button> -->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                    

                                <div class="card-footer px-0 mx-auto" style="display: flex; justify-content: flex-end;">
                                   <c:if test="${sessionScope.login.memId == actboard.memId  }">
                                    <form action="<c:url value="/actboardEdit"/> " method ="post">
                                        <input type="hidden" name="boardNo" value="${actboard.boardNo}">
                                        <button type="submit" class="btn btn-primary">수정</button>
                                    </form>
                                    <form action="<c:url value="/actboardDel"/>" method ="post">
                                        <input type="hidden" name="boardNo" value="${actboard.boardNo}">
                                        
                                        <button type="submit" class="btn btn-secondary">삭제</button>
                                        </form>
                                  		</c:if>
                                </div>
                                

                            </div><!-- End of Contact Card -->
                        </div>
                    </div>
                </div>
        </section><!-- End of section -->
    </main>
	<%@include file="/WEB-INF/inc/footer.jsp"%>
</body>

<script type="text/javascript">

 function actGood(no) {
    // AJAX를 사용한 서버로의 요청
    $.ajax({
        type: "POST",
        url: '<c:url value="/actGood" />',
        data: { boardNo: no },
        success: function (response) {
            // 성공적으로 요청이 처리된 경우의 동작
            // 좋아요수를 숫자로
            var currentLikeCount = parseInt($("#likeCountNum").text());

            /* // 서버에서 받은 응답 데이터를 사용하여 좋아요 수 업데이트
            var likeCount = response.likeCount; // 서버에서 좋아요 수를 가져옴
			console.log(likeCount);
            // 좋아요 수를 1 증가시킴
            likeCount=likeCount+1; */
			
            currentLikeCount = currentLikeCount +1;
            // 좋아요 수를 <p> 태그에 표시
            $("#likeCountNum").text(currentLikeCount);
        },
        error: function (error) {
            // 요청이 실패한 경우의 동작
            console.error(error);
        }
    });
} 




 </script>
</html>