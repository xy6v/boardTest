package student.dao;

import java.util.List;
import java.util.Map;

import student.model.StudentVo;

public interface StudentDaoInf {
	
	/**
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	StudentVo getStudentId(String std_id);
	List<StudentVo> selectAllStudents();
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 :
	 */
	StudentVo getStudent(int id);
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param Vo
	 * @return
	 * Method 설명 :
	 */
	StudentVo getStudent(StudentVo Vo);
	
	/**
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 :학생 페이지 리스트 조회
	 */
	List<StudentVo> getStudentPageList(Map<String,Integer>map);
	
	/**
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	int getStudentTotCnt();
 
	int studentUpdate(StudentVo studentVo);
}
