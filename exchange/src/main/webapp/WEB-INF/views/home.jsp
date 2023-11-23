<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>EXCHANGE 환테크</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" ></script>
    </head>
    <body class="sb-nav-fixed">
        	<%-- <c:forEach items="${JPY }" var="jpy">
				<td>${jpy.exchageNm}</td>
				<td>${jpy.exchangePrice }</td>
				<td>${jpy.exchangeDate }</td>
		</c:forEach>  --%>
       	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/top.jsp" %>
	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/side.jsp" %>
	        
       
    </body>
</html>
