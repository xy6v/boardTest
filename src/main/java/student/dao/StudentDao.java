package student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapSessionFactory;
import student.model.StudentVo;


public class StudentDao implements StudentDaoInf {
	private SqlSessionFactory sqlMapSessionFactory =
			SqlMapSessionFactory.getSqlMapSessionFactory();
	/**
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회하는것 2
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlMapSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}
	
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 :아이디로 학생 검색
	 */
	
	@Override 
	public StudentVo getStudent(int id){
		SqlSession session = sqlMapSessionFactory.openSession();
		StudentVo studentvo = session.selectOne("student.getStudentById",id);
		session.close();
		return studentvo;
	}

	@Override
	public StudentVo getStudentId(String std_id){
		//원래대로러면 :orm,jdbc등을 이용하여 db를 통해 조회환 겨로가를 반환
		//servlet 태스트 목적으로
		StudentVo studentvo = new StudentVo();
		studentvo.setStd_id("brown");
		studentvo.setPass("1234");
		return studentvo;
		
	}
	@Override
	public StudentVo getStudent(StudentVo Vo) {
		SqlSession session = sqlMapSessionFactory.openSession();
		StudentVo vo = session.selectOne("student.getStudentByVo",Vo);
		session.close();
		return vo;
	}

	/**
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 :학생페이지 리스트 조회2
	 */
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session=sqlMapSessionFactory.openSession();
		List<StudentVo> studentList=session.selectList("student.getStudentPageList",map);
		session.close();
		return studentList;
	}
	
	/**
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :핛생 전체 건수 조회
	 */
	@Override 
	public int getStudentTotCnt(){
		SqlSession session=sqlMapSessionFactory.openSession();
		int cnt = session.selectOne("student.getStudentTotCnt");
		session.close();
		return cnt;
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int updateCnt =session.update("student.studentUpdate",studentVo);
		session.commit();
		session.close();
		return updateCnt;
	}

}
