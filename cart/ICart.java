package cart;

import food.meal.Meal;

public interface ICart {

	void addMeal(Meal meal) throws CartException;

	void removeMeal(Meal meal) throws CartException;

	void removeAll();
	//	
	//	public void addIngridiant(Ingidiant ingridiant){
	//		
	//	}

	float getBallance();

}