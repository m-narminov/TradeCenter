package com.unislabs.rent;

public class BoxClothes extends Box {

	private int countFittingRooms;

	public BoxClothes() {
		super();
	}

	public BoxClothes(String number, int countFittingRooms, double square, Floor floor) {
		super();
		setNumber(number);
		this.countFittingRooms = countFittingRooms;
		setSquare(square);
		setFloor(floor);
	}

	public int getCountFittingRooms() {
		return this.countFittingRooms;
	}

	public void setCountFittingRooms(int countFittingRooms) {
		this.countFittingRooms = countFittingRooms;
	}

	@Override
	protected double getRentType(double rentBase) {
		return rentBase + this.countFittingRooms * 30;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("Одежда: ").append(getNumber()).append(", примерочных: ").append(countFittingRooms)
				.append("\n стоимость аренды: ").append(getRentType(super.getRentRate()));
		return res.append("\n").toString();
	}
}
