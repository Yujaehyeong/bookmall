package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.db.MySQLConnection;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao {

	MySQLConnection mySQLConnection;

	public OrderDao() {
		mySQLConnection = new MySQLConnection();
	}
	
	public Long insertOrder(OrderVo orderVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long lastOrderNo= 0L;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "insert into orders values(null, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setLong(1, orderVo.getPaymentPrice());
			pstmt.setString(2, orderVo.getDestination());
			pstmt.setString(3, orderVo.getDeliveryStatus());
			pstmt.setString(4, orderVo.getOrderDate());
			pstmt.setString(5, orderVo.getMemberId());
			pstmt.executeQuery();
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				lastOrderNo = rs.getLong(1);
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return lastOrderNo;
	}
	
	public Boolean insertOrderBook(Long orderNo, Long bookNo, Long amount) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "insert into order_book values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderNo);
			pstmt.setLong(2, bookNo);
			pstmt.setLong(3, amount);

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return true;
	}

	public List<OrderVo> selectOrderListByMemberId(String memberId) {

		List<OrderVo> result = new ArrayList<OrderVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "select no, payment_price, destination, delivery_status, date" + 
						 " from orders"
						+" where member_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long no = rs.getLong(1);
				Long paymentPrice = rs.getLong(2);
				String destination = rs.getString(3);
				String deliveryStatus = rs.getString(4);
				String orderDate = rs.getString(5);

				OrderVo orderVo = new OrderVo();
				orderVo.setNo(no);
				orderVo.setPaymentPrice(paymentPrice);
				orderVo.setDestination(destination);
				orderVo.setDeliveryStatus(deliveryStatus);
				orderVo.setOrderDate(orderDate);
				orderVo.setMemberId(memberId);
				
				result.add(orderVo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return result;
	}
	
	public List<OrderBookVo> selectOrderedBookListByOrderNo(Long orderNo) {

		List<OrderBookVo> result = new ArrayList<OrderBookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "select a.no, a.title, a.price, a.author, a.publisher, c.category, b.amount" + 
					" from book a, order_book b, category c" + 
					" where a.no = b.book_no" + 
					" and a.category_no = c.no" + 
					" and b. order_no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, orderNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderBookVo orderBookVo = new OrderBookVo();
				Long bookNo = rs.getLong(1);
				String title = rs.getString(2);
				Long price = rs.getLong(3);
				String author = rs.getString(4);
				String publisher = rs.getString(5);
				String category = rs.getString(6);
				Long bookAmount = rs.getLong(7);
				
				orderBookVo.setOrderNo(orderNo);
				orderBookVo.setBookNo(bookNo);
				orderBookVo.setTitle(title);
				orderBookVo.setPrice(price);
				orderBookVo.setAuthor(author);
				orderBookVo.setPublisher(publisher);
				orderBookVo.setCategory(category);
				orderBookVo.setBookAmount(bookAmount);
				
				// 여기에 받아올 데이터 저장
				result.add(orderBookVo);
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}
		
		return result;
	}
	
	
}