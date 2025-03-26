package jsp_basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class jsp025_join
 */
@WebServlet("/user_join")
public class jsp025_join extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public jsp025_join() {
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
		Connection conn = db.getConnection();
		
		// 3. sql 구문 처리
		PreparedStatement pstmt = null; 
		String sql = "insert into member (name, pass) values (?, ?)"; 
		try {
			//out.println("<script>alert('hi'); </script>");
			
			 pstmt = conn.prepareStatement(sql); pstmt.setString(1, id);
			 pstmt.setString(2, pass);
			 
			 int result = pstmt.executeUpdate(); if(result>0) { out.
			 println("<script>alert('환영합니다 고객님'); location.href='jsp022.jsp'; </script>");
			 } else { out.println("<script>alert('관리자에게 문의 바랍니다.');</script>"); }
			 
			
		} catch ( Exception e) {
			e.printStackTrace();
		} finally {
			
			 if(pstmt != null) { try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} } if(conn != null) { try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
			 
		}
		
		// 4. 경로 처리
		// response.sendRedirect("jsp022.jsp");
		
	}

}
