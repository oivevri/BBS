package co.avri.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.avri.board.comm.Action;
import co.avri.board.command.LoginAction;
import co.avri.board.command.LoginForm;
import co.avri.board.command.LogoutAction;
import co.avri.board.command.MainAction;
import co.avri.board.command.MemberForm;
import co.avri.board.command.MemberInsertAction;
import co.avri.board.command.MemberListAction;

// Servlet implementation class FrontController
/*@WebServlet("/FrontController")*/
@MultipartConfig
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 내부적으로 사용하려고 해시맵 변수 사용 HashMap
	private HashMap<String, Action> map = new HashMap<String, Action>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	// 요청 정의
		map.put("/main.do", new MainAction()); // 처음들어오는페이지 index.jsp를 처리
		map.put("/login.do", new LoginAction()); // 로그인 메뉴를 처리하는 것
		map.put("/loginForm.do", new LoginForm()); // 로그인폼 호출
		map.put("/memberList.do", new MemberListAction()); // 회원전체리스트보기
		map.put("/memberForm.do", new MemberForm()); // 회원가입화면 호출
		map.put("/memberInsert.do", new MemberInsertAction()); // 회원입력
		map.put("/logout.do", new LogoutAction()); // 로그아웃
		
		// url이 /login.do 로 들어오면 LoginAction() 를 실행해라
		// 이걸하려면 메인액션 커맨드, 로그인액션 커맨드가 있어야함
		
		// 더 필요한 요청들이 있을때는 여기에 추가하면 됨
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 실제 수행할 명령을 정리
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		// 어떤요청이 들어왔는지 알아내려고 실제패스를 구하는것
		String path = uri.substring(contextPath.length()); // 실제 들어오는 요청페이지를 찾음(경로찾기)
		// doGet, doPost를 하더라도 여기까지의  부분은 필요함
		
		Action command = map.get(path);
		// Action.java는 String으로 받으니까 명령을 실행시키려면
		String viewPage = command.exec(request, response); // 실제 명령어 수행되는 부분
		// 내 리퀘스트 객체를 전달해줄 페이지를 선택
		// 명령이 수행되고나서 보여줄 페이지를 선택.. 돌려질 뷰페이지 찾는것
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		// 그리고 그 페이지를 돌려주는것.. 선택된 페이지로 가기
		// getRequestDispatcher에 viewPage값을 실어둠
		dispatcher.forward(request, response);
	}
}
