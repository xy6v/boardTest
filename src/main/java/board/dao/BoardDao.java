package board.dao;

import java.util.List;
import java.util.Map;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import board.model.BoardVo;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlMapSessionFactory =
			SqlMapSessionFactory.getSqlMapSessionFactory();

	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession session = sqlMapSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.selectAllBoard");
		System.out.println(boardList);
		session.close();
		return boardList;
	}
	
	@Override
	public int insertBoard(BoardVo boardVo){
		SqlSession session=sqlMapSessionFactory.openSession();
		int insertCnt =session.insert("board.insertBoard",boardVo);
		session.commit();
		session.close();
		return insertCnt;
	}

	@Override
	public BoardVo getBoard(int board_code) {
		SqlSession session = sqlMapSessionFactory.openSession();
		BoardVo boardvo = session.selectOne("board.getBoard",board_code);
		session.close();
		return boardvo;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession session=sqlMapSessionFactory.openSession();
		int updateCnt =session.update("board.updateBoard",boardVo);
		session.commit();
		session.close();
		return updateCnt;
	}

}
