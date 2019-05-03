package com.unislabs.helloworld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import com.unislabs.rent.*;

public class GenerateTrades {

	public static int r(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	
	public static TradeCenter getTradeCenter(String name, String address) {
		TradeCenter TC = null;
		TradeCenterType type = TradeCenterType.getTypeById(r(1, TradeCenterType.values().length + 1));
		switch (type) {
		case CENTER:
			TC = new TradeCenter(TradeCenterType.CENTER, name, address);
			break;
		case CORNER:
			TC = new TradeCenter(TradeCenterType.CORNER, name, address);
			break;
		case COUNTRY:
			TC = new TradeCenter(TradeCenterType.COUNTRY, name, address);
			break;
		default:
		}
		return TC;		
	}
	
	public static Collection<TradeCenter> getTradeCenters(int n) {
		Collection<TradeCenter> TCenters = new ArrayList<TradeCenter>();
		char c;
		for (int i = 0; i < n; i++) {
			TCenters.add(getTradeCenter("ТЦ " + i, "Длинное шоссе, дом " + i));
		}
		return TCenters;
	}

	public static Box getBox(String number, Floor floor) {
		BoxType type = BoxType.getTypeById(r(1, BoxType.values().length + 1));
		Box box = null;
		switch (type) {
		case CLOTHES:
			box = new BoxClothes(number, r(1, 5), r(100, 150) / 10f, floor);
			break;
		case ELECTRONICS:
			box = new BoxElectronics(r(1, 5), r(100, 150) / 10f);
			break;
		case FOOD:
			box = new BoxFood(r(0, 10), r(0, 5), r(100, 150) / 10f);
			break;
		default:
		}
		return box;
	}

	public static Collection<Box> getBoxes(int n, Floor floor) {
		Collection<Box> boxes = new ArrayList<Box>();
		for (int i = 0; i < n; i++) {
			boxes.add(getBox("Бокс номер " + i, floor));
		}
		return boxes;
	}
	
	
	

}
