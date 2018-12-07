package ru.vladigeras.warehouse;

import java.util.Random;

/**
 * Сlient application and system entry point
 * @author vladi_geras on 31/10/2018
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("------------- Warehouse initializing ------------");

		var warehouse = gadgetWarehouseInit();

		System.out.println();

		warehouse.printItems();

		System.out.println();

		warehouse = deleteItem(warehouse);
		warehouse.printItems();
	}

	private static Warehouse gadgetWarehouseInit() {
		var gadgetWarehouse = new GadgetWarehouse(1L, "Gadget warehouse");
		gadgetWarehouse.addItem(new Gadget(1L, "Smartphone", 18.990, "Apple IPhone SE"));
		gadgetWarehouse.addItem(new Gadget(2L, "Smartphone", 37.990, "Apple IPhone 7"));
		gadgetWarehouse.addItem(new Gadget(3L, "Smartphone", 62.000, "Apple MacBook Air"));

		return gadgetWarehouse;
	}

	private static Warehouse deleteItem(Warehouse warehouse) {
		var randomInt = new Random().nextInt(3) + 1;
		System.out.println("Deleted id is " + randomInt + " now");

		warehouse.removeItem(warehouse.getItems().get(randomInt - 1));
		return warehouse;
	}
}
