package model.dto;

public class EmployeeDTO {
	private String empNo;
	private String empName;
	private String deptName;
	private String posName;
	private int salary;
	private String hireDate;

	public EmployeeDTO(String empNo, String empName, String deptName, String posName, int salary, String hireDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.deptName = deptName;
		this.posName = posName;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public EmployeeDTO() {	}

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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
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
		return "EmployeeDTO [empNo=" + empNo + ", empName=" + empName + ", deptName=" + deptName + ", posName="
				+ posName + ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}

}
