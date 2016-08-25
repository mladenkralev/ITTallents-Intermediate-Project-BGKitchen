package demo;

import cart.Cart;
import cart.CartException;
import food.creteria.Creteria;
import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.meal.Meal;
import food.meal.MealException;
import food.menu.IMenu;
import food.menu.Menu;
import food.menu.MenuException;
import food.promo.PromotionMenu;
import user.site.LogInException;
import user.site.RegistrationException;
import user.site.Site;
import user.site.SiteException;
import user.users.User;
import user.users.UserException;

public class Demo {
	public static void main(String[] args) {

		try {
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
			Ingredient oriz = new Ingredient("bob", 1.5f);
			Ingredient morkov = new Ingredient("morkov", 0.5f);

			Meal orizSMorkov = new Meal(oriz.getName() + " s " + morkov.getName());
			orizSMorkov.addIngredients(oriz);
			orizSMorkov.addIngredients(morkov);
			orizSMorkov.setVegan(true);
			
			//desserts
			Ingredient shokolad = new Ingredient("shokolad", 2.5f);
			Meal shokoladMeal = new Meal(shokolad.getName());
			
			Ingredient vafliNaq = new Ingredient("vafliNaq", 0.5f);
			Meal vafliMeal = new Meal(vafliNaq.getName());

			
			//soups
			Ingredient fide = new Ingredient("fide", 2.3f);
			Meal supaSFide = new Meal(fide.getName());
			
			Ingredient kartofi = new Ingredient("fide", 2.3f);
			Meal kartofenaSupe = new Meal(kartofi.getName());
			
			// adding in menu
			menu.addMeal("Desert", vafliMeal);
			menu.addMeal("Desert", shokoladMeal);
			
			menu.addMeal("Osnovno", bobSnadenica);
			menu.addMeal("Osnovno", orizSMorkov);
			
			menu.addMeal("Supa", supaSFide);
			menu.addMeal("Supa", kartofenaSupe);
			
		
//
//			System.out.println("supi: " + menu.getMealsFromCategory("Supa"));
//			System.out.println("osnovni: " + menu.sortMealsBy("Osnovno", Creteria.PRICE));

			
			
			
			
			// site
			Site site = new Site("bg kitchen", menu);
			site.registerUser("goshot", "pecataetup", "asma@amsc.com");

			User me = site.logInUser("goshot", "pecataetup");
			Cart myCart = (Cart) me.getCart();

			myCart.addMeal(orizSMorkov);
			myCart.addMeal(bobSnadenica);

			System.out.println("balanca e " + myCart.getBallance());
			myCart.removeMeal(bobSnadenica);

			System.out.println("balanca e " + myCart.getBallance());
			System.out.println(myCart.getMealsToOrder());
			
			me.order();
			System.out.println(me.giveMeAllOrders());
			myCart.addMeal(orizSMorkov);
			myCart.addMeal(bobSnadenica);
			me.order();
			System.out.println(me.giveMeAllOrders());
			System.out.println(me.getCart().getBallance());

			
//			
//			site.generateDailyMenu();
//			PromotionMenu menuFirst = site.getPromoMenu();
//			System.out.println(menuFirst);
//			
//			site.generateDailyMenu();
//			PromotionMenu menuSecond = site.getPromoMenu();
//			System.out.println(menuSecond);

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
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
