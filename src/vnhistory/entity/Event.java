package vnhistory.entity;

public class Event extends Base {
	private String diaDiem;
	private String thoiGian;
	private String thamChien;
	private String nguyenNhan;
	private String chiHuy;
	private String tonThat;
	private String ketQua;
	private String lucLuong;

	public Event(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getLucLuong() {
		return lucLuong;
	}

	public void setLucLuong(String lucLuong) {
		this.lucLuong = lucLuong;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getThamChien() {
		return thamChien;
	}

	public void setThamChien(String thamChien) {
		this.thamChien = thamChien;
	}

	public String getNguyenNhan() {
		return nguyenNhan;
	}

	public void setNguyenNhan(String nguyenNhan) {
		this.nguyenNhan = nguyenNhan;
	}

	public String getChiHuy() {
		return chiHuy;
	}

	public void setChiHuy(String chiHuy) {
		this.chiHuy = chiHuy;
	}

	public String getTonThat() {
		return tonThat;
	}

	public void setTonThat(String tonThat) {
		this.tonThat = tonThat;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	@Override
	public String toString() {
		return "Event [diaDiem=" + diaDiem + ", thoiGian=" + thoiGian + ", thamChien=" + thamChien + ", nguyenNhan="
				+ nguyenNhan + ", chiHuy=" + chiHuy + ", tonThat=" + tonThat + ", ketQua=" + ketQua + "]";
	}

}
