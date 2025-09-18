package vnhistory.entity;

public class King extends Figure{
	private String cha;
	private String me;
	private String thoiGianTriVi;
	private String tienNhiem;
	private String keNhiem;
	private String noiAnNghi;
	
	public King(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getCha() {
		return cha;
	}

	public void setCha(String cha) {
		this.cha = cha;
	}

	public String getMe() {
		return me;
	}

	public void setMe(String me) {
		this.me = me;
	}

	public String getThoiGianTriVi() {
		return thoiGianTriVi;
	}

	public void setThoiGianTriVi(String thoiGianTriVi) {
		this.thoiGianTriVi = thoiGianTriVi;
	}

	public String getTienNhiem() {
		return tienNhiem;
	}

	public void setTienNhiem(String tienNhiem) {
		this.tienNhiem = tienNhiem;
	}

	public String getKeNhiem() {
		return keNhiem;
	}

	public void setKeNhiem(String keNhiem) {
		this.keNhiem = keNhiem;
	}

	public String getNoiAnNghi() {
		return noiAnNghi;
	}

	public void setNoiAnNghi(String noiAnNghi) {
		this.noiAnNghi = noiAnNghi;
	}

	@Override
	public String toString() {
		return "King [cha=" + cha + ", me=" + me + ", thoiGianTriVi=" + thoiGianTriVi + ", tienNhiem=" + tienNhiem
				+ ", keNhiem=" + keNhiem + ", noiAnNghi=" + noiAnNghi + "]" + this.getTen();
	}

}
