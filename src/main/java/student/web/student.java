package student.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentVo;
import student.service.StudentService;
import student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 *//*
@WebServlet("/studentList")*/
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//studentService 객체를 생성, 학생 전체 리스트를 조회
		//학생 전체 리스트 request객체에 속성으로 설정
		//studentList.jsp로 forword
		
		/*
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("page",Integer.parseInt(request.getParameter("page")));
		map.put("pageSize",Integer.parseInt(request.getParameter("pageSize")));*/
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		int page = pageStr == null ? 1:Integer.parseInt(pageStr);
		int pageSize =pageSizeStr== null ? 10:Integer.parseInt(pageSizeStr);
		
		//int page = Integer.parseInt(request.getParameter("page"));
		Map<String,Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page",page);
		paramMap.put("pageSize",pageSize);
		
		//학생 페이지 리스트, 전체 건수 조회
		StudentServiceInf studentservice = new StudentService();
		Map<String, Object>resultMap=studentservice.getStudentPageList(paramMap);
		
		//학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>)resultMap.get("pageList");
		request.setAttribute("studentList", studentList);
		
		//학생 페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
