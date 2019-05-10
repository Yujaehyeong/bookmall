package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.db.MySQLConnection;
import bookmall.vo.CategoryVo;

public class CategoryDao {

	MySQLConnection mySQLConnection;

	public CategoryDao() {
		mySQLConnection = new MySQLConnection();
	}

	public Boolean insertCategory(String category) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "insert into category values(null, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, category);

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return true;
		
	}

	public List<CategoryVo> selectCategoryList() {

		List<CategoryVo> result = new ArrayList<CategoryVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "select no, category from category";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long no = rs.getLong(1);
				String category = rs.getString(2);

				CategoryVo categoryVo = new CategoryVo();
				categoryVo.setNo(no);
				categoryVo.setCategory(category);

				result.add(categoryVo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return result;

	}	

}
