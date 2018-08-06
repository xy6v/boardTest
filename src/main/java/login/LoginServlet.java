package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVo;
import board.service.BoardService;
import board.service.BoardServiceInf;
import student.model.StudentVo;
import student.service.StudentService;
import student.service.StudentServiceInf;


/*import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;*/

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 파라미터를 받아서 sysout으로 console창에 출력
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String std_id = request.getParameter("std_id");
		String pass = request.getParameter("pass");

		// System.out.println("User ID : "+request.getParameter("userId"));
		// System.out.println("Password : "+request.getParameter("password"));

		// 로그인 프로세스
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudentId(std_id);
		// userService에서 받아온 userVo 의 정보와 사용자가 입력한 정보가 동일할 경우 로그인 성공 메세지 화면에 출력
		// 실패시 로그인 실패가 메세지 화면 에 출력
		// 기찌 (fake) service,dao 객체를 생성

		PrintWriter pw = response.getWriter();

		// 로그인 성공시:forwoard /main.jsp로 이동
		// 로그인 실패시: redirect login.jsp로 이동
		
		//로그인 성공시 userVo 객체를 저장하여 (적당한 영역에)
		//main.jsp에서 사용자 아이디를 화면에 출력
		//단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야 한다.
		if (studentVo.validateStudnet(std_id, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("studentVo",studentVo);
			request.getSession().getAttribute("std_id");
			BoardServiceInf boardService = new BoardService();
			List<BoardVo>boardList=boardService.selectAllBoard();
			
			request.getSession().setAttribute("boardList", boardList);
			//request.getSession().getAttribute("password");
			
			System.out.println("Forward를 이용하여 main.jsp로 이동");

			// foward.jsp로 위임
			request.getRequestDispatcher("/board/main.jsp").forward(request, response);
			System.out.println("로그인  성공!!!");
			pw.write("로그인  성공!!!!!");
			
			
		} else {
			System.out.println("redirect를 이용하여 login.jsp로 다시이동!");
			// redirect를 통해 응답을 러치할 화면으로 이동하라고 브라우저에게 지시한다.
			//response.sendRedirect("/login/login.jsp");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			
			System.out.println("로그인  실패");
			pw.write("로그인  실패");
		}

		System.out.println("studentId : " + std_id);
		System.out.println("password : " + pass);
	}

}
