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

<form action="update" method="post">
번호 : <input type="text" name="no"><br>
제목 : <input type="text" name="title"><br>
내용 : <textarea name="content" rows="10" cols="60"></textarea><br>
<button>수정</button>
</form>

</body>
</html>
