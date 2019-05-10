package bookmall.main;

import java.util.List;
import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {

		selectMemberList();

		selectCategoryList();

		selectBookList();

		selectCartListByMemberId();

		selectOrderListByMemberId();

		selectOrderedBookListByOrderNo();
	}

	public static void selectMemberList() {

		List<MemberVo> memberList = new MemberDao().selectMemberList();
		System.out.println("---------------------#멤버 리스트#---------------------");
		for (MemberVo memberVo : memberList) {
			System.out.println(memberVo.toString());
		}
		System.out.println();
	}

	public static void selectCategoryList() {

		List<CategoryVo> categoryList = new CategoryDao().selectCategoryList();
		System.out.println("--------------------#카테고리 리스트#--------------------");
		for (CategoryVo categoryVo : categoryList) {
			System.out.println(categoryVo.toString());
		}
		System.out.println();
	}

	public static void selectBookList() {

		List<BookVo> bookList = new BookDao().selectBookList();
		System.out.println("---------------------#도서 리스트#---------------------");
		for (BookVo bookVo : bookList) {
			System.out.println(bookVo.toString());
		}
	}
	
	public static void selectCartListByMemberId() {

		String memberId = "bit0721";
		
		List<CartVo> cartList = new CartDao().selectCartListByMemberId(memberId);
		System.out.println("---------------------#카트 리스트#---------------------");
		for (CartVo cartVo : cartList) {
			System.out.println(cartVo.toString());
		}
		System.out.println();
	}

	public static void selectOrderListByMemberId() {

		String memberId = "bit0721";
		
		System.out.println("---------------------#주문 리스트#---------------------");
		List<OrderVo> orderList = new OrderDao().selectOrderListByMemberId(memberId);
		for (OrderVo orderVo : orderList) {
			System.out.println(orderVo.toString());
		}
		System.out.println();
	}

	public static void selectOrderedBookListByOrderNo() {

		Long orderNo = 1L;
		
		System.out.println("-------------------#주문한 도서리스트#-------------------");
		List<OrderBookVo> orderBookVoList = new OrderDao().selectOrderedBookListByOrderNo(orderNo);
		for (OrderBookVo orderBookVo : orderBookVoList) {

			System.out.println(orderBookVo.toString());

		}
		System.out.println();
	}
}
