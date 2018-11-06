package ru.vladigeras.warehouse;

/**
 * Abstract item entity for storing in {@link Warehouse}
 *
 * @author vladi_geras on 02/11/2018
 */
public abstract class Item {
	private Long id;
	private String title;
	private Double price;

	public Item() {
	}

	public Item(Long id, String title, Double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", title='" + title + '\'' +
				", price=" + price +
				'}';
	}
}
