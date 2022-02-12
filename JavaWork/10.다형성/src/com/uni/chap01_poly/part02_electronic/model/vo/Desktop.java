package com.uni.chap01_poly.part02_electronic.model.vo;

public class Desktop extends Electronic {

	public static final String CPU ="intel";
	private String graphic;
	
	public Desktop() {
		// TODO Auto-generated constructor stub
	}

	public Desktop(String brand, String name, int prcie, String graphic) {
		super(brand, name, prcie);
		this.graphic=graphic;
	}

	public String getGraphic() {
		return graphic;
	}

	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}

	public static String getCpu() {
		return CPU;
	}

	@Override
	public String toString() {
		return "Desktop [graphic=" + graphic + ", CPU=" + CPU + ", toString()=" + super.toString() + "]";
	}
	
}
