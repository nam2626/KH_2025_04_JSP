package model.dto;

public class DepartmentDTO {
	private String deptNo;
	private String deptName;

	public DepartmentDTO() { }

	public DepartmentDTO(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}

}
