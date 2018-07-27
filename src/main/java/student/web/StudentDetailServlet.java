package student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.StudentVo;
import student.service.StudentService;
import student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/studentDetail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//학생 id를 파라미터 확인1
		int id = Integer.parseInt(request.getParameter("id"));
		
		//service학생 정보를 조회2
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(id);
		
		request.setAttribute("studentVo", studentVo);
		
		request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
		
		
		
	}

	

}
