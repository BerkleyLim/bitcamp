<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>exam07</title>
</head>
<body>
<h1>JSTL - c:choose</h1>
<pre>
- if ~ else  if ~ else if ~ else 또는 switch 기능을 하는 자바 코드를 만든다.
    &lt;c:choose&gt; 
        &lt;c:when test="true or false"&gt;콘텐트&lt;/c:when&gt;
        &lt;c:when test="true or false"&gt;콘텐트&lt;/c:when&gt;
        &lt;c:when test="true or false"&gt;콘텐트&lt;/c:when&gt;
        &lt;c:when test="true or false"&gt;콘텐트&lt;/c:when&gt;
        &lt;c:otherwise&gt;콘텐트&lt;/c:otherwise&gt;
        콘텐츠
    &lt;/c:choose&gt;
- test 속성
    : true 또는 false 값을 리턴하는 EL 태그가 온다.
- var 속성
    : 조건의 결과, true 또는 false를 저장할 때 사용하는 이름.
- scope 속성
    : 조건의 결과를 저장할 저장소
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${20 > 25}" var="r1" scope="page" >
</c:if>
r1 = ${pageScope.r1} <br>

<c:set var="age" value="-10" />

<c:choose>
    <c:when test="${age > 0 && age < 19}">
        미성년입니다.
    </c:when>
    <c:when test="${age >= 19 and age < 65}">
        성년입니다.
    </c:when>
    <c:when test="${age >= 65}">
        노인입니다.
    </c:when>
    <c:otherwise>
        나이 값이 없거나 잘못된 값입니다.
    </c:otherwise>
</c:choose>

</body>
</html>