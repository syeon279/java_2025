package jsp_basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet implementation class jsp025_login
 */
@WebServlet("/user_login")
public class jsp025_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public jsp025_login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // 오타주의
		PrintWriter out = response.getWriter();
		
		// 1. 데이터 넘겨받기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		// 2. DBManager 불러서 DB연동하기
		DBManager db= new DBManager();
		PreparedStatement pstmt = null; ResultSet rset = null;
		Connection conn = db.getConnection();
		
		HttpSession session = request.getSession();
		// 3. sql 구문 처리
		String sql = "select count(*) `cnt` from member where name=? and pass=?"; 
		try {
			//out.println("<script>alert('hi'); </script>");
			
			 pstmt = conn.prepareStatement(sql); 
			 pstmt.setString(1, id);
			 pstmt.setString(2, pass);
			 
			 rset = pstmt.executeQuery();
			 while(rset.next()) {
				 int result = rset.getInt("cnt");
				 if( result == 1) {
					 session.setAttribute("userid", id );
					 session.setAttribute("userpass", pass );
					 //out.println("<script>alert('로그인 성공!'); location.href='jsp025_my_servlet.jsp'; </script>");
					 request.getRequestDispatcher("jsp025_my_servlet.jsp").forward(request, response);
			 } else { 
				 out.println("<script>alert('관리자에게 문의 바랍니다.'); history.go(-1);</script>");
			 	}	 
			 } 
		} catch ( Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
			if(conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
			 
		}
		
	}

}
