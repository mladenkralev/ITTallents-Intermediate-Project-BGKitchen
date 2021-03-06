package food.promo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import food.meal.Meal;
import food.menu.IMenu;
import food.menu.MenuException;
import user.site.SiteException;

public class PromotionMenu {
	private static final float PROMOTION_PERCENT = 0.75f;
	private List<Meal> promotionMenu = new ArrayList<Meal>();
	private float sumOfMenu;
	private IMenu menu;

	public PromotionMenu(IMenu menu) throws SiteException {
		if(menu!=null){
			this.menu=menu;
		}
		generateMeals();
		calculatePromotionSum();
	}

	private void generateMeals() throws SiteException {
		try {
			this.promotionMenu.add(givePromotionMeal("Supa"));
			this.promotionMenu.add(givePromotionMeal("Osnovno"));
			this.promotionMenu.add(givePromotionMeal("Desert"));
		} catch (MenuException e) {
			throw new SiteException("Some went wrong while generating the promotion menu", e);
		}
	}

	private Meal givePromotionMeal(String type) throws MenuException, SiteException {
		Set<Meal> meals = menu.getMealsFromCategory(type);
		 int whichMeal = new Random().nextInt(meals.size());
		 int thisMeal = 0;
		for (Meal meal : meals) {
			if (whichMeal == thisMeal) {
				try {
					return (Meal) meal.clone();
				} catch (CloneNotSupportedException e) {
					throw new SiteException("Somethin went wrong while preparing your meal", e);
				}
			}
			thisMeal++;
		}
		return null;

	}

	private void calculatePromotionSum() {
		for (Meal meal : promotionMenu) {
				this.sumOfMenu += (meal.getPrice()*PROMOTION_PERCENT);
		}
	}

	@Override
	public String toString() {
		return "PromotionMenu [promotionMenu=" + promotionMenu + ", sumOfMenu=" + sumOfMenu + "]";
	}

}
