package mms.member.action;

import java.util.Scanner;
// 각 요청을 제어
// 인터페이스로, 메소드 뼈대만 작성
// 이 부분이 servlet

public interface Action {
	void execute(Scanner sc) throws Exception;
}
