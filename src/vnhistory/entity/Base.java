package vnhistory.entity;

public abstract class Base {
	private int id;
	private String ten;
	private static int nbEntity = 0;

	public Base(String ten) {
		super();
		this.ten = ten;
		id = ++nbEntity;
	}

	public int getId() {
		return id;
	}

	public String getTen() {
		return ten;
	}

}
