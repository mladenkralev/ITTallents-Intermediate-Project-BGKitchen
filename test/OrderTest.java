import static org.junit.Assert.*;

import org.junit.Test;

import cartAndOrder.CartException;
import cartAndOrder.OrderDAO;
import cartAndOrder.OrderException;
import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.meal.Meal;
import food.meal.MealDAO;
import food.meal.MealException;
import user.users.PasswordException;
import user.users.User;
import user.users.UserDAO;
import user.users.UserException;

public class OrderTest {

	@Test
	public void test() throws PasswordException, UserException, CartException, MealException, OrderException, IngredentException {
		User testUser = new User("AasdD", "parolata", "asd");
		
		int id2 = new UserDAO().loginUser(testUser);
		
		testUser.setId(id2);
		
		Meal meal1 = new Meal("Bob s nadenica", false, "asd.jpg");
		meal1.setVegan(false);
		Meal meal2 = new Meal("Pile s oriz", false, "asd.jpg");
		meal2.setVegan(false);
		meal2.addIngredients(new Ingredient("Oriz", 25f));
		
		testUser.getCart().addMeal(meal1);
		testUser.getCart().addMeal(meal2);
		
		int orderid = new OrderDAO().createAnOrder(testUser);
		
		assertNotEquals(orderid, 0);
		
	}

}
