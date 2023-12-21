<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CARINA - carbon reduce now</title>

</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<div class="container">
        <div class="row align-items-center justify-content-center mt-7">
            <div class="col-md-12 col-lg-12 mb-5"><!-- Contact Card -->
                <div class="card bg-primary shadow-soft border-light p-2 p-md-3 p-lg-5">
                    <div class="row mt-5 justify-content-center">
                        <div class="col-md-12 mb-5 text-center">
                      
                            <h1 class="display-2"><strong>실천 일지를 작성해보세요!</strong></h1>
                        </div>
                    <!--     <hr1> -->
                    </div>
                    <section class="page-section" id="contact">
                        <div class="container" style="margin-top: 70px;">
                            <!-- Contact Section Form-->
                            <div class="row justify-content-center" style="margin-bottom: 50px;">
                                <div class="col-lg-8 col-xl-7">
                                    <!-- title input-->
                                    <div class="mb-3">
                                    <form id="myForm" action="<c:url value="/actboardEditDo" />" method="post" enctype="multipart/form-data">
                                    <%--  <form id="myForm" action="<c:url value="/actboardwriteDo" />" method="post"> --%>
                                        <input type="hidden" value="${actboard.boardNo }" name="boardNo">
                                        <div class="form-group"><label for="Select">카테고리</label>
                                         <select name="category" id="disabledSelect" class="form-control">
                                                <option value="1">키우는 식물에 적절하게 물주기</option>
                                                <option value="2">영상시청시간 줄이기</option>
                                                <option value="3">텀블러 사용하기</option>
                                                <option value="4">스마트폰 절전모드 사용하기</option>
                                                 <option value="5">장바구니 사용하기</option>
                                                 <option value="6">안쓰는 물품 나눠주기</option>
                                                 <option value="7">내가 사용하는 가전제품 에너지효율등급 확인하기</option>
                                                 <option value="8">한번에 먹을만큼만 덜어 먹기</option>
                                                 <option value="9">실내난방온도 2도 낮추기</option>
                                                 <option value="10">밥솥 보온기능 이용 줄이기</option>
                                            </select></div>
                                        <div class="form-group mb-4"><label for="boardTitle">제목</label> <input
                                                type="text" class="form-control" id="boardTitle"  name="boardTitle" value="${actboard.boardTitle }">
                                        </div>

                                            <div class="mb-3">
                                                <div class="form-group"><label for="memId">작성자</label>
                                                    <input type="text"  id="memId" class="form-control" name="memId"  readonly="readonly"
                                                        placeholder="${sessionScope.login.memId }">
                                                </div>
                                            </div>
                                           <div class="mb-3">
                                                <div class="form-group"><label for="createDate">작성일</label>
                                                    <h6 id="createDate">${actboard.createDate }</h6>
                                                    <!-- <input type="text" id="disabledTextInput" class="form-control"
                                                        placeholder="작성일"> -->
                                                </div> 
                                            </div>
                                            <div class="mb-3">
                                                <div class="form-group"><label for="updateDate">마지막수정일</label>
                                                     <h6 id="updateDate">${actboard.updateDate }</h6>
                                                    <!-- <input type="text" id="disabledTextInput" class="form-control"
                                                        placeholder="마지막수정일"> -->
                                                </div>
                                            </div>
<!--                                         
                                       
                                        <div class="custom-file"><input type="file"  name="file" class="custom-file-input"
                                                id="uploadImage" aria-label="File upload"> <label
                                                class="custom-file-label" for="uploadImage" id="fileLabel">사진선택</label></div><!-- End of Form -->
                                         <input type="hidden" name="actImg" id="actImg">
                                    <!-- content input-->
                                    <div class="mb-3">
                                        <textarea class="form-control" 
                                id="boardContent" rows="20" name="boardContent">${actboard.boardContent} </textarea>
                                    </div>
                                    <div class="card-footer px-0 mx-auto d-flex justify-content-end">
                                    	<c:if test="${sessionScope.login.memId == actboard.memId }">
                                        <button class="btn btn-secondary" type="submit" ><span
                                                class="ml-1">수정</span> </button>
                                                </c:if>
                                    </div>
                                  </form>
                                </div>

                            </div>
                        </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
	<%@include file="/WEB-INF/inc/footer.jsp"%>
	
	<!-- 파일 업로드 -->
	<script>

	$(document).ready(function(){
		
		function callAjaxForHTML5(tempFile, sUploadURL) {
			console.log(tempFile, sUploadURL);
		    var formData = new FormData();
		    formData.append('file', tempFile);

		    $.ajax({
		        url: sUploadURL,
		        type: 'POST',
		        data: formData,
		        processData: false,
		        contentType: false,
		        success: function(responseText) {
		                var arr = responseText.split('&');
		                var fileNm = arr[0].replace('sFileName=','');
		                var filePath = arr[1].replace('sFileURL=','');
		                $("#fileLabel").text(fileNm);
		                $("#actImg").val(filePath);
		        },
		        error: function(xhr, status, error) {
		        	console.log(xhr, status, error);
		        }
		    });
		}
		
		$("#uploadImage").change(function(){
			
			 // Check if any file is selected
	        if (this.files && this.files[0]) {
	            var tempFile = this.files[0];
	            var sUploadURL = "<c:url value='/multiImgUpload'/>"; // Replace with your upload URL
	            callAjaxForHTML5(tempFile, sUploadURL);
	        }
		});
		
		
		
// 		$("#subBtn").click(function(){
// 			  // form 데이터를 FormData 객체로 생성
//             var formData = new FormData($("#myForm")[0]);

//             // AJAX를 사용하여 서버로 데이터 전송
//             $.ajax({
//                 url: '<c:url value="/uploadImage" />',   
//                 type: "POST",
//                 data: formData,
//                 contentType: false, // 필수: 데이터가 FormData 객체이므로 false로 설정
//                 processData: false, // 필수: FormData를 사용하므로 false로 설정
//                 success: function (response) {
//                     // 성공적으로 제출된 경우의 처리
//                     console.log("Submission successful:", response);
//                 },
//                 error: function (error) {
//                     // 제출 중 오류가 발생한 경우의 처리
//                     console.error("Submission error:", error);
//                 }
//             });
// 		});

	});

	
	
	</script>
	
					
				
	
</body>

</html>