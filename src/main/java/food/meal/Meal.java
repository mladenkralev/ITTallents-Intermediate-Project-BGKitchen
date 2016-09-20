package food.meal;

import java.util.HashSet;
import java.util.Set;

import food.ingredient.IngredentException;
import food.ingredient.Ingredient;

public class Meal implements IMeal, Cloneable {
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();
	private String name;
	private float price;
	private boolean isVegan;
	private String picturePath;
	
	public Meal(String name, boolean isVegan , String picturePath) throws MealException {
		if ((name == null) || (name.trim().equals("")) ||(picturePath == null) || (picturePath.trim().equals("")) || (name.matches(".*\\d.*"))) {
			throw new MealException("Ne moga da suzdam takova bludo s tezi dani");
		}
		this.name = name;
		this.picturePath=picturePath;
		this.isVegan=isVegan;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classes.food.IMeal#addIngredients(classes.food.Ingredient)
	 */
	@Override
	public void addIngredients(Ingredient ingredient) throws IngredentException {
		if (ingredient != null) {
			this.ingredients.add(ingredient);
			calculatePrice();
		} else {
			throw new IngredentException("Sustavkata e navalidna");
		}
	}

	private void calculatePrice() {
		this.price = 0;
		for (Ingredient ingredient : ingredients) {
			this.price += ingredient.getPrice();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public float getPrice() {
		return price;
	}

	public boolean isVegan() {
		return isVegan;
	}

	public void setVegan(boolean isVegan) {
		this.isVegan = isVegan;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Meal [name=" + name + ", ingredients=" + ingredients + ", price=" + price + ", isVegan=" + isVegan
				+ "]";
	}

	public String getPath() {
		return picturePath;
	}

	public Set<Ingredient> getIngredients() {
		return this.ingredients;
	}

}
