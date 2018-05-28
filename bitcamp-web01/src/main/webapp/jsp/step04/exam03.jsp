<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>exam03</title>
</head>
<body>
<h1>EL에서 저장소를 사용하는 방법 2</h1>
<pre>
저장소 이름 생략시 다음 순서로 값을 찾는다.

PageContext   ==> ServletRequest  ==>   HttpSession   ==> ServletContext  ==> null
</pre>

<%
// JSP에서 저장소 객체를 사용하려면 pageContext, request, sesion, application 이름으로 된
// 객체를 사용해야 한다.
pageContext.setAttribute("tel", "1111");
request.setAttribute("tel", "2222");
session.setAttribute("tel", "3333");
application.setAttribute("tel", "4444");

String fax = "1010";
%>
tel = ${tel} <br> 

로컬 변수는 EL 표기법을 사용하여 가져올 수 없다. <br>
fax = ${fax}
</body>
</html>