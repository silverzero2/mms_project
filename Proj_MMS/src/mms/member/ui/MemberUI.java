package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;
// 메뉴 선택
public class MemberUI {

	public static void main(String[] args) {
		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		int num;
		// 인터페이스 변수 선언
		Action action = null;
		
		do {
			System.out.println("=====회원관리 프로그램=====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램 종료");
			System.out.print("메뉴번호 : ");
			num = sc.nextInt();
			switch(num) {
			case 1:
				// 인터페이스 변수에 구현 객체 대입
				action = new MemberAddAction(); // MemberAddAction으로 이동
				break;
			case 2:
				action = new MemberListAction(); // MemberListAction으로 이동
				break;
			case 3:
				action = new MemberModifyAction(); // MemberModifyAction으로 이동
				break;
			case 4:
				action = new MemberRemoveAction(); // MemberRemoveAction으로 이동
				break;
			case 5:
				isStop = true;
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못입력했습니다.");
				break;
			}
			// 구현 객체만으로는 실행을 시키지 못함, 그래서 아래 코드 실행
			// action이 null이 아니라면 컨트롤러 실행(컨트롤러를 따라가면 execute 메소드를 실행)
			if(action != null) {
				memberController.processrequest(action, sc);
				action = null; // 실행이 완료된 후 action의 값을 null로 비워줌
			}
			
		}
		while (!isStop);
	}

}
