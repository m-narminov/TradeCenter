package com.unislabs.rent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.unislabs.helloworld.GenerateTrades;
import com.unislabs.helloworld.HelloWorld;

public class Floor {
	private double chargeFirst = 1;
	private String number;
	private boolean isFirst;
	private Collection<Box> boxes = new ArrayList<Box>();
	private TradeCenter tradeCenter;

	{
		try {
			chargeFirst = Prop.getPropDouble(Prop.FLOOR_CHARGE_FIRST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Floor() {
		super();
	}

	public Floor(String number, boolean isFirst) {
		super();
		this.number = number;
		this.isFirst = isFirst;
		int totalBoxes = HelloWorld.r(20, 200);
		
		for (int i = 0; i < totalBoxes; i++) {
			boxes.add(GenerateTrades.getBox(i + "", this));
		}
		
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public Collection<Box> getBoxes() {
		return boxes;
	}

	public double getCharge() {
		return (isFirst() ? chargeFirst : 1) * getTradeCenterCharge();
	}

	public double getTradeCenterCharge() {
		return tradeCenter.getCharge();
	}

	public TradeCenter getTradeCenter() {
		return tradeCenter;
	}

	public void setTradeCenter(TradeCenter tradeCenter) {
		this.tradeCenter = tradeCenter;
	}

	public double getChargeFirst() {
		return chargeFirst;
	}

	public void setChargeFirst(double chargeFirst) {
		this.chargeFirst = chargeFirst;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("Этаж number=").append(number).append(", isFirst=").append(isFirst)
				.append("\n");
		for (Box box : boxes) {
			res.append(box);
		}
		return res.append("\n").toString();
	}
}