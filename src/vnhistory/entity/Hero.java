package vnhistory.entity;

public class Hero extends Figure {
	private String tenKhac;
	private String tinhThanh;

	public Hero(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getTenKhac() {
		return tenKhac;
	}

	public void setTenKhac(String tenKhac) {
		this.tenKhac = tenKhac;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

}
