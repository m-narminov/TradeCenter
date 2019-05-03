
package com.unislabs.rent;

public class BoxElectronics extends Box {
	private int countSockets;
	private int commonConsumption;
	private double costElectricity;

	public BoxElectronics() {
		super();
	}

	public BoxElectronics(int countSockets, double square) {
		super();
		this.countSockets = countSockets;
		setSquare(square);
	}

	public int getCountSocets() {
		return this.countSockets;
	}

	public void setCountSocets(int countSocets) {
		this.countSockets = countSocets;
	}

	public double getCostElectricity() {
		return this.costElectricity;
	}

	public void setCostElectricity(int costElectricity) {
		this.costElectricity = costElectricity;
	}

	public int getCommonConsumption() {
		return this.commonConsumption;
	}

	public void setCommonConsumption(int commonConsumption) {
		this.commonConsumption = commonConsumption;
	}

	@Override
	protected double getRentType(double rentBase) {
		double rent = 0;
		if (commonConsumption > 500)
			rent += commonConsumption - 500 * this.costElectricity;
		if (this.countSockets > 5)
			rent += this.countSockets * 200;
		return rentBase + rent;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder("\nЭлектроника: ").append(getNumber()).append("\n розеток: ").append(countSockets)
				.append("\n общее потребление: ").append(commonConsumption).append("\n стоимость аренды: ").append(getRentType(super.getRentRate()));
		return res.append("\n").toString();
	}
}