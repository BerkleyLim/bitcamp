<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam12</title>
</head>
<body>
<h1>JSTL - c:import</h1>
<pre>
- HTTP 요청을 수행하고 그 결과를 저장하는 태그
    &lt;c:import url="URL"
        var="값을 저장할 때 사용할 이름"
        scope="저장소"&gt;
    &lt;/c:import&gt;
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>HTTP 요청을 수행한 후 그 결과를 가져오기</h2>
<c:url value="http://www.google.com"
        var="url1"
        scope="page">
    <c:param name="id" value="user01" />
    <c:param name="email" value="user01@test.com" />
    <c:param name="password" value="1111" />
</c:url>

<a href="${url1}">회원 등록</a><br>


</body>
</html>