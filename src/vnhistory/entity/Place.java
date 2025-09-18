package vnhistory.entity;

public class Place extends Base {
	private String diaChi;
	private String thanhLap;
	private String nguoiLap;
	private String congTrang;
	private String leHoi;

	public Place(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getThanhLap() {
		return thanhLap;
	}

	public void setThanhLap(String thanhLap) {
		this.thanhLap = thanhLap;
	}

	public String getNguoiLap() {
		return nguoiLap;
	}

	public void setNguoiLap(String nguoiLap) {
		this.nguoiLap = nguoiLap;
	}

	public String getCongTrang() {
		return congTrang;
	}

	public void setCongTrang(String congTrang) {
		this.congTrang = congTrang;
	}

	public String getLeHoi() {
		return leHoi;
	}

	public void setLeHoi(String leHoi) {
		this.leHoi = leHoi;
	}

	@Override
	public String toString() {
		return "Place [diaChi=" + diaChi + ", thanhLap=" + thanhLap + ", nguoiLap=" + nguoiLap + ", congTrang="
				+ congTrang + ", leHoi=" + leHoi + "]";
	}

}
