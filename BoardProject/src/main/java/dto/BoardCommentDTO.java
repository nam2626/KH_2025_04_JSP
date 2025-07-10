package dto;

public class BoardCommentDTO {
	private int cno;
	private int bno;
	private String id;
	private String nickName;
	private String cdate;
	private String content;
	private int clike;
	private int chate;

	public BoardCommentDTO() {
	}

	public BoardCommentDTO(int cno, int bno, String id, String nickName, String cdate, String content, int clike,
			int chate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.id = id;
		this.nickName = nickName;
		this.cdate = cdate;
		this.content = content;
		this.clike = clike;
		this.chate = chate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClike() {
		return clike;
	}

	public void setClike(int clike) {
		this.clike = clike;
	}

	public int getChate() {
		return chate;
	}

	public void setChate(int chate) {
		this.chate = chate;
	}

	@Override
	public String toString() {
		return "BoardCommentDTO [cno=" + cno + ", bno=" + bno + ", id=" + id + ", nickName=" + nickName + ", cdate="
				+ cdate + ", content=" + content + ", clike=" + clike + ", chate=" + chate + "]";
	}
	 
	
	
	
}
