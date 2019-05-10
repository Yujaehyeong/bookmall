package bookmall.test;

public class AllDaoTest {
	public static void main(String[] args) {
		
		// 각 메소드를 static로 선언 후 한번에 실행 가능하게 모음
		
		MemberDaoTest.setMemberData(); // 멤버 데이터 세팅
		CategoryDaoTest.setCategoryData(); // 카테고리 데이터세팅
		BookDaoTest.setBookData(); // 도서 데이터세팅
		CartDaoTest.setCartData(); // 카트 데이터세팅
		OrderDaoTest.setOrderData(); // 주문 및 주문_도선 데이터 세팅
		
	}
}
