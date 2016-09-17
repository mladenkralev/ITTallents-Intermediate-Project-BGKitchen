import static org.junit.Assert.*;

import org.junit.Test;

import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.ingredient.IngredientDAO;

public class IngredientTest {

	@Test
	public void test() throws IngredentException {
		Ingredient ingredient = new Ingredient("carevica", 123);
		
		int id = new IngredientDAO().addIngredient(ingredient);
		assertNotEquals(id, 0);
	}

}
