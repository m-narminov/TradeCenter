package com.unislabs.rent;

public abstract class Box {

	protected String number;
	protected double square;
	protected Floor floor;
	private BoxType type;
	private double rentRate = 500;

	{
		setType(BoxType.getTypeByClass(this.getClass()));
	}

	public Box() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public double getRentRate() {
		return rentRate;
	}

	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}

	public BoxType getType() {
		return type;
	}

	protected void setType(BoxType type) {
		this.type = type;
	}

	protected abstract double getRentType(double rentBase);
	public abstract String toString();

	public double getRent() {
		return getRentType(this.rentRate * this.square) * getFloor().getCharge();
	}
}
