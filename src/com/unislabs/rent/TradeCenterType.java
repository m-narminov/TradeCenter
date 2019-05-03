package com.unislabs.rent;

public enum TradeCenterType {
	CENTER(1, "В центре", 2), CORNER(2, "На окраине", 1.2), COUNTRY(3, "За городом", 1);
	private int id;
	private String name;
	private double charge;

	TradeCenterType(int id, String name, double charge) {
		this.id = id;
		this.name = name;
		this.charge = charge;
	}
	
	public static TradeCenterType getTypeById(int id) { 
		for (TradeCenterType type : TradeCenterType.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		throw new TradeCenterTypeException("Неизвестный id Торгового центра0: " + id + " " + TradeCenterType.values());
	}

	protected int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCharge() {
		return charge;
	}

	@Override
	public String toString() {
		return "Расположение торгового центра: " + name + "; id = " + id + "; наценка: " + charge;
	}
}
