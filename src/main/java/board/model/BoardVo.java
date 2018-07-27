package board.model;

public class BoardVo {
	private int board_code;
	private String board_name;
	private String board_use;
	
	//기본생성자
	public BoardVo() {
		
	}
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	@Override
	public String toString() {
		return "boardVo [board_code=" + board_code + ", board_name="
				+ board_name + ", board_use=" + board_use + "]";
	}
	
	

}
