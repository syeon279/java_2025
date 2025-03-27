package com.company.dao;

import java.net.InetAddress;
import java.sql.*;
import java.util.ArrayList;

import com.company.dbmanager.DBManager;
import com.company.domain.BoardVo;

public class BoardDao {

	public int insert ( BoardVo vo ) {
		// 글 작성
		String sql = "insert into board (bname, btitle, bcontent, bip) values ( ?, ?, ?, ?)";
		int result = -1;
		//////////
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; //ResultSet rset = null;
		// DB 연동
		conn = db.getConnection();
		// sql 처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBname());
			pstmt.setString(2, vo.getBtitle());
			pstmt.setString(3, vo.getBcontent());
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
			result = pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * if(rset != null) { try { rset.close(); } catch (SQLException e) {
			 * e.printStackTrace(); } }
			 */
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(conn != null) {
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		////////////
		return result;
	} // E insert

	public ArrayList<BoardVo> selectAll ( ) {
		String sql = "select * from board order by bno desc";
		ArrayList<BoardVo> result = new ArrayList<>();
		//////////
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		// DB 연동
		conn = db.getConnection();
		// sql 처리
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) { 
				result.add( 
					new BoardVo(
						rset.getInt("bno"),
						rset.getInt("bhit"),
						rset.getString("bname"),
						rset.getString("btitle"),
						rset.getString("bcontent"),
						rset.getString("bdate"),
						rset.getString("bip")
					));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rset != null) {
				try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(conn != null) {
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		////////////
		return result;
		// 전체 글 가져오기
		
	} // E selectAll

	public BoardVo select ( int bno ) {
		// 해당 글 읽기
		String sql = "select * from board where bno=?";
		BoardVo result = new BoardVo();
		//////////
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		// DB 연동
		conn = db.getConnection();
		// sql 처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = new BoardVo(
						rset.getInt("bno"),
						rset.getInt("bhit"),
						rset.getString("bname"),
						rset.getString("btitle"),
						rset.getString("bcontent"),
						rset.getString("bdate"),
						rset.getString("bip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rset != null) {
				try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(conn != null) {
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		////////////
		return result;
	} // E select

	public int updateHit( int bno ) {
		// 조회수 늘리기
		String sql = "update board set bhit=bhit+1 where bno=?";
		int result = -1;
		//////////
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		// DB 연동
		conn = db.getConnection();
		// sql 처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rset != null) {
				try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(conn != null) {
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		////////////
		return result;
	} // E updateHit

	public int update( BoardVo vo ) {
		// 해당 글 수정하기
		String sql = "update board set btitle=? , bcontent=? where bno=?";
		int result = -1;
		//////////
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; //ResultSet rset = null;
		// DB 연동
		conn = db.getConnection();
		// sql 처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setInt(3, vo.getBno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//if(rset != null) {
				//try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
			//}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(conn != null) {
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		////////////
		return result;
	} // E update

	public int delete(int bno) {
		// 해당글 삭제하기 
		String sql = "delete from board where bno=?";
		int result = -1;
		//////////
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		// DB 연동
		conn = db.getConnection();
		// sql 처리
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rset != null) {
				try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(conn != null) {
				try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		////////////
		return result;
	} // E delete

}
