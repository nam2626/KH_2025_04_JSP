package model.dto;

public class BoardMemberDTO {
	private String id;
	private String passwd;
	private String userName;
	private String nickName;

	public BoardMemberDTO() {	}
	
	public BoardMemberDTO(String id, String passwd, String userName, String nickName) {
		this.id = id;
		this.passwd = passwd;
		this.userName = userName;
		this.nickName = nickName;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "BoardMemberDTO [id=" + id + ", passwd=" + passwd + ", userName=" + userName + ", nickName=" + nickName
				+ "]";
	}
	
	
	
}
