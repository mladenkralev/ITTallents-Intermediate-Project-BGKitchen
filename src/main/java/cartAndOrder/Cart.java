package cartAndOrder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

import comaparator.PriceComparator;
import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.meal.Meal;

public class Cart implements ICart {

	/*
	 * This class consists Order class and Status enum
	 */

	private float ballance;
	private Set<Meal> melasToOrder = new TreeSet<Meal>(new PriceComparator());
	private static int currentIdOrders = 0;

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

	@Override
	public cartAndOrder.Cart.Order giveMeOrder() throws OrderException {
		return new Order(this);
	}

	public enum Status {
		ORDERED, ON_ITS_WAY, DELIVERED
	}

	public class Order implements IOrder {

		private ICart cart;
		private LocalDateTime dateAndHours;
		private Status status;
		private int id;

		public Order(ICart cart) throws OrderException {
			if (cart == null) {
				throw new OrderException("Cant order this, your cart doesnt exist");
			}

			if (cart.getBallance() <= 0) {
				throw new OrderException("Your ballance is invalid");
			}

			this.cart = cart;
			this.dateAndHours = LocalDateTime.now();
			this.status = Status.ORDERED;
			this.id = currentIdOrders++;
		}

		@Override
		public void readyForTravelling() {
			this.status = Status.ON_ITS_WAY;
		}

		@Override
		public void delivered() {
			this.status = Status.DELIVERED;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", cart=" + cart + ", dateAndHours=" + dateAndHours + ", status=" + status + "]";
		}

		public int getId() {
			return id;
		}
	}

	public Set<Meal> getMealsToOrder() {
		Set<Meal> result = new TreeSet<Meal>(new PriceComparator());
		result.addAll(melasToOrder);
		return result;
	}
}
