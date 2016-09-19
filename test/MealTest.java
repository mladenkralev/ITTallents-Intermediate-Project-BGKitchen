import static org.junit.Assert.*;

import org.junit.Test;

import food.meal.Meal;
import food.meal.MealDAO;
import food.meal.MealException;

public class MealTest {

	@Test
	public void test() throws MealException {
		Meal meal = new Meal("Nadenicata", false, "asd.jpg");
		meal.setVegan(false);
		
		int id = new MealDAO().addMeal(meal);
		
		assertNotEquals(id, 0);
		
	}

}
