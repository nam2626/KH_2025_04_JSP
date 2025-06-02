package dto;

public class MajorDTO {
	private String mno;
	private String mname;

	public MajorDTO() {	}
	
	public MajorDTO(String mno, String mname) {
		super();
		this.mno = mno;
		this.mname = mname;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

}
