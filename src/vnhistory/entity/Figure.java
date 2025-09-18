package vnhistory.entity;

public abstract class Figure extends Base {
	private String trieuDai;
	private String ngaySinh;
	private String ngayMat;

	public Figure(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getTrieuDai() {
		return trieuDai;
	}

	public void setTrieuDai(String trieuDai) {
		this.trieuDai = trieuDai;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNgayMat() {
		return ngayMat;
	}

	public void setNgayMat(String ngayMat) {
		this.ngayMat = ngayMat;
	}
}
