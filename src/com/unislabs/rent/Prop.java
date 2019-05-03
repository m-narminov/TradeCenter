package com.unislabs.rent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Prop {

	public static final String CONFIG_FILE_NAME = "config.properties";

	public static final String FLOOR_CHARGE_FIRST = "floor.charge.first";
	
	public static final String TC_COUNT = "tc.count";
	
	public static final String TC_RENT_BASE = "tc.rent.base";
	
	public static final String BOX_FOOD_FRIDGES_PRICE = "box.food.fridges.price";
	
	public static final String BOX_FOOD_FRIDGES_LIM = "box.food.fridges.lim";
	
	public static final String BOX_FOOD_SCALES_PRICE = "box.food.scales.price";
	
	public static final String BOX_CLOTHES_ROOMS_PRICE = "box.clothes.rooms.price";
	
	public static final String BOX_ELECTRO_SOCKETS_LIM = "box.electro.sockets.lim";
	
	public static final String BOX_ELECTRO_POWER_LIM = "box.electro.power.lim";
	
	public static final String BOX_ELECTRO_POWER_RENT = "box.electro.power.rent";
	
	public static final String BOX_ELECTRO_SOCKETS_PRICE = "box.electro.sockets.price";

	private static Properties properties;

	private Prop() {
	}

	public static synchronized String getProp(String propName) throws IOException {
		if (properties == null) {
			properties = new Properties();
			InputStream propis = Prop.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
			if (propis != null) {
				properties.load(propis);
			} else {
				properties = null;
				throw new FileNotFoundException("Configuration file not found: " + CONFIG_FILE_NAME);
			}
		}
		return properties.getProperty(propName);
	}

	public static synchronized double getPropDouble(String propName) throws FileNotFoundException, IOException {
		return Double.parseDouble(getProp(propName));
	}
}
