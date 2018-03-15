package bitcamp.java106.pms.controller;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;

public class MemberController {
    // 이 클래스를 사용하려면 keyboard 스캐너가 있어야 한다.
    // 이 클래스를 사용하기 전에 스캐너를 설정하라!
    public static Scanner keyScan;

    private static Member[] members = new Member[1000];
    private static int memberCount = 0;  // 맴버 입력 횟수

    public static int getMemberIndex(String id) {
        for(int i = 0; i < memberCount; i++) {
            if(members[i] == null) continue;
            if(id.equals(members[i].getID().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }


    // 회원 추가
    public static void onMemberAdd() {
        String id, email, passWord; // 임시 변수 지정
        
        System.out.print("아이디? ");
        id = keyScan.nextLine();

        System.out.print("이메일? ");
        email = keyScan.nextLine();

        System.out.print("암호? ");
        passWord = keyScan.nextLine();

        // 또 다른 임시 객체 생성
        Member member = new Member(); 
        member.setID(id);
        member.setEmail(email);
        member.setPassWord(passWord);

        // 임시 객체에 저장 한 것을 월래 배열에 저장
        members[memberCount++] = member;  
        // 월래 팀에 저장할 클래스 배열에 저장
    }

    // 회원 정보 조회
    public static void onMemberList() {
        for(int i =0; i < memberCount; i++) {
            if (members[i] == null) continue;
            System.out.println(members[i].getID() + ", "
             + members[i].getEmail() + ", " + members[i].getPassWord());
        }
    }

    // 해당 회원 상세조회
    public static void onMemberView(String name) {
        // team/view만 입력한 경우
        if(name == null) {
            System.out.println("아이디를 입력하세요.");
            System.out.println();
            return;
        }

    
        int i = getMemberIndex(name);
        
        if(i == -1) {
            System.out.println("해당 이름을 갖는 아이디가 없습니다.");
        } else {
            Member member = members[i];
            System.out.println("아이디 : " + member.getID());
            System.out.println("이메일 : " 
                        + member.getEmail());
            System.out.println("암호 : " 
                        + member.getPassWord());
            System.out.println();
        }
    }

    // ----------------------------------------------
    // 유지보수 추가


    // 회원 정보 수정
    public static void onMemberUpdate(String name) {
        // 회원명을 입력하지 않았을 때,
        if(name == null) {
            System.out.println("회원명을 입력하세요.");
            return;
        }

        int i = getMemberIndex(name);

        if(i == memberCount) {
            System.out.println("해당 회원이 없습니다.");
        } else {
            String id, email, passWord;
            System.out.printf("아이디(%s)? ", members[i].getID());
            id = keyScan.nextLine();
            
            System.out.printf("이메일(%s)? ", members[i].getEmail());
            email = keyScan.nextLine();
            
            System.out.printf("암호(%s)? ", members[i].getPassWord());
            passWord = keyScan.nextLine();

            // member 임시 객체 만들어서 최종적으로 원 members에 저장
            // try ~ catch문 사용하고, 유지보수를 위해 만든다.
            Member member = new Member(id, email, passWord);
            member.setEmail(email);
            member.setID(id);
            member.setPassWord(passWord);
            
            members[i] = member;

            System.out.println("변경하였습니다.");
            return;
        }
    }

    // 회원 정보 삭제
    public static void onMemberDelete(String name) {
        if(name == null) {
            System.out.println("아이디를 입력하세요.");
            return;
        }

        int i = getMemberIndex(name);

        if(i == -1) {
            System.out.println("해당 아이디가 없습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                memberCount--;
                while(i < memberCount) {
                    members[i] = members[i+1];
                    i++;
                }
                members[memberCount+1] = new Member();
            }
        }
    } 
}