package com.unislabs.helloworld;

import java.util.Collection;
import java.util.Random;

import com.unislabs.rent.*;


public class HelloWorld {

	public static int DEBUG = 0;

	public static void debug(int debug_level, String s) {
		if (debug_level <= DEBUG) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		Collection<TradeCenter> TC = GenerateTrades.getTradeCenters(5);
		
		for (TradeCenter tradeCenter : TC) {
			System.out.println(tradeCenter.toString());
		}
		
//		TradeCenter tc = new TradeCenter(TradeCenterType.CENTER, "Ромашка", "Кукуево");
//		// Box box = new BoxClothes(3);
//		Floor floor = new Floor("t", true);
//		System.out.println(floor.getChargeFirst());
//		// floor.getBoxes().add(box);
//		tc.getFloors().add(floor);
//		tc.getAddress();
		// System.out.println(tc);
		// System.out.println(box.getType());
		// System.out.println(new BoxElectronics(3).getType());

//		String s = "dsfsdf";
//		System.out.println(s);
//		System.out.println(s.toUpperCase());
//		System.out.println(s);
//		"dsfsdf".toUpperCase();

//		for (int i = 0; i < args.length; i++) {
//			System.out.println("args[" + i + "] = " + args[i]);
//		}
//
//		for (int j = 0; j < 4; j++) {
//			System.out.println(r(0, 5));
//		}
//		System.out.println(parse("321") * 2);
//		int bits = 1;
//		for (int n = 8 - 1; (n >>= 1) > 0; bits++) {
//		}
//		System.out.println(bits);
	}

	final public static int R = 8;

	public static int r() {
		Random r = new Random();
		return r.nextInt(1 << R);
	}

	public static int r(int max) {
		int bits = 0;
		for (int n = max - 1; n > 0; n >>= 1) {
			bits++;
		}
		debug(1, "bits = " + bits);
		int num = (bits + R - 1) / R;
		debug(1, "num = " + num);
		int res;
		do {
			res = 0;
			for (int i = 0; i < num; i++) {
				res = (res << R) + r();
			}
			debug(2, "r(max) i res = " + res);
			res >>= num * R - bits;
			debug(2, "r(max) i res >>= " + res);
		} while (res >= max);
		debug(1, "r(max) res = " + res);
		return res;
	}

	public static int r(int min, int max) {
		return r(max - min) + min;
	}

	public static int parse(String s) {
		int res = 0;
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			res = res * 10 + c[i] - '0';
		}
		return res;
	}

}
