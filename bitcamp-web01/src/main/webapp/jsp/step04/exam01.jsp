<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>exam01</title>
</head>
<body>
<h1>EL(Expression Language)</h1>
<pre>
- OGNL 표기법을 사용하여 자바 객체의 값을 다루는 기술
- 간단한 연산 기능과 메서드 호출 기능을 제공

OGNL(Object Graph Navigation Language)
- 자바 객체의 값을 꺼내고 설정하는 표현법이다.
- 예) 객체명.프로퍼티명.프로퍼티명

EL 문법
    $ { OGNL 표기법 }

객체 값 꺼내기
    $ { 객체명 . 프로퍼티명 }
    $ { 객체명 . [ "프로퍼티명" ] }
    $ { 객체명 . [ '프로퍼티명' ] }
</pre>

<%
pageContext.setAttribute("name", "홍길동");
pageContext.setAttribute("age", 20); // 오토박싱(auto-boxing)
%>

$ { pageScope.name } <br>
$ { pageScope["name"]} <br>
$ { pageScope['name']} <br>

$ { pageScope.age } <br>

해당 객체나 프로퍼티를 찾을 수 없으면 빈 문자열이 리턴된다. <br>
$ { pageScope.tel } <br>

</body>
</html>