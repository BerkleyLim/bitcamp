// 맵
package ex1

// 1) 맵 데이터 할당과 사용
// 맵 만들기
map1 = ["홍길동":20, "임꺽정":30, "유관순":16]
println map1["홍길동"] // 변수.[키] 형태로 값 추출
println map1.홍길동  // 변수.키 형태로 값 추출

// map1의 클래스를 알아내기
println map1.getClass()  // java.util.LinkedHashMap 출력

// 맵의 값 변경
map1.홍길동 = 40
println map1.홍길동

// 빈 맵 만들기
emptyMap = [:]
