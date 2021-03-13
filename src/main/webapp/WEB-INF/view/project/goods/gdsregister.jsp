<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="/project/css/goods.css">
<link rel="preconnect" href="https://fonts.gstatic.com">    
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<header>
		<%@ include file="../header.jsp" %>
	</header>
	<div class="content-title">
		<h1>상품 등록</h1>
	</div>
	<div class="table-div">
		<form id="frm" action="/football/goods/register" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="gds_name">상품명</label></td>
					<td><input type="text" name="gds_name" id="gds_name" autocomplete="off"></td>
				</tr>
				<tr>
					<td><label for="picture_url">사진</label></td>
					<td><input type="file" name="file" id="picture_url"></td>
				</tr>
				<tr>
					<td><label for="gds_price">가격</label></td>
					<td><input type="text" name="gds_price" id="gds_price"></td>
				</tr>
				<tr>
					<td><label for="gds_descr">설명</label></td>
					<td><textarea name="gds_descr" id="gds_descr" cols="26" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" class="btn-td">
					<button type="button" id="btn" class="reg-btn">등록</button>
					<button type="button" id="btn" class="back-btn">뒤로</button>	
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script src="/project/js/gds_register.js"></script>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
</html>