package upload.service;

import java.util.List;

import post.dao.PostDao;
import post.dao.PostDaoInf;
import upload.dao.UploadDao;
import upload.dao.UploadDaoInf;
import upload.model.UploadVo;

public class UploadService implements UploadServiceInf{
	UploadDaoInf uploadDao = new UploadDao();
	
	@Override
	public  List<UploadVo> getUploadPost(int post_code) {
		return uploadDao.getUploadPost(post_code);
	}

	@Override
	public int deleteUpload(int post_code) {
		return uploadDao.deleteUpload(post_code);
	}

	@Override
	public UploadVo getUpload(int upload_code) {
		return uploadDao.getUpload(upload_code);
	}

	@Override
	public int insertUpload(UploadVo uploadVo) {
		return uploadDao.insertUpload(uploadVo);
	}
	

}
