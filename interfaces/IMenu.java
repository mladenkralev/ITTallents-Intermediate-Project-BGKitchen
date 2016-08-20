package interfaces;

import java.util.Set;

import classes.food.Creteria;
import classes.food.Meal;
import exceptions.MenuException;

public interface IMenu {

	void addMeal(String category, Meal mealToAdd) throws MenuException;

	Set<Meal> getMealsFromCategory(String category) throws MenuException;

	Set<Meal> sortMealsBy(String menuCategory, Creteria criteria);

}