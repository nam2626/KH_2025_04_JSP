package model.dto;

public class EmployeeDTO {
	private String empNo;
	private String empName;
	private String deptNo;
	private String posNo;
	private int salary;
	private String hireDate;

	public EmployeeDTO() {
	}

	public EmployeeDTO(String empNo, String empName, String deptNo, String posNo, int salary, String hireDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.deptNo = deptNo;
		this.posNo = posNo;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empNo=" + empNo + ", empName=" + empName + ", deptNo=" + deptNo + ", posNo=" + posNo
				+ ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}

}
