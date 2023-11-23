<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  

<!DOCTYPE html>
<html lang="en">
    <head>
    <!-- 모든 화면에 포함시키는 부분 -->
     <%@include file="/WEB-INF/inc/top.jsp" %>
     	
    <!-- Contact Section-->
    
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>지갑</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
 
                                <div class="sb-nav-link-icon" style="margin-top: 100px"><i class="fas fa-table"></i></div>
                                
                            </a>
                        </div>
                    </div>
             
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-6">
                        <h1 class="mt-4">지갑</h1>
                        
                    
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                내 거래 기록
                            </div>
                            <div class="card-body" >
                                <table id="datatablesSimple">
                                    <thead>
                                      <tr>
                                    	<th>날짜</th>
                                    	<th>화폐종류</th>
                                    	<th>매매금액</th>
                                    	<th>원화금액</th>
                                    </tr>
                                    <tbody>
                                        <tr>
               							 <td><input type="text" name="date"></td>
							             <td><input type="text" name="currency"></td>
							             <td><input type="text" name="amount"></td>
							             <td><input type="text" name="koreanWon"></td>
							             <td><button onclick="addRow()">추가</button></td> <!-- 추가 버튼 -->
                                        </tr>

                                    </tbody>
                                    </thead>
                                    
                                </table>
                            </div>
                            
        
        
                        </div>
                    </div>
                </main>
               
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        
        <!-- 사용자 입력값 -->
       <script>
   		function addRow() {
        var tableBody = document.querySelector("#datatablesSimple tbody");
        var newRow = document.createElement("tr");
        newRow.innerHTML = `
            <td><input type="text" name="date"></td>
            <td><input type="text" name="currency"></td>
            <td><input type="text" name="amount"></td>
            <td><input type="text" name="koreanWon"></td>
            <td><button onclick="removeRow(this)">삭제</button></td> <!-- 삭제 버튼 -->
        `;
        tableBody.appendChild(newRow);
    	}

   	 function removeRow(button) {
        var row = button.parentNode.parentNode;
        row.remove();
    }
</script>
 
        
    </body>
</html>
