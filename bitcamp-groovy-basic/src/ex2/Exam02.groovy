// 분기문 - switch
package ex2

switch(500.5) {
case "aaa": println "aaa"; break                // "aaa" 라는 문자(열)일경우
case 50: println "50 입니다."; break              // 50 일 경우
case [2, 3, 5, 7]: println "소수입니다."; break    // 2, 3, 5, 7 일 경우
case 100..200: println "100 ~ 200 입니다."; break // 100 ~ 200 일 경우
case Number: println "숫자입니다."; break          // 정수나 실수형일 경우
case String: println "문자입니다."; break          // 문자(열)일 경우
default: println: "기타입니다."
}