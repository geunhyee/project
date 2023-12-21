<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>CARINA - carbon reduce now</title>
</head>
<body>
    <%@include file="/WEB-INF/inc/top.jsp"%>
    <div class="container">
        <div class="row align-items-center justify-content-center mt-7">
            <div class="col-md-12 col-lg-12 mb-5">
                <!-- Contact Card -->
                <div class="card bg-primary shadow-soft border-light p-2 p-md-3 p-lg-5">
                    <div class="row mt-5 justify-content-center">
                    </div> 
                    <section class="page-section" id="contact">
                        <div class="container" style="margin-top: -30px;">
                            <!-- Contact Section Form-->
                            <div class="row justify-content-center" style="margin-bottom: 10px;">
                                <div class="col-lg-8 col-xl-7">
                                    <form action="<c:url value='/freeboardEditDo' />" method="post">
                                        <input type="hidden" name="boardNo" value="${freeboard.boardNo}" />
                                        <!-- title input-->
                                        <div class="mb-3">
                                            <div class="form-group mb-4">
                                                <label for="title">제목</label>
                                                <input type="text" class="form-control" id="title" name="boardTitle" value="${freeboard.boardTitle}" />
                                            </div>
                                        </div>
                                        <fieldset disabled="disabled">
                                            <div class="mb-3">
                                                <div class="form-group">
                                                    <label for="memId">작성자</label>
                                                    <input type="text" class="form-control" id="memId" name="memId" value="${freeboard.memId}" readonly />
                                                </div>
                                            </div> 
                                            <div class="mb-3">
                                                <div class="form-group">
                                                    <label for="createDate">작성일</label>
                                                    <h6 id="createDate">${freeboard.createDate}</h6>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <div class="form-group">
                                                    <label for="updateDate">수정일</label>
                                                    <h6 id="updateDate">${freeboard.updateDate}</h6>
                                                </div>
                                            </div>  
                                        </fieldset>
                                        <!-- content input-->
                                        <div class="mb-3">
                                            <textarea class="form-control" name= "boardContent" rows="20" >${freeboard.boardContent}</textarea>
                                        </div>
                                        <!-- End of Form -->
                                        <div class="card-footer px-0 mx-auto d-flex justify-content-end mt-3">
										    <c:if test="${sessionScope.login.memId == freeboard.memId}">
										        <button class="btn btn-primary btn-sm ml-2" type="submit">
										            <span class="ml-1">수정</span>
										        </button>
										    </c:if>
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
