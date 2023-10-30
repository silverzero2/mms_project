package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.util.ConsolUtil;
import mms.member.vo.Member;

public class MemberModifyAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsolUtil u = new ConsolUtil();
		Member m = new Member();
		
		MemberModifyService modify = new MemberModifyService();
		m = u.getUpdateMember(sc, modify.getOldMember(u.getName("수정할", sc)));
		
		if(modify.ModifyMember(m) == true) {
			u.printModifySuccessMessage(m);
		} else {
			u.printModifyFailMessage(m);
		}
	}

}
