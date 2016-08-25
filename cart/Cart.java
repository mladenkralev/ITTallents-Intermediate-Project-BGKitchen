package cart;

import java.util.Set;
import java.util.TreeSet;

import comaparator.PriceComparator;
import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.meal.Meal;
import order.Order;
import order.OrderException;

public class Cart implements ICart {
	private float ballance;
	private Set<Meal> melasToOrder = new TreeSet<Meal>(new PriceComparator());

	@Override
	public void addMeal(Meal meal) throws CartException {
		if (meal != null) {
			try {
				Meal orderMeal = (Meal) meal.clone();
				melasToOrder.add(orderMeal);
				recalculatePrice();
			} catch (CloneNotSupportedException e) {
				throw new CartException("Something went wrong during addiong your meal");
			}
		} else {
			throw new CartException("This is not a legal meal to be added");
		}
	}

	@Override
	public void removeMeal(Meal meal) throws CartException {
		if (meal != null && melasToOrder.contains(meal)) {
			melasToOrder.remove(meal);
			recalculatePrice();
		} else {
			throw new CartException("There is not such a meal to be removed");
		}
	}

	private void recalculatePrice() {
		this.ballance = 0;
		for (Meal meal : melasToOrder) {
			this.ballance += meal.getPrice();
		}
	}

	@Override
	public void removeAll() {
		melasToOrder.removeAll(melasToOrder);
		recalculatePrice();
	}

	@Override
	public float getBallance() {
		return ballance;

	}

	public Set<Meal> getMealsToOrder() {
		return melasToOrder;
	}

	public void addIngridiant(String name, Ingredient ingridiant) throws CartException {
		for (Meal meal : melasToOrder) {
			if (meal.getName().equals(name)) {
				try {
					meal.addIngredients(ingridiant);
				} catch (IngredentException e) {
					throw new CartException("Problem with adding Ingredient", e);
				}
			}
		}

	}


	public Order giveMeOrder() throws OrderException {
		return new Order(this);
	}
	
}
