package ru.vladigeras.warehouse;

import java.util.Collection;

/**
 * Abstract warehouse entity
 *
 * @author vladi_geras on 01/11/2018
 */
public abstract class Warehouse {
	private Long id;
	private String title;
	private Collection items;

	public abstract void addItem();

	public abstract void removeItem();

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

	public Collection getItems() {
		return items;
	}
}
