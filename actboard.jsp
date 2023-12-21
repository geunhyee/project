<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CARINA - carbon reduce now</title>

</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<form name="search"  action="${pageContext.request.contextPath}/actboard" method="post">
		<input type="hidden" name="curPage" value="${searchVO.curPage }">
		<input type="hidden" name="rowSizePerPage" value="${searchVO.rowSizePerPage }">
		<!-- 추가된 부분 -->
		<input type="hidden" name="totalPageCount" value="${searchVO.totalPageCount }">
	    <input type="hidden" name="firstPage" value="${searchVO.firstPage }">
	    <input type="hidden" name="lastPage" value="${searchVO.lastPage }">
    <!-- 추가된 부분 끝 -->
	<div class="row g-0 justify-content-md-center mt-10">
		<div class="col-sm-1 mb-3 ml-4">
		
		<select id="searchType" name="searchOption" class="form-control input-sm">
		    <option value="T" ${searchVO.searchOption eq "T" ? "selected='selected'":"" }>제목</option>
		    <option value="W" ${searchVO.searchOption eq "W" ? "selected='selected'":"" }>작성자</option>
		    <option value="C" ${searchVO.searchOption eq "C" ? "selected='selected'":"" }>내용</option>
		</select> 
		
			<!-- <div class="btn-group mb-2">
				<button type="button"
					class="btn btn-tertiary dropdown-toggle dropdown-toggle-split"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
					style="width: 150px">제목</button>
				<div class="dropdown-menu dropdown-menu-sm">
					<a class="dropdown-item" href="#">작성자</a> <a class="dropdown-item"
						href="#">내용</a>
				</div>
			</div> -->
		</div>
		
		<!-- 검색부분 -->
		<div class="col-sm-5 mb-3">
			<div class="input-group mb-4">
				<input class="form-control"  name="keyword"
					placeholder="검색어를 입력하세요" aria-label="search"  value="${searchVO.keyword}"  type="search">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="submit"
						id="button-addon2" style="width: 120px">
						<span class="fas fa-search"></span>
					</button>
				</div>
			</div>
		</div>
	</div>
	</form>
	
	<div class="container mb-5">
		<table class="table shadow-soft rounded text-center">
			<colgroup>
				<col width="10%" />
				<col />
				<col width="10%" />
				<col width="15%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
		</thead>
			<tbody>
			<c:forEach items="${actboardList }"  var="act">
			<tr>
				<td>${act.boardNo }</td>
				<td><a href="<c:url value="/actdetail?boardNo=${act.boardNo }"/>">${act.boardTitle }</a></td>
				<td>${act.memId }</td>
				<td>${act.createDate eq null ? act.updateDate : act.createDate }</td>
				<td>${act.actHit }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="d-grid gap-2 d-md-flex justify-content-md-end mr-10">
		<a href="${pageContext.request.contextPath }/actboardwrite">
		<button class="btn btn-primary text-secondary" type="button"
			style="width: 100%;">실천일지쓰기</button>
			</a>
	</div>

<!-- 페이지네이션 -->
                     <div>
                     <nav aria-label="Page navigation example">
   							 <ul class="pagination justify-content-center">
                      
                           <!-- 이전 페이지 -->
                           <c:if test="${searchVO.firstPage !=1 }">
                              <li class="page-item"><a class="page-link"
                                 href="actboard?curPage=${searchVO.firstPage-1 }"
                                 data-page="${searchVO.firstPage-1 }" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                              </a></li>
                           </c:if>
                           <!-- 특정페이지 이동 -->
                           <c:forEach begin="${searchVO.firstPage }"
                              end="${searchVO.lastPage }" var="i">
                              <c:if test="${searchVO.curPage != i }">
                                  <li class="page-item"><a class="page-link"
                                    href="actboard?curPage=${i}" data-page="${i}">${i}</a></li> 
                              </c:if>
                              <c:if test="${searchVO.curPage == i }">
                                 <li class="page-item active"><a class="page-link"
                                    href="#" data-page="${i}">${i}</a></li>
                              </c:if>
                           </c:forEach>
                           <li class="page-item"><a class="page-link" href="#"
                              aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                           </a></li>
                           <!-- 다음  페이지  -->
                           <c:if test="${searchVO.lastPage!=searchVO.totalPageCount }">
                              <li class="page-item"><a class="page-link"
                                 href="actboard?curPage=${searchVO.lastPage+1 }"
                                 data-page="${searchVO.lastPage+1 }" aria-label="Next"> <span
                                    aria-hidden="true">&raquo;</span>
                              </a></li>
                           </c:if>
                        </ul>
                        </nav>
                     </div>

	

	<%@include file="/WEB-INF/inc/footer.jsp"%>
</body>

<!-- 기존 -->
 <script type="text/javascript">
        let search_form = $("form[name='search']");
        let cur_page = search_form.find('input[name="curPage"]');
    $(document).ready(function () {
        $("#id_rowSizePerPage").change(
        		function () {
            cur_page.val(1);
            search_form.find('input[name="rowSizePerPage"]').val($(this).val());
            search_form.submit();
        });

        search_form.find("button[type='submit']").click(function (e) {
            e.preventDefault(); // 디폴트 행동 취소
            cur_page.val(1);
            search_form.submit();
        });

        $('ul.pagination li a[data-page]').click(function (e) {
            e.preventDefault();
            cur_page.val($(this).data('page'));
            search_form.submit();
        });
    });
</script>
</html>