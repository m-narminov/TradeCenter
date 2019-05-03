package com.unislabs.rent;

import java.util.ArrayList;
import java.util.Collection;

import com.unislabs.helloworld.HelloWorld;

public class TradeCenter {
	private TradeCenterType type;
	private String name;
	private String address;
	private Collection<Floor> floors = new ArrayList<Floor>();
	private byte totalFloors;
	
	public TradeCenter() {
		super();
	}

	public TradeCenter(TradeCenterType type, String name, String address) {
		super();
		this.type = type;
		this.name = name;
		this.address = address;
		totalFloors = (byte) HelloWorld.r(1, 5); //заменить диапазон на переменные
		
		//эти значения вставить сюда тоже
		for (int i = 1; i <= totalFloors; i++) {
			if (i == 1) {
				floors.add(new Floor(String.valueOf(i) , true));
				continue;
			}
			floors.add(new Floor(String.valueOf(i) , false));
		}
	}

	public double getCharge() {
		return type.getCharge();
	}

	public TradeCenterType getType() {
		return type;
	}

	public void setType(TradeCenterType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Описание метода
	 * 
	 * @return адрес
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Floor> getFloors() {
		return floors;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("\nТорговый центр: ").append(type).append(", название: ").append(name)
				.append(", адрес: ").append(address).append(", всего этажей: ").append(totalFloors).append("\n");
		for (Floor floor : floors) {
			res.append(floor);
		}
		return res.append("\n").toString();
	}
}
