package bookmall.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		setCartData(); // 카트 데이터 세팅
	}

	public static void setCartData() {

		CartVo cartVo = new CartVo();
		cartVo.setBookNo(1L);
		cartVo.setMemberId("bit0721");
		cartVo.setAmount(3L);

		CartVo cartVo2 = new CartVo();
		cartVo2.setBookNo(2L);
		cartVo2.setMemberId("bit0721");
		cartVo2.setAmount(2L);
		
		insertCart(cartVo);
		insertCart(cartVo2);

	}

	public static void insertCart(CartVo cartVo) {

		if(new CartDao().insertCart(cartVo)) {
			System.out.println("카트 INSERT 성공 !!");
		}
		

	}
}
