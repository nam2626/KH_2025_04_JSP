package dto;

public class BoardDTO {
	private int bno;
	private String title;
	private String id;
	private String nickName;
	private int boardCount;
	private int boardLike;
	private int boardHate;
	private String content;
	private String writeDate;

	public BoardDTO() {	}

	public BoardDTO(int bno, String title, String id, String nickName, int boardCount, int boardLike, int boardHate,
			String content, String writeDate) {
		super();
		this.bno = bno;
		this.title = title;
		this.id = id;
		this.nickName = nickName;
		this.boardCount = boardCount;
		this.boardLike = boardLike;
		this.boardHate = boardHate;
		this.content = content;
		this.writeDate = writeDate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	public int getBoardHate() {
		return boardHate;
	}

	public void setBoardHate(int boardHate) {
		this.boardHate = boardHate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", id=" + id + ", nickName=" + nickName + ", boardCount="
				+ boardCount + ", boardLike=" + boardLike + ", boardHate=" + boardHate + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
	
}
