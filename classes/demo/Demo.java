package classes.demo;

import classes.cart.Cart;
import classes.food.Creteria;
import classes.food.Ingredient;
import classes.food.Meal;
import classes.food.Menu;
import classes.user.Site;
import classes.user.User;
import exceptions.CartException;
import exceptions.IngredentException;
import exceptions.LogInException;
import exceptions.MealException;
import exceptions.MenuException;
import exceptions.RegistrationException;
import exceptions.SiteException;
import interfaces.IMenu;

public class Demo {
	public static void main(String[] args) {

		try {

			// site
			Site site = new Site("bg kitchen");
			site.registerUser("goshot", "pecataetup", "asma@amsc.com");

			// menu
			IMenu menu = new Menu();

			// meal First
			Ingredient bob = new Ingredient("bob", 1.5f);
			Ingredient nadenica = new Ingredient("nadenica", 1.5f);

			Meal bobSnadenica = new Meal(bob.getName() + " s " + nadenica.getName());
			bobSnadenica.addIngredients(bob);
			bobSnadenica.addIngredients(nadenica);
			bobSnadenica.setVegan(false);

			// meal second
			Ingredient bobZaSupa = new Ingredient("bob", 1.5f);
			Ingredient morkov = new Ingredient("morkov", 0.5f);

			Meal bobChorba = new Meal(bobZaSupa.getName() + " s " + morkov.getName());
			bobChorba.addIngredients(bobZaSupa);
			bobChorba.addIngredients(morkov);
			bobChorba.setVegan(true);

			// adding in menu

			menu.addMeal("Osnovno", bobSnadenica);
			menu.addMeal("Supi", bobChorba);

			System.out.println("supi: " + menu.getMealsFromCategory("Supi"));
			System.out.println("osnovni: " + menu.sortBy(Creteria.PRICE));

			User me = site.logInUser("goshot", "pecataetup");
			Cart myCart = (Cart) me.getCart();

			myCart.addMeal(bobChorba);
			myCart.addMeal(bobSnadenica);
			
			System.out.println("balanca e " + myCart.getBallance());
			myCart.removeMeal(bobSnadenica);
			
			System.out.println("balanca e " + myCart.getBallance());
			System.out.println(myCart.getMealsToOrder());

		} catch (IngredentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MealException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RegistrationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LogInException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SiteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
