package ru.vladigeras.warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract warehouse entity
 *
 * @author vladi_geras on 01/11/2018
 */
public abstract class Warehouse {
	private Long id;
	private String title;
	protected static List<Item> items = new ArrayList<>();

	public Warehouse() {
	}

	public Warehouse(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	public abstract void addItem(Item item);

	public abstract void removeItem(Item item);

	public abstract void printItems();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Item> getItems() {
		return items;
	}
}
