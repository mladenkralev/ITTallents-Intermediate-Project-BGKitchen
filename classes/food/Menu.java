package classes.food;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import exceptions.MenuException;
import interfaces.IMenu;

public class Menu implements IMenu {
	private Map<String, Set<Meal>> menuList = new HashMap<String, Set<Meal>>();
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see classes.food.IMenu#addMeal(java.lang.String, classes.food.Meal)
	 */
	@Override
	public void addMeal(String category, Meal mealToAdd) throws MenuException {
		if ((category == null) || (category.equals("")) || (category.matches(".*\\d.*")) || (mealToAdd == null)) {
			throw new MenuException("Dannite sa nevalidni");
		} else {
			if (!(menuList.containsKey(category))) {
				menuList.put(category, new HashSet<Meal>());
			}

			Set<Meal> currentMenu = menuList.get(category);
			currentMenu.add(mealToAdd);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classes.food.IMenu#getMealsFromCategory(java.lang.String)
	 */
	@Override
	public Set<Meal> getMealsFromCategory(String category) throws MenuException {
		if ((category == null) || (category.equals("")) || (category.matches(".*\\d.*"))) {
			throw new MenuException("kva e tazi kategoriq be men");
		} else {
			if (menuList.containsKey(category)) {
				return menuList.get(category);
			} else {
				throw new MenuException("nqma takava kategoriq");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classes.food.IMenu#sortBy(classes.food.Creteria)
	 */
	@Override
	public Set<Meal> sortBy(Creteria criteria) {
		Set<Meal> result = new TreeSet<Meal>(getComparator(criteria));
		for (String key : menuList.keySet()) {
			result.addAll(menuList.get(key));
		}
		return result;

	}

	// in case we want to add other criteria
	private Comparator<Meal> getComparator(Creteria criteria) {
		switch (criteria) {
		case PRICE:
			return (o1, o2) -> (int) (o1.getPrice() - o2.getPrice());

		default:
			return (o1, o2) -> (int) (o1.getPrice() - o2.getPrice());
		}

	}

	@Override
	public String toString() {
		return "Menu [menuList=" + menuList + "]";
	}

}
