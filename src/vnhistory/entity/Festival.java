package vnhistory.entity;

public class Festival extends Base {
	private String diaDiem;
	private String batDau;
	private String lanDau;
	private String nhanVat;

	public Festival(String ten) {
		super(ten);
		// TODO Auto-generated constructor stub
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getBatDau() {
		return batDau;
	}

	public void setBatDau(String batDau) {
		this.batDau = batDau;
	}

	public String getLanDau() {
		return lanDau;
	}

	public void setLanDau(String lanDau) {
		this.lanDau = lanDau;
	}

	public String getNhanVat() {
		return nhanVat;
	}

	public void setNhanVat(String nhanVat) {
		this.nhanVat = nhanVat;
	}

	@Override
	public String toString() {
		return "Festival [diaDiem=" + diaDiem + ", batDau=" + batDau + ", lanDau=" + lanDau + ", nhanVat=" + nhanVat
				+ "]";
	}

}
