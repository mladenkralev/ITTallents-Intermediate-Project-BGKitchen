package cart;

import food.meal.Meal;
import order.Order;
import order.OrderException;

public interface ICart {

	void addMeal(Meal meal) throws CartException;

	void removeMeal(Meal meal) throws CartException;

	void removeAll();
	//
	// public void addIngridiant(Ingidiant ingridiant){
	//
	// }

	float getBallance();

	Order giveMeOrder() throws OrderException;
}