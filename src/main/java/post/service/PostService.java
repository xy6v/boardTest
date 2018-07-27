package post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVo;
import post.dao.PostDao;
import post.dao.PostDaoInf;
import post.model.PostVo;
import student.dao.StudentDao;
import student.dao.StudentDaoInf;
import student.model.StudentVo;

public class PostService implements PostServiceInf {

	@Override
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {
		PostDaoInf postDao = new PostDao();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<PostVo> pageList = postDao.getPostPageList(map);
		resultMap.put("pageList", pageList);
		int totCnt = postDao.getPostTotCnt();
		resultMap.put("totCnt", totCnt);
		// 페이지 네비게이션 html생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt,map.get("board_code")));
		return resultMap;
	}
	
	private String makePageNavi(int page, int pageSize, int totCnt,int board_code) {
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;
		pageNaviStr
				.append("<li><a href=\"/postList?&page="
						+ prevPage
						+ "&pageSize="
						+ pageSize
						+ "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";

			if (i == page)

				activeClass = " class=\"active\"";

			pageNaviStr.append("<li" + activeClass
					+ "><a href=\"/postList?board_code="+board_code+"&page=" + i + "&pageSize="
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

@Override
public PostVo getPost(int post_code) {
		PostDaoInf postDao = new PostDao();
		return postDao.getPost(post_code);	
	}
@Override
public int postUpdate(PostVo postVo) {
	PostDaoInf postDao = new PostDao();
	return postDao.postUpdate(postVo);
}

@Override
public int postNew(PostVo postVo) {
	PostDaoInf postDao = new PostDao();
	return postDao.postNew(postVo);
}

@Override
public int postRp(PostVo postVo) {
	PostDaoInf postDao = new PostDao();
	return postDao.postRp(postVo);
}
@Override
public int postDelete(int post_code) {
	PostDaoInf postDao = new PostDao();
	return postDao.postDelete(post_code);
}

@Override
public List<PostVo> postSelect() {
	PostDaoInf postDao = new PostDao();
	List<PostVo> postList = postDao.postSelect();
	return postList;
}

}
