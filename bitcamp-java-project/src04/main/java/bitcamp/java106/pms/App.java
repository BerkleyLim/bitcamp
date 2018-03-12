package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.util.Scanner;
import bitcamp.java106.pms.domain.*;    // 모든 클래스 포함

public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner sc = new Scanner(System.in);
        String casebycase = "";  // 명령어 입력 값 저장

        // 0) 미리 Team / ID 클래스를 만들고,
        //    Team의 인터페이스 TeamInput, 
        //    ID의 인터페이스 IDInput를 만든 후
        //    클래스 정의한다!!
        Team[] t = new Team[1000];
        ID[] i = new ID[1000];

        // 아이디 카운터 및 팀 카운터
        int idCount = 0;
        int teamCount = 0;

        // 팀의 대한 저장용 변수 선언
        String team, description, maxQty, startDate, endDate;
        // 아이디의 대한 저장용 변수 선언
        String id, email, passWord;

        // 1) 무한루프
        while(true) {

            // 2) 처음부터 끝까지 조건을 입력
            System.out.print("명령> ");
            casebycase = sc.nextLine();

            // 3) 다음 조건문 구성하기
            if(casebycase.equals("help")) {
                // 6) help 입력 수행
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
            } else if(casebycase.equals("team/add")) {
                // 7) team/add 명령어 수행
                System.out.print("팀명? ");
                team = sc.nextLine();

                System.out.print("설명? ");
                description = sc.nextLine();

                System.out.print("최대인원? ");
                maxQty = sc.nextLine();

                System.out.print("시작일? ");
                startDate = sc.nextLine();

                System.out.print("종료일? ");
                endDate = sc.nextLine();

                // 클래스 생성
                t[teamCount] = new Team(team, description, 
                            maxQty, startDate, endDate);

                // 먼저 변수 지정
                t[teamCount].setTeam(team);
                t[teamCount].setDescription(description);
                t[teamCount].setMaxQty(maxQty);
                t[teamCount].setStartDate(startDate);
                t[teamCount].setEndDate(endDate);

                teamCount++;

            } else if(casebycase.equals("team/list")) {
                // 8) team/list 명령어 수행
                for(int ir = 0; ir < teamCount; ir++){
                    System.out.println(t[ir].getTeam() + ", " + 
                      t[ir].getMaxQty() + ", " + t[ir].getStartDate()
                      + " ~ " + t[ir].getEndDate());                 
                }

            } else if(casebycase.contains("team/view")) {
                // 11) team/view 팀명 명령어 수행

                // 팀명을 입력하시기 바랍니다.
                if(casebycase.equals("team/view")) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                } 
                int ir = 0;
                while(ir < teamCount) {
                    if(casebycase.contains(t[ir].getTeam())) {
                        System.out.println("팀명: " + t[ir].getTeam());
                        System.out.println("설명: " + t[ir].getDescription());
                        System.out.println("최대인원: " + t[ir].getMaxQty());
                        System.out.println("기간: " + t[ir].getStartDate()
                             + " ~ " + t[ir].getEndDate()); 
                        System.out.println();

                        break;    
                    }
                    ir++;
                }

                if(ir == teamCount) {
                    System.out.println("해당 이름을 갖는 팀이 없습니다.");
                }


            } else if(casebycase.toLowerCase().equals("member/add")) {
                // 9) team/view 팀명 명령어 수행
                System.out.print("아이디? ");
                id = sc.nextLine();

                System.out.print("이메일? ");
                email = sc.nextLine();

                System.out.print("암호? ");
                passWord = sc.nextLine();

                i[idCount] = new ID(id, email, passWord);

                idCount++;

            } else if(casebycase.equals("member/list")) {
                // 10) team/view 팀명 명령어 수행
                for(int ir = 0; ir < idCount; ir++) {
                    System.out.println(i[ir].getID() + ", " +
                        i[ir].getEmail() + ", " + i[ir].getPassWord());
                }
                
            } else if(casebycase.contains("member/view")) {
                // 12) member/view 팀명 명령어 수행

                // 팀명을 입력하시기 바랍니다.
                if(casebycase.equals("member/view")) {
                    System.out.println("아이디를 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                } 
                int ir = 0;
                while(ir < idCount) {
                    if(casebycase.contains(i[ir].getID())) {
                        System.out.println("아이디: " + i[ir].getID());
                        System.out.println("이메일: " + i[ir].getEmail());
                        System.out.println("암호: " + i[ir].getPassWord());
                        System.out.println();

                        break;    
                    }
                    ir++;
                }

                if(ir == idCount) {
                    System.out.println("해당 아이디의 회원이 없습니다.");
                }

            } else if(casebycase.equals("quit")) {
                // 13) 만일 quit를 입력했을 경우
                System.out.println("안녕히가세요!");
                System.out.println();
                break;
            } else {
                 // 4) 만일 명령어가 올바르지 않을 경우
                System.out.println("명령어가 올바르지 않습니다.");
                System.out.println();
            }

            System.out.println();
                
        }
    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -classpath bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
종료 : quit


명령> team/add
팀명? 비트비트1
설명? 자바 프로젝트 팀 중 한명
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20

명령> team/add
팀명? 비트비트2
설명? 자바 프로젝트 팀2
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20

명령> team/list
비트비트1, 5, 2018-05-05 ~ 2018-08-20
비트비트2, 5, 2018-05-05 ~ 2018-08-20

명령> team/view 비트비트2
팀명: 비트비트2
설명: 자바 프로젝트 팀2
최대인원: 5
기간: 2018-05-05 ~ 2018-08-20


명령> team/view 비트오케이
해당 이름을 갖는 팀이 없습니다.

명령> team/view
팀명을 입력하시기 바랍니다.

명령> member/add
아이디? hong
이메일? hong@test.com
암호? 1111

명령> member/list
hong, hong@test.com, 1111

명령> member/add
아이디? leem
이메일? leem@test.com
암호? 1111

명령> member/list
hong, hong@test.com, 1111
leem, leem@test.com, 1111

명령> member/view leem
아이디: leem
이메일: leem@test.com
암호: 1111


명령> member/view okok
해당 아이디의 회원이 없습니다.

명령> member/view
아이디를 입력하시기 바랍니다.

명령> memeber/list
명령어가 올바르지 않습니다.


명령> qirus a
명령어가 올바르지 않습니다.


명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
종료 : quit


명령> quit
안녕히가세요!

*/

/*
<강사님 코드>

// 파일 : Team.java
package bitcamp.java106.pms.domain;

public class Team {

}


// 파일 : App.java



// ver0.1 - 명령 입력 프롬프트를 출력한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Sytem.out.print("명령> ");
    }
}
 
// ver0.2 - 사용자 입력을 받아 출력한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Sytem.out.print("명령> ");
        String input = keyScan.nextLine();

        System.out.println(input);
    }
}


// ver0.3 - 사용자로부터 입력 받는 것을 무한 반복한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine();

            System.out.println(input);
        }

    }
}

// ver0.4 - quit 명령어 입력 시 반복문을 종료한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine();

            if(input.toLowerCase().equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.5 - help 명령을 구현한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            // 대문자를 저절로 소문자로 가공한다.

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.6 - team/add 명령을 구현
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            // 대문자를 저절로 소문자로 가공한다.

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (input.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;


                //System.out.printf("%s, %s, %d, %s, %s\n", team.name, 
               // team.description, team.name, team.startDate, team.endDate);
                System.out.println();
                
                continue;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.7 - team/list 명령을 구현
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            // 대문자를 저절로 소문자로 가공한다.

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (input.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;


                //System.out.printf("%s, %s, %d, %s, %s\n", team.name, 
               // team.description, team.name, team.startDate, team.endDate);
                System.out.println();
                
                continue;
            } else if (input.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.8_1 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String input = arr[0];
            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (input.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;


                //System.out.printf("%s, %s, %d, %s, %s\n", team.name, 
               // team.description, team.name, team.startDate, team.endDate);
                System.out.println();
                
                continue;
            } else if (input.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (input.equals("team/view")) {

            }

            System.out.println(input);
        }
        
    }
}

// ver0.8_2 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {

            }

            System.out.println(menu);
        }
        
    }
}

// ver0.8_3 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");
                System.out.println(option);

            }

            System.out.println(menu);
        }
        
    }
}

// ver0.8_3 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");
                System.out.println(option);

            }

            System.out.println(menu);
        }
        
    }
}

package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.util.Scanner;
import bitcamp.java106.pms.domain.*;    // 모든 클래스 포함

public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner sc = new Scanner(System.in);
        String casebycase = "";  // 명령어 입력 값 저장

        // 0) 미리 Team / ID 클래스를 만들고,
        //    Team의 인터페이스 TeamInput, 
        //    ID의 인터페이스 IDInput를 만든 후
        //    클래스 정의한다!!
        Team[] t = new Team[1000];
        ID[] i = new ID[1000];

        // 아이디 카운터 및 팀 카운터
        int idCount = 0;
        int teamCount = 0;

        // 팀의 대한 저장용 변수 선언
        String team, description, maxQty, startDate, endDate;
        // 아이디의 대한 저장용 변수 선언
        String id, email, passWord;

        // 1) 무한루프
        while(true) {

            // 2) 처음부터 끝까지 조건을 입력
            System.out.print("명령> ");
            casebycase = sc.nextLine();

            // 3) 다음 조건문 구성하기
            if(casebycase.equals("help")) {
                // 6) help 입력 수행
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
            } else if(casebycase.equals("team/add")) {
                // 7) team/add 명령어 수행
                System.out.print("팀명? ");
                team = sc.nextLine();

                System.out.print("설명? ");
                description = sc.nextLine();

                System.out.print("최대인원? ");
                maxQty = sc.nextLine();

                System.out.print("시작일? ");
                startDate = sc.nextLine();

                System.out.print("종료일? ");
                endDate = sc.nextLine();

                // 클래스 생성
                t[teamCount] = new Team(team, description, 
                            maxQty, startDate, endDate);

                // 먼저 변수 지정
                t[teamCount].setTeam(team);
                t[teamCount].setDescription(description);
                t[teamCount].setMaxQty(maxQty);
                t[teamCount].setStartDate(startDate);
                t[teamCount].setEndDate(endDate);

                teamCount++;

            } else if(casebycase.equals("team/list")) {
                // 8) team/list 명령어 수행
                for(int ir = 0; ir < teamCount; ir++){
                    System.out.println(t[ir].getTeam() + ", " + 
                      t[ir].getMaxQty() + ", " + t[ir].getStartDate()
                      + " ~ " + t[ir].getEndDate());                 
                }

            } else if(casebycase.contains("team/view")) {
                // 11) team/view 팀명 명령어 수행

                // 팀명을 입력하시기 바랍니다.
                if(casebycase.equals("team/view")) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                } 
                int ir = 0;
                while(ir < teamCount) {
                    if(casebycase.contains(t[ir].getTeam())) {
                        System.out.println("팀명: " + t[ir].getTeam());
                        System.out.println("설명: " + t[ir].getDescription());
                        System.out.println("최대인원: " + t[ir].getMaxQty());
                        System.out.println("기간: " + t[ir].getStartDate()
                             + " ~ " + t[ir].getEndDate()); 
                        System.out.println();

                        break;    
                    }
                    ir++;
                }

                if(ir == teamCount) {
                    System.out.println("해당 이름을 갖는 팀이 없습니다.");
                }


            } else if(casebycase.toLowerCase().equals("member/add")) {
                // 9) team/view 팀명 명령어 수행
                System.out.print("아이디? ");
                id = sc.nextLine();

                System.out.print("이메일? ");
                email = sc.nextLine();

                System.out.print("암호? ");
                passWord = sc.nextLine();

                i[idCount] = new ID(id, email, passWord);

                idCount++;

            } else if(casebycase.equals("member/list")) {
                // 10) team/view 팀명 명령어 수행
                for(int ir = 0; ir < idCount; ir++) {
                    System.out.println(i[ir].getID() + ", " +
                        i[ir].getEmail() + ", " + i[ir].getPassWord());
                }
                
            } else if(casebycase.contains("member/view")) {
                // 12) member/view 팀명 명령어 수행

                // 팀명을 입력하시기 바랍니다.
                if(casebycase.equals("member/view")) {
                    System.out.println("아이디를 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                } 
                int ir = 0;
                while(ir < idCount) {
                    if(casebycase.contains(i[ir].getID())) {
                        System.out.println("아이디: " + i[ir].getID());
                        System.out.println("이메일: " + i[ir].getEmail());
                        System.out.println("암호: " + i[ir].getPassWord());
                        System.out.println();

                        break;    
                    }
                    ir++;
                }

                if(ir == idCount) {
                    System.out.println("해당 아이디의 회원이 없습니다.");
                }

            } else if(casebycase.equals("quit")) {
                // 13) 만일 quit를 입력했을 경우
                System.out.println("안녕히가세요!");
                System.out.println();
                break;
            } else {
                 // 4) 만일 명령어가 올바르지 않을 경우
                System.out.println("명령어가 올바르지 않습니다.");
                System.out.println();
            }

            System.out.println();
                
        }
    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -classpath bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
종료 : quit


명령> team/add
팀명? 비트비트1
설명? 자바 프로젝트 팀 중 한명
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20

명령> team/add
팀명? 비트비트2
설명? 자바 프로젝트 팀2
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20

명령> team/list
비트비트1, 5, 2018-05-05 ~ 2018-08-20
비트비트2, 5, 2018-05-05 ~ 2018-08-20

명령> team/view 비트비트2
팀명: 비트비트2
설명: 자바 프로젝트 팀2
최대인원: 5
기간: 2018-05-05 ~ 2018-08-20


명령> team/view 비트오케이
해당 이름을 갖는 팀이 없습니다.

명령> team/view
팀명을 입력하시기 바랍니다.

명령> member/add
아이디? hong
이메일? hong@test.com
암호? 1111

명령> member/list
hong, hong@test.com, 1111

명령> member/add
아이디? leem
이메일? leem@test.com
암호? 1111

명령> member/list
hong, hong@test.com, 1111
leem, leem@test.com, 1111

명령> member/view leem
아이디: leem
이메일: leem@test.com
암호: 1111


명령> member/view okok
해당 아이디의 회원이 없습니다.

명령> member/view
아이디를 입력하시기 바랍니다.

명령> memeber/list
명령어가 올바르지 않습니다.


명령> qirus a
명령어가 올바르지 않습니다.


명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
종료 : quit


명령> quit
안녕히가세요!

*/

/*
<강사님 코드>

// 파일 : Team.java
package bitcamp.java106.pms.domain;

public class Team {

}


// 파일 : App.java



// ver0.1 - 명령 입력 프롬프트를 출력한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Sytem.out.print("명령> ");
    }
}
 
// ver0.2 - 사용자 입력을 받아 출력한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Sytem.out.print("명령> ");
        String input = keyScan.nextLine();

        System.out.println(input);
    }
}


// ver0.3 - 사용자로부터 입력 받는 것을 무한 반복한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine();

            System.out.println(input);
        }

    }
}

// ver0.4 - quit 명령어 입력 시 반복문을 종료한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine();

            if(input.toLowerCase().equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.5 - help 명령을 구현한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            // 대문자를 저절로 소문자로 가공한다.

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.6 - team/add 명령을 구현
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            // 대문자를 저절로 소문자로 가공한다.

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (input.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;


                //System.out.printf("%s, %s, %d, %s, %s\n", team.name, 
               // team.description, team.name, team.startDate, team.endDate);
                System.out.println();
                
                continue;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.7 - team/list 명령을 구현
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            // 대문자를 저절로 소문자로 가공한다.

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (input.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;


                //System.out.printf("%s, %s, %d, %s, %s\n", team.name, 
               // team.description, team.name, team.startDate, team.endDate);
                System.out.println();
                
                continue;
            } else if (input.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            }

            System.out.println(input);
        }
        
    }
}

// ver0.8_1 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String input = arr[0];
            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (input.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;


                //System.out.printf("%s, %s, %d, %s, %s\n", team.name, 
               // team.description, team.name, team.startDate, team.endDate);
                System.out.println();
                
                continue;
            } else if (input.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (input.equals("team/view")) {

            }

            System.out.println(input);
        }
        
    }
}

// ver0.8_2 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {

            }

            System.out.println(menu);
        }
        
    }
}

// ver0.8_3 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");
                System.out.println(option);

            }

            System.out.println(menu);
        }
        
    }
}

// ver0.8_4 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
    // 4단계: 팀명이 없으면 안내 문구를 출력한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");

                if(option == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }

                System.out.println();
            }

            System.out.println(menu);
        }
        
    }
}

// ver0.8_5 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
    // 4단계: 팀명이 없으면 안내 문구를 출력한다.
    // 5단계: 팀명으로 배열을 뒤져 팀 정보를 찾는다.
    // 6단계: 팀명으로 검색할 때 대소문자로 구분하지 말라.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");

                if(option == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }

                for (int i = 0; i < teamIndex; i++) {
                    if (option.equals(teams[i].name)) {
                        System.out.printf("팀명 : %s\n", teams[i].name);
                        System.out.printf("설명 : %s\n", teams[i].description);
                        System.out.printf("최대인원 : %d\n", teams[i].maxQty);
                        System.out.printf("기간 : %s ~ %s\n",
                            teams[i].startDate, teams[i].endDate);
                        break;
                    }
                }

                System.out.println();
            }

            System.out.println(menu);
        }
        
    }
}


// ver0.8_6 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
    // 4단계: 팀명이 없으면 안내 문구를 출력한다.
    // 5단계: 팀명으로 배열을 뒤져 팀 정보를 찾는다.
    // 6단계: 팀명으로 검색할 때 대소문자로 구분하지 말라.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");

                if(option == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }

                for (int i = 0; i < teamIndex; i++) {
                    if (option.equals(teams[i].name.toLowerCase())) {
                        System.out.printf("팀명 : %s\n", teams[i].name);
                        System.out.printf("설명 : %s\n", teams[i].description);
                        System.out.printf("최대인원 : %d\n", teams[i].maxQty);
                        System.out.printf("기간 : %s ~ %s\n",
                            teams[i].startDate, teams[i].endDate);
                        break;
                    }
                }

                System.out.println();
            }

            System.out.println(menu);
        }
        
    }
}


// ver0.8_7 - team/view 명령을 구현
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력받을 값을 별도의 변수로 저장
    // 4단계: 팀명이 없으면 안내 문구를 출력한다.
    // 5단계: 팀명으로 배열을 뒤져 팀 정보를 찾는다.
    // 6단계: 팀명으로 검색할 때 대소문자로 구분하지 말라.
    // 7단계: 팀명이 일치하는 팀이 없으면, 안내 문구를 출력한다.
package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 레퍼런스 생성(클래스 선언)
        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
            Sytem.out.print("명령> ");

            // 대문자를 저절로 소문자로 가공한다. , 
            // split(" "); -> 입력 받은 문자열은 공백의 기준으로 짤려라
            // ex) 입력을 "aaa bbb ccc" 라 한다.면
            // arr[0] = aaa, arr[1] = bbb, arr[2] = ccc
            // 값으로 저장한다. 
            // 사용 이유는 : 명령과 검색어로 구분하기 위해서.
            // 일단 다음올 진행 전 기존에 기능이 잘 되는지 확인!!

            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            String option = null;   // 주소 없음

            if(arr.length == 2) {
                option = arr[1];
            }


            if(menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (menu.equal("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue;
            } else if (menu.equals("team/add")) {
                System.out.println("[팀 정보 입력]");
                
                // 먼저 팀 클래스를 만들고 생성해라!!
                Team team = new Team();
                

                System.out.print("팀명? ");
                team.name = keyScan.nextLine();

                System.out.print("설명? ");
                team.description = keyScan.nextLine();

                System.out.print("최대인원? ");
                team.name = keyScan.nextInt();
                keyScan.nextLine();

                System.out.print("시작일? ");
                team.startDate = keyScan.nextLine();
                
                System.out.print("팀명? ");
                team.endDate = keyScan.nextLine();

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;

                System.out.println();
                
                continue;
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s, %s\n", 
                        teams[i].name,  teams[i].name, 
                        teams[i].startDate, teams[i].endDate);                   
                }
                System.out.println();
                countinue;
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");

                Team team = null;

                if(option == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }

                for (int i = 0; i < teamIndex; i++) {
                    if (option.equals(teams[i].name.toLowerCase())) {
                        team = teams[i];
                        break;
                    }
                }

                if(team == null) {
                    System.out.println("해당 이름의 팀이 없습니다.");
                } else {
                        System.out.printf("팀명 : %s\n", team.name);
                        System.out.printf("설명 : %s\n", team.description);
                        System.out.printf("최대인원 : %d\n", team.maxQty);
                        System.out.printf("기간 : %s ~ %s\n",
                            teams[i].startDate, team.endDate);
                }

                System.out.println();
            }

            System.out.println(menu);
        }
        
    }
}


*/
