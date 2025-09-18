package vnhistory.entity;

public class Dynasty extends Base {
	private String thuDo;
	private String chinhPhu;
	private String viThe;
	private String ngonNgu;
	private String tinhTrang;
	private String tonGiao;
	private String tienTe;

	public Dynasty(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getThuDo() {
		return thuDo;
	}

	public void setThuDo(String thuDo) {
		this.thuDo = thuDo;
	}

	public String getChinhPhu() {
		return chinhPhu;
	}

	public void setChinhPhu(String chinhPhu) {
		this.chinhPhu = chinhPhu;
	}

	public String getViThe() {
		return viThe;
	}

	public void setViThe(String viThe) {
		this.viThe = viThe;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getTienTe() {
		return tienTe;
	}

	public void setTienTe(String tienTe) {
		this.tienTe = tienTe;
	}
	
	@Override
	public String toString() {
		return "Dynasty [thuDo=" + thuDo + ", chinhPhu=" + chinhPhu + ", viThe=" + viThe + ", ngonNgu=" + ngonNgu
				+ ", tinhTrang=" + tinhTrang + ", tonGiao=" + tonGiao + ", tienTe=" + tienTe + ", getTen()=" + getTen()
				+ "]";
	}

}
