package board.service;
import java.util.List;
import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVo;
import post.model.PostVo;

public class BoardService implements BoardServiceInf {

	/**
	 * Method : selectAllBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 조회
	 */
	@Override
	public List<BoardVo> selectAllBoard() {
		BoardDaoInf boardDao = new BoardDao();
		List<BoardVo> studentList = boardDao.selectAllBoard();
		return studentList;
	}
	
	@Override
	public BoardVo getBoard(int board_code) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getBoard(board_code);
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.insertBoard(boardVo);
	}
	
	@Override
	public int updateBoard(BoardVo boardVo) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.updateBoard(boardVo);
	}
}
