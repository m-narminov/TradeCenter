package com.unislabs.rent;

public class BoxFood extends Box {
	private int countRef;
	private int countScale;

	public BoxFood() {
		super();
	}

	public BoxFood(int countRef, int countScale, double square) {
		super();
		this.countRef = countRef;
		this.countScale = countScale;
		setSquare(square);
	}

	public int getCountRef() {
		return countRef;
	}

	public int getCountScale() {
		return countScale;
	}

	public void setCountRef(int countRef) {
		this.countRef = countRef;
	}

	public void setCountScale(int countScale) {
		this.countScale = countScale;
	}

	@Override
	protected double getRentType(double rentBase) {
		double discount = (this.countRef > 3) ? 0.9 : 1;
		return (rentBase + 20 * this.countScale + 50 * this.countRef) * discount;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("\nПродукты: ").append(getNumber()).append("\n хол. камер: ").append(countRef)
				.append("\n весов: ").append(countScale).append("\n стоимость аренды: ").append(getRentType(super.getRentRate()));
		return res.append("\n").toString();
	}
}