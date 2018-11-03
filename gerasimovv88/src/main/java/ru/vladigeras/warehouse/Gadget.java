package ru.vladigeras.warehouse;

/**
 * Gadget entity for storing in {@link GadgetWarehouse}
 *
 * @author vladi_geras on 03/11/2018
 */
public class Gadget extends Item {

	private String model;

	public Gadget() {
	}

	public Gadget(Long id, String title, Double price, String model) {
		super(id, title, price);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return super.toString() + " Gadget{" +
				"model='" + model + '\'' +
				'}';
	}
}