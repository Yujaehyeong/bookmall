package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	
	public static void main(String[] args) {
		
		setMemberData(); // 멤버 데이터 세팅
		
	}
	
	public static void setMemberData() {
		MemberVo memberVo1 = new MemberVo();
		memberVo1.setId("bit0721");
		memberVo1.setPasswd("bit0721");
		memberVo1.setName("김비트");
		memberVo1.setContact("010-7745-0721");
		memberVo1.setEmail("bit0721@bit.com");
		
		

		MemberVo memberVo2 = new MemberVo();
		memberVo2.setId("tib99");
		memberVo2.setPasswd("tib99");
		memberVo2.setName("박비트");
		memberVo2.setContact("010-1231-8891");
		memberVo2.setEmail("tib99@bit.com");
		
		
		
		insertMember(memberVo1);
		insertMember(memberVo2);
		
	}

	public static void insertMember(MemberVo memberVo) {
		if (new MemberDao().insertMember(memberVo)) {
			System.out.println("멤버 INSERT 성공 !!");
		}
	}
	
}
