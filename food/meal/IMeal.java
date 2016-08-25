package food.meal;

import food.ingredient.IngredentException;
import food.ingredient.Ingredient;

public interface IMeal {

	void addIngredients(Ingredient ingredient) throws IngredentException;

}