package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.db.MySQLConnection;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class BookDao {

	MySQLConnection mySQLConnection;

	public BookDao() {
		mySQLConnection = new MySQLConnection();
	}

	public Boolean insertBook(BookVo bookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "insert into book values(null, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookVo.getTitle());
			pstmt.setLong(2, bookVo.getPrice());
			pstmt.setString(3, bookVo.getAuthor());
			pstmt.setString(4, bookVo.getPublisher());
			pstmt.setLong(5, bookVo.getCategoryVo().getNo());

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {

			mySQLConnection.disConnect(rs, pstmt, conn);

		}

		return true;
	}

	

	public List<BookVo> selectBookList() {

		List<BookVo> result = new ArrayList<BookVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "select a.no, a.title, a.price, a.author, a.publisher, b.category" + " from book a, category b"
					+ " where a.category_no = b.no";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVo bookVo = new BookVo();
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Long price = rs.getLong(3);
				String author = rs.getString(4);
				String publisher = rs.getString(5);
				String category = rs.getString(6);
				CategoryVo categoryVo = new CategoryVo();
				categoryVo.setCategory(category);
				
				bookVo.setNo(no);
				bookVo.setTitle(title);
				bookVo.setPrice(price);
				bookVo.setAuthor(author);
				bookVo.setPublisher(publisher);
				bookVo.setCategoryVo(categoryVo);
				
				// 여기에 받아올 데이터 저장
				result.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return result;
	}

}
