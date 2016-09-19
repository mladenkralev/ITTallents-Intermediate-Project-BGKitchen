package cartAndOrder;

import java.util.Set;

import food.ingredient.Ingredient;
import food.meal.Meal;

public interface ICart {

	void addMeal(Meal meal) throws CartException;

	void removeMeal(Meal meal) throws CartException;

	void removeAll();

	void addIngridiant(String name, Ingredient ingridiant) throws CartException;

	float getBallance();

	Cart.Order giveMeOrder() throws OrderException;
	
	Set<Meal> getMealsToOrder();
}