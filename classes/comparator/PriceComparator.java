package classes.comparator;

import java.util.Comparator;
import classes.food.Meal;
public class PriceComparator implements Comparator<Meal>{

	@Override
	public int compare(Meal o1, Meal o2) {
		return (int)(o1.getPrice()-o2.getPrice());
	}
}
