package food.menu;

import java.util.Set;

import food.creteria.Creteria;
import food.meal.Meal;

public interface IMenu {

	void addMeal(String category, Meal mealToAdd) throws MenuException;

	Set<Meal> getMealsFromCategory(String category) throws MenuException;

	Set<Meal> sortMealsBy(String menuCategory, Creteria criteria);

}