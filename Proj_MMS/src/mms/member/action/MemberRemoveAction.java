package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsolUtil;

public class MemberRemoveAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsolUtil u = new ConsolUtil();
		String name = u.getName("삭제할", sc);
		
		MemberRemoveService remove = new MemberRemoveService();
		
		if(remove.removeMember(name) == true) {
			u.printremoveSuccessMessage(name);
		} else {
			u.printremoveFailMessage(name);
		}
	}

}
