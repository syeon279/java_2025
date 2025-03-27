package jsp026_frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class Frontcontroller
 */
@WebServlet("*.front")   //##1
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);  //#3
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);   //#3
	}
	
	//##2
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = request.getServletPath(); // 어떤 경로로 들어왔는지 확인
		System.out.println("........................." + path);
		
		if(path.equals("/a.front")) {
			System.out.println("A. a 처리컨트롤러 호출 B. View");
		} else if(path.equals("/b.front")) {
			System.out.println("A. b 처리컨트롤러 호출 B. View");
		}
		
	}
	
	
}
