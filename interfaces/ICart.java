package interfaces;

import classes.food.Meal;
import exceptions.CartException;

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