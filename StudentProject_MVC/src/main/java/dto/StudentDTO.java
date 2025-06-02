package dto;

public class StudentDTO {
	private String sno;
	private String sname;
	private double score;
	private String gender;
	private String mno;
	private String mname;
	
	public StudentDTO() {	}

	public StudentDTO(String sno, String sname, double score, String gender, String mno, String mname) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.gender = gender;
		this.mno = mno;
		this.mname = mname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "StudentDTO [sno=" + sno + ", sname=" + sname + ", score=" + score + ", gender=" + gender + ", mno="
				+ mno + ", mname=" + mname + "]";
	}
	
	
	
	
	
}
