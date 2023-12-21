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
                    </div> 
                    <section class="page-section" id="contact">
                        <div class="container" style="margin-top: -30px;">
                            <!-- Contact Section Form-->
                            <div class="row justify-content-center" style="margin-bottom: 10px;">
                                <div class="col-lg-8 col-xl-7">
                                <form action="<c:url value="/freeboardwriteDo" />" method="post">
                                    <!-- title input-->

                                    <div class="mb-3">
                                        <div class="form-group mb-4"><label for="title">제목</label> <input
                                                class="form-control" id="title" name="boardTitle" type="text"
                                      />
                                        </div>
                                        <fieldset disabled="disabled">
                                            <div class="mb-3">
                                                <div class="form-group"><label for="memId">작성자</label>
                                                    <input type="text"  id="memId" class="form-control" 
                                                        placeholder="${sessionScope.login.memId }">
                                                </div>
                                            </div>
                                        <%--     <div class="mb-3">
                                                <div class="form-group"><label for="createDate">작성일</label>
                                                    <input type="text" id="createDate" class="form-control"
                                                        placeholder="${now}">
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <div class="form-group"><label for="updateDate">수정일</label>
                                                    <input type="text" id="updateDate" class="form-control"
                                                        placeholder="${now }">
                                                </div>
                                            </div>  --%>
                                        </fieldset>
                                  
                                    <!-- End of Form -->
                                    </div>
                                    <!-- content input-->
                         
                                        <div class="mb-3">
                                            <textarea class="form-control" placeholder="내용을 입력하세요"  name="boardContent" rows="20"></textarea>
                                        </div>
                                        <div class="card-footer px-0 mx-auto d-flex justify-content-end">
                                            <button class="btn btn-secondary" type="submit"><span class="ml-1">글쓰기</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/inc/footer.jsp"%>
</body>
</html>