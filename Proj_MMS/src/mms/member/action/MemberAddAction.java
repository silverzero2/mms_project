package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsolUtil;
import mms.member.vo.Member;
// 각 요청을 제어(Action은 모든 클래스가 모이는 곳 > ConsolUtil과 Service를 여기서 실행)
// 인터페이스로 Action에 정의되어 있는 메소드를 오버라이딩함
public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// ConsolUtil과 MemberAddService 따라가기
		// ConsolUtil에서는 getNewMember / printAddSuccessMessage / printAddMessage 사용
		ConsolUtil u = new ConsolUtil();
		Member m = new Member();
		// 멤버 객체에 getNewMember 실행 결과 저장
		// public Member getNewMember(Scanner sc)
		m = u.getNewMember(sc);
		
		MemberAddService add = new MemberAddService();
		
		// public boolean addMember(Member newMember) throws Exception
		if(add.addMember(m) == true) { // add.addMember(m)가 true(db에 정상적으로 들어갔다면)이면 추가 성공
			// public void printAddSuccessMessage(Member newMember)
			u.printAddSuccessMessage(m); // 추가 성공 메시지 출력
		} else {
			// public void printAddMessage(Member newMember)
			u.printAddMessage(m); // 추가 실패 메시지 출력
		}
	}

}
