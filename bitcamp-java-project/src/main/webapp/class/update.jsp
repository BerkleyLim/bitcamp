<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 수정</title>
</head>
<body>
<!-- 수정 -->
<h1>게시물 수정</h1>

<form action="update" method="get">
수업명 : <input type="text" name="title"><br>
시작일 : <input type="text" name=startDate><br>
종료일 : <input type="text" name="endDate"><br>
수업장소 : <input type="text" name="room"><br>
<button>수정</button>
</form>

</body>
</html>
