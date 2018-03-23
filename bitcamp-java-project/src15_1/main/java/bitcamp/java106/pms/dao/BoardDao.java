package bitcamp.java106.pms.dao;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Board;

// Board Date Access Object
public class BoardDao {
    private Board[] boards = new Board[1000]; // 보드 생성
    private int boardIndex = 0;  //게시판 갯수!!
    
    // 게시판 데이터 생성
    public void insert(Board board) {
        this.boards[boardIndex++] = board;
    }
    
    // 게시판 리스트 출력
    public Board[] list() {
        // 입력한 게시판만 반환하기 위해 arr를 생성한다.
        Board[] arr = new Board[boardIndex];
        for(int i = 0; i < boardIndex; i++) {
            arr[i] = boards[i];
        }
        return arr;
    }
    
    // 색인
    public Board get(int i) {
        if(i < 0 || i >= boardIndex)
            return null;
        return boards[i];
    }
    
    // 갱신
    public void update(int i, Board board) {
        boards[i] = board;
    }
    
    // 삭제
    public void delete(int i) {
        boards[i] = null;
    }
}
