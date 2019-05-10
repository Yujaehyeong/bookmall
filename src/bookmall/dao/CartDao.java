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
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;

public class CartDao {
	
	MySQLConnection mySQLConnection;
	
	public CartDao() {
		mySQLConnection = new MySQLConnection();
	}
	
	public Boolean insertCart(CartVo cartVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "insert into cart values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, cartVo.getBookNo());
			pstmt.setString(2, cartVo.getMemberId());
			pstmt.setLong(3, cartVo.getAmount());
			
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}
		
		return true;
	}
	
	public List<CartVo> selectCartListByMemberId(String memberId) {

		List<CartVo> result = new ArrayList<CartVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "select a.book_no, concat(b.title,' ', a.amount,'권' ), a.amount, (a.amount * b.price) as 'price'" + 
					" from cart a, book b" + 
					" where a.book_no = b.no" + 
					" and a.member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartVo cartVo = new CartVo();
				Long bookNo = rs.getLong(1);
				String title = rs.getString(2);
				Long amount = rs.getLong(3);
				Long price = rs.getLong(4);
				
				cartVo.setBookNo(bookNo);
				cartVo.setMemberId(memberId);
				cartVo.setTitle(title);
				cartVo.setAmount(amount);
				cartVo.setPrice(price);
				
				// 여기에 받아올 데이터 저장
				result.add(cartVo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return result;
	}
		
}