package student.service;

import java.util.List;
import java.util.Map;

import student.model.StudentVo;

public interface StudentServiceInf {
	/**
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :
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
	 * Method : getStudent2
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
	Map<String, Object> getStudentPageList(Map<String,Integer>map);

	/**
	 * Method : studentUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 :학생정보 없데이트
	 */
	int studentUpdate(StudentVo studentVo);
}
