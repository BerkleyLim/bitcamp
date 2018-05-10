// 리스트
package ex1

// ArrayList 만들기
scoreList = [100, 90, 50, 70]  // ArrayList 객체가 생성됨

// ArrayList 값 꺼내기
println scoreList[2]        // 배열처럼 사용 가능 
println scoreList.get(2)    // 원래대로 ArrayList의 get() 호출 가능
println scoreList.size()    // 결과는 4

nameList = ["홍길동", "임꺽정", "장보고"]
println nameList[1]

// 빈 리스트 생성
emptyList = []

// 배열은 같은 타입의 값만 저장할 수 있지만,
// ArrayList는 모든 타입의 값을 저장할 수 있다.
// 따라서 다음은 ArrayList 임을 증명한다.
list2 = ["홍길동", 100, 100, 100, "임꺽정", 90, 90, 90]
println list2[0]
println list2[1]





