package interfaces;

import classes.food.Ingredient;
import exceptions.IngredentException;

public interface IMeal {

	void addIngredients(Ingredient ingredient) throws IngredentException;

}