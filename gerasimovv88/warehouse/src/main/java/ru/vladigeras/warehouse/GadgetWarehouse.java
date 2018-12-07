package ru.vladigeras.warehouse;

/**
 * Gadget warehouse entity which extends of abstract {@link Warehouse}, contanins a gadget items
 *
 * @author vladi_geras on 03/11/2018
 */
public class GadgetWarehouse extends Warehouse {

	public GadgetWarehouse() {
		super();
	}

	public GadgetWarehouse(Long id, String title) {
		super(id, title);
	}

	@Override
	public void addItem(Item item) {
		if (item instanceof Gadget) {
			items.add(item);
			System.out.println("Item with id = " + item.getId() + " was added to warehouse");
		} else {
			throw new IllegalArgumentException("You cannot add to the warehouse another type of item");
		}
	}

	@Override
	public void removeItem(Item item) {
		if (item == null) throw new IllegalArgumentException("Deleted item is null");

		items.remove(items.get(item.getId().intValue() - 1));
		System.out.println("Item with id = " + item.getId() + " was removed from warehouse");
	}

	@Override
	public void printItems() {
		System.out.println("This warehouse contains: ");
		items.forEach(i -> System.out.println(i.toString()));
	}
}