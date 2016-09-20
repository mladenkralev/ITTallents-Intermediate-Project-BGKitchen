import static org.junit.Assert.assertNotEquals;

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

//	@Test
//	public void test() throws MealException {
//		Meal meal = new Meal("Nadenicata", false, "asd.jpg");
//		meal.setVegan(false);
//
//		int id = new MealDAO().addMeal(meal);
//
//		assertNotEquals(id, 0);
//
//	}

	@Test
	public void test1() throws MealException {
		try {
			Meal banica = new Meal("Баница", true, "dish/banica.jpg");

			Ingredient kori = new Ingredient("Кори", 1f);
			Ingredient sirene = new Ingredient("Сирене", 1f);

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

		try {
			Meal banica = new Meal("Боб чорпба", true, "dish/bobchorba.jpg");

			Ingredient kori = new Ingredient("Боб", 1f);
			Ingredient sirene = new Ingredient("Чорба", 1f);

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

		try {
			Meal banica = new Meal("Мляко с ориз", true, "dish/mlqkosoriz.jpg");

			Ingredient kori = new Ingredient("Мляко", 1f);
			Ingredient sirene = new Ingredient("Ориз", 1f);

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

		try {
			Meal banica = new Meal("Мусака", true, "dish/musaka.jpg");

			Ingredient kori = new Ingredient("Картофи", 1f);
			Ingredient sirene = new Ingredient("Кайма", 1f);

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
