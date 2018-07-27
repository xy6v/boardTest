package board.service;

import java.util.List;

import board.model.BoardVo;
import post.model.PostVo;

public interface BoardServiceInf {
	/**
	 * Method : selectAllBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	List<BoardVo> selectAllBoard();
	
	/**
	 * Method : getboard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param board_code
	 * @return
	 * Method 설명 :
	 */
	BoardVo getBoard(int board_code);
	
	//List<BoardVo> updateBoard(int board_code);
	/**
	 * Method : insertBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 :
	 */
	int insertBoard(BoardVo boardVo);
	/**
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc22
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 :
	 */
	int updateBoard(BoardVo boardVo);
}
