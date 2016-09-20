import static org.junit.Assert.*;

import org.junit.Test;

import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.ingredient.IngredientDAO;
import food.meal.Meal;
import food.meal.MealDAO;
import food.meal.MealException;

public class MealTest {
	private MealDAO mealTest = new MealDAO();
	private IngredientDAO ingredientTest = new IngredientDAO();

	@Test
	public void test() throws MealException {
		try {
			Meal banica = new Meal("Таратор", true, "dish/tarator.jpg");

			Ingredient kori = new Ingredient("Кисело мляко", 1f);
			Ingredient sirene = new Ingredient("краставица", 1f);

			ingredientTest.addIngredient(sirene);
			ingredientTest.addIngredient(kori);

			banica.addIngredients(kori);
			banica.addIngredients(sirene);

			int id = new MealDAO().addMeal(banica);

			assertNotEquals(id, 0);
		} catch (IngredentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
