<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>exam01</title>
</head>
<body>
<h1>exam01</h1>
<pre>
구동원리
클라이언트가 exam01.jsp 요청
    ===> [jsp 엔진]
      ===> .java 소스 생성 : 배치폴더(ex: tmp0)/work/....
        ===> [Java 컴파일러] 
          ===> .class 파일 생성 : 배치폴더(ex: tmp0)/work/....
            => service()를 호출하여 서블릿 실행!
</pre>
</body>
</html>










