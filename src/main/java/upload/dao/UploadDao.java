package upload.dao;

import java.util.List;
import java.util.Map;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import post.dao.PostDaoInf;
import post.model.PostVo;
import upload.model.UploadVo;

public class UploadDao implements UploadDaoInf {
	
	private SqlSessionFactory sqlMapSessionFactory =
			SqlMapSessionFactory.getSqlMapSessionFactory();

	
	/**
	* Method : getUploadPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param post_code
	* @return
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	@Override
	public List<UploadVo> getUploadPost(int post_code){
		SqlSession session = sqlMapSessionFactory.openSession();
		List<UploadVo> uploadList = session.selectList("upload.getUploadPost", post_code);
		session.close();
		return uploadList;
	}


	/**
	* Method : deleteUpload
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param post_code
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	@Override
	public int deleteUpload(int post_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		int deleteResult = session.delete("upload.deleteUpload", post_code);
		session.commit();
		session.close();
		return deleteResult;
	}


	/**
	* Method : getUpload
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param upload_code
	* @return
	* Method 설명 : 해당 첨부파일 조회
	*/
	@Override
	public UploadVo getUpload(int upload_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		UploadVo uploadVo = session.selectOne("upload.getUpload", upload_code);
		session.close();
		return uploadVo;
	}


	@Override
	public int insertUpload(UploadVo uploadVo) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int insertCnt =session.insert("upload.insertUpload",uploadVo);
		session.commit();
		session.close();
		return insertCnt;
	}
	
	

}
