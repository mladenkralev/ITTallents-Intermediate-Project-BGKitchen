package classes.food;

import exceptions.IngredentException;

public class Ingredient {
	private String name;
	private float price;

	public Ingredient(String name, float price) throws IngredentException {
		if ((name == null) || (name.trim().equals("")) || name.matches(".*\\d.*") || (price <= 0)) {
			throw new IngredentException("Nevalidni sustavki");
		}
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", price=" + price + "]";
	}

}
