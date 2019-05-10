package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.db.MySQLConnection;
import bookmall.vo.MemberVo;

public class MemberDao {

	MySQLConnection mySQLConnection;

	public MemberDao() {
		mySQLConnection = new MySQLConnection();
	}
	
	public boolean insertMember(MemberVo memberVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			// 인서트 쿼리문추가
			String sql = "insert into member values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPasswd());
			pstmt.setString(3, memberVo.getName());
			pstmt.setString(4, memberVo.getContact());
			pstmt.setString(5, memberVo.getEmail());

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return true;
	}

	public List<MemberVo> selectMemberList() {
		
		List<MemberVo> result = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = mySQLConnection.getConnection();
			String sql = "select id, name, contact, email from member";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String contact = rs.getString(3);
				String email = rs.getString(4);

				MemberVo memberVo = new MemberVo();
				memberVo.setId(id);
				memberVo.setName(name);
				memberVo.setContact(contact);
				memberVo.setEmail(email);
				
				result.add(memberVo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			mySQLConnection.disConnect(rs, pstmt, conn);
		}

		return result;
	}

}
