<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
 
    <title>로그인</title>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" ></script>
</head>
<%@include file="/WEB-INF/inc/top.jsp" %>

<body class="bg-dark">

    <main>
  
        <div class="container">	
         
            <div class="row justify-content-center">
           
                <div class="col-lg-5">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header"><h3 class="text-center font-weight-light my-4">로그인</h3></div>
                        <div class="card-body">
                            <form method="post" action='<c:url value="/loginDo"/>' >                           
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="memId" name="memId" type="text" value="${cookie.rememberId.value }"
                                     placeholder="아이디를 입력해주세요." />
                                    <label for="memId">아이디</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="memPw" name="memPw" type="password" placeholder="비밀번호를 입력해주세요." />
                                    <label for="memPw">비밀번호</label>
                                </div>
                                <div class="form-check mb-3">
                                    <input class="form-check-input" id="remember" name="remember" type="checkbox" ${cookie.rememberId.value==null?"":"checked" } />
                                    <label class="form-check-label" for="remember">아이디 기억하기</label>
                                    <input name="fromUrl" type="hidden" value="${fromUrl }" />
                                </div>
                                <div class="text-center">
                                <button class="btn btn-primary" type="submit">로그인</button>
                   				 </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
 
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</body>
</html>