package bookmall.test;

import java.util.ArrayList;
import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDaoTest {
	
	public static void main(String[] args) {
		setOrderData(); // 주문 및 주문_도서 데이터 세팅
	}
	
	public static void setOrderData() {

		OrderVo orderVo = new OrderVo();
		orderVo.setPaymentPrice(55000L);
		orderVo.setDestination("비트아카데미");
		orderVo.setDeliveryStatus("상품준비중");
		orderVo.setOrderDate("2019-05-09");
		MemberVo memberVo = new MemberVo();
		memberVo.setId("bit0721");
		orderVo.setMemberId(memberVo.getId());

		List<OrderBookVo> orderBookList = new ArrayList<OrderBookVo>();
		OrderBookVo orderBookVo1 = new OrderBookVo(1L, 2L); // 1번책 2권 주문을 위해 객체생성
		OrderBookVo orderBookVo2 = new OrderBookVo(2L, 3L); // 2번책 3권 주문을 위해 객체생성
		orderBookList.add(orderBookVo1);
		orderBookList.add(orderBookVo2);
		
		insertOrder(orderVo, orderBookList);

	}

	public static void insertOrder(OrderVo orderVo, List<OrderBookVo> orderBookList) {

		OrderDao orderDao = new OrderDao();
		Long lastOrderNo = orderDao.insertOrder(orderVo);

		for (OrderBookVo orderBookVo : orderBookList) {
			if(orderDao.insertOrderBook(lastOrderNo, orderBookVo.getBookNo(), orderBookVo.getBookAmount())) {
				System.out.println("주문 및 주문_도서 INSERT 성공 !!");
			}
		}
	}
}
