package model.dto;

public class PositionDTO {
	private String posNo;
	private String posName;

	public PositionDTO(String posNo, String posName) {
		this.posNo = posNo;
		this.posName = posName;
	}

	public PositionDTO() {	}

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	@Override
	public String toString() {
		return "PositionDTO [posNo=" + posNo + ", posName=" + posName + "]";
	}

}
