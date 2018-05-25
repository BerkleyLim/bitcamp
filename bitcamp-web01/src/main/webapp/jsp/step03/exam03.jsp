<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>exam01</title>
</head>
<body>
<h1>JSP 전용 태그 : useBean</h1>
<pre>
jsp:useBean
- 태그를 이용하여 객체를 생성할 때 사용한다.
- 태그를 이용하여 저장소에서 객체를 꺼낼 때 사용한다.

포워딩 테스트
    error라는 오류 발생
<%--
error 라는 파라미터가 있을 때 다른 JSP 페이지로 포워딩시켜 보자!
--%>

</pre>

<%
if (request.getParameter("error") != null) {%>
    <jsp:forward page="exam02_error.jsp"></jsp:forward>
<%} %>
</body>
</html>