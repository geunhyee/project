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
                                    <form id="myForm" action="<c:url value="/actboardwriteDo" />" method="post" enctype="multipart/form-data">
                                    <%--  <form id="myForm" action="<c:url value="/actboardwriteDo" />" method="post"> --%>
                                        <div class="form-group"><label for="Select">카테고리</label>
                                         <select name="category" id="category" class="form-control">
                                                <option value="식사할때 먹을만큼만 덜어서 먹기">식사할때 먹을만큼만 덜어서 먹기</option>
                                                <option value="난방에너지 절약하기">난방에너지 절약하기</option>
                                                <option value="다회용컵과 텀블러 사용하기">다회용컵과 텀블러 사용하기</option>
                                                <option value="가까운 거리는 걷고 먼 거리는 대중 교통 이용하기">가까운 거리는 걷고 먼 거리는 대중 교통 이용하기</option>
                                                 <option value="친환경 제품 사용하기">친환경 제품 사용하기</option>
                                                 
                                            </select></div>
                                        <div class="form-group mb-4"><label for="actBoardTitle">제목</label> <input
                                                type="text" class="form-control" id="actBoardTitle"  name="boardTitle">
                                        </div>

                                            <div class="mb-3">
                                                <div class="form-group"><label for="memId">작성자</label>
                                                    <input type="text"  id="memId" class="form-control" name="memId"  readonly="readonly"
                                                        placeholder="${sessionScope.login.memId }">
                                                </div>
                                            </div>
                                          <!--   <div class="mb-3">
                                                <div class="form-group"><label for="disabledTextInput">작성일</label>
                                                    <input type="text" id="disabledTextInput" class="form-control"
                                                        placeholder="작성일">
                                                </div> 
                                            </div>-->
                                            <!-- <div class="mb-3">
                                                <div class="form-group"><label for="disabledTextInput">마지막수정일</label>
                                                    <input type="text" id="disabledTextInput" class="form-control"
                                                        placeholder="마지막수정일">
                                                </div>
                                            </div -->
<!--                                         </fieldset> -->
                                       
                                        <div class="custom-file"><input type="file"  name="file" class="custom-file-input"
                                                id="uploadImage" aria-label="File upload"> <label
                                                class="custom-file-label" for="uploadImage" id="fileLabel">사진선택</label></div><!-- End of Form -->
                                         <input type="hidden" name="actImg" id="actImg">
                                    <!-- content input-->
                                    <div class="mb-3">
                                        <textarea class="form-control" placeholder="내용을 입력하세요"
                                id="actBoardContent" rows="4" name="boardContent"></textarea>
                                    </div>
                                    <div class="card-footer px-0 mx-auto d-flex justify-content-end">
                                        <button class="btn btn-secondary" type="submit"  id="subBtn"><span
                                                class="ml-1">글쓰기</span> </button>
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
		

	});

	
	
	</script>
	
					
				
	
</body>

</html>