package com.jx372.guestbook.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.guestbook.vo.GuestBookVo;

public class GuestBookDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Connection 하기
			String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결 성공!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("JDBC Driver를 찾을 수 없습니다.");
		}
		return conn;

	}

	public boolean insert(GuestBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = getConnection();
			String sql = "insert into guestbook values(null,?,?,now(),?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMessage());
			pstmt.setString(3, vo.getPasswd());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count == 1;
	}

	public List<GuestBookVo> getList() {
		Connection conn = null;
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "select no,name,message,date_format(reg_date,'%Y-%m-%d') from guestbook;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				GuestBookVo vo = new GuestBookVo();

				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setMessage(rs.getString(3));
				vo.setDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public boolean delete(GuestBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = getConnection();
			String sql = "delete from guestbook where no=? and passwd=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPasswd());
			System.out.println(pstmt);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count == 1;
	}

}
