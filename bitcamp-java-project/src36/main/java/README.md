# 변경 내역
- build.gradle 변경
    - servlet 라이브러리 추가
    - "gradle eclipse" 실행 및 프로젝트 갱신
- DispatcherServlet.java 추가
    - DefaultApplicationContainer.java의 역할을 수행할 클래스를 서블릿에 규칙에 따라 만든다.
- ServerRequestAdapter.java 추가
    - 새 클래스인 HttpServletRequest를 이전 클래스에 맞추기 위함
- ServerResponseAdapter.java 추가
    - 새 클래스인 HttpServletResponse를 이전 클래스에 맞추기 위함
- ApplicationContainer.java 제거
- DefaultApplicationContainer.java 제거
- AppServer.java 제거
- HttpServer.java 제거
- 애플리케이션 배치

