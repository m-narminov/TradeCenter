package com.unislabs.rent;

public enum BoxType {
	CLOTHES(1, "Одежда", BoxClothes.class), ELECTRONICS(2, "Электроника", BoxElectronics.class),
	FOOD(3, "Продукты", BoxFood.class);
	private int id;
	private String name;
	private Class box;// = BoxClothes.class;

	private BoxType(int id, String name, Class box) {
		this.id = id;
		this.name = name;
		this.box = box;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Class getBox() {
		return box;
	}

	public static BoxType getTypeById(int id) {
		for (BoxType type : BoxType.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		throw new BoxTypeException("Неизвестный id бокса: " + id + " " + BoxType.values());
	}

	public static BoxType getTypeByClass(Class box) {
		for (BoxType type : BoxType.values()) {
			if (type.box.equals(box)) {
				return type;
			}
		}
		throw new BoxTypeException("Неизвестный тип бокса: " + box.getName() + " " + BoxType.values());
	}
}
