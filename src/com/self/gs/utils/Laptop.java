package com.self.gs.utils;

public class Laptop implements Comparable<Laptop>{
	private int price;
	private int ram;
	private String make;
	public Laptop(int price, int ram, String make) {
		super();
		this.price = price;
		this.ram = ram;
		this.make = make;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "Laptop [price=" + price + ", ram=" + ram + ", make=" + make + "]";
	}
	
	@Override
	public int compareTo(Laptop laptop) {
		if(this.getPrice()>laptop.getPrice())
			return Integer.MAX_VALUE;
		else if(this.getPrice()<laptop.getPrice())
			return Integer.MIN_VALUE;
		else 
		    return 0;
	}
 
	
}
