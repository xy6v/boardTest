package student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import student.dao.StudentDao;
import student.dao.StudentDaoInf;
import student.model.StudentVo;


public class StudentService implements StudentServiceInf {

	@Override
	public List<StudentVo> selectAllStudents() {
		StudentDaoInf studentDao = new StudentDao();
		List<StudentVo> studentList = studentDao.selectAllStudents();
		return studentList;
	}

	@Override
	public StudentVo getStudent(int id) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(id);
	}
	
	@Override
	public StudentVo getStudentId(String std_id) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudentId(std_id);
	}


	/**
	 * Method : getStudent 최초작성일 : 2018. 7. 10. 작성자 : pc22 변경이력 :
	 * 
	 * @param Vo
	 * @return Method 설명 : 학생 정보 조회
	 */
	@Override
	public StudentVo getStudent(StudentVo Vo) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.getStudent(Vo);
	}

	/**
	 * Method : getStudentPageList 최초작성일 : 2018. 7. 10. 작성자 : pc22 변경이력 :
	 * 
	 * @param map
	 * @return Method 설명 :학생 정보 페이지 리스트 조회
	 */
	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		StudentDaoInf studentDao = new StudentDao();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// 학생 페이지 리스트 조회
		List<StudentVo> pageList = studentDao.getStudentPageList(map);
		resultMap.put("pageList", pageList);

		// 학생 전체 건수 조회
		int totCnt = studentDao.getStudentTotCnt();
		resultMap.put("totCnt", totCnt);

		// 페이지 네비게이션 html생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}

	/**
	 * Method : makePageNavi
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return
	 * Method 설명 : 페이지 네비게이션 문자열 생성
	 */
	private String makePageNavi(int page, int pageSize, int totCnt) {
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;
		pageNaviStr
				.append("<li><a href=\"/studentList?page="
						+ prevPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";

			if (i == page)

				activeClass = " class=\"active\"";

			pageNaviStr.append("<li" + activeClass
					+ "><a href=\"/postList?page=" + i + "&postList="
					+ pageSize + "\">" + i + "</a></li>");

		}
		pageNaviStr
				.append("<li><a href=\"/postList?page="
						+ nextPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	/**
	 * Method : studentUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 :학생정보 조회
	 */
	@Override
	public int studentUpdate(StudentVo studentVo) {
		StudentDaoInf studentDao = new StudentDao();
		return studentDao.studentUpdate(studentVo);
	}

}
