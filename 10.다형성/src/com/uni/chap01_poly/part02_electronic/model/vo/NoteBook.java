package com.uni.chap01_poly.part02_electronic.model.vo;

public class NoteBook extends Electronic{
	private int usbPort;
	
	public NoteBook() {
		// TODO Auto-generated constructor stub
	}

	public NoteBook(String brand, String name, int prcie,int usbPort) {
		super(brand, name, prcie);
		this.usbPort=usbPort;
	}

	public int getUsbPort() {
		return usbPort;
	}

	public void setUsbPort(int usbPort) {
		this.usbPort = usbPort;
	}

	@Override
	public String toString() {
		return "Notebook [usbPort=" + usbPort + ", toString()=" + super.toString() + "]";
	}
	
	
}
