package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberListService;
import mms.member.util.ConsolUtil;

public class MemberListAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsolUtil userList = new ConsolUtil();
		
		MemberListService list = new MemberListService();
		userList.printMemberList(list.getMemberList());
	}
	
}
