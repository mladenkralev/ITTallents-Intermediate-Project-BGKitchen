package food.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import controller.DBConnection;
import food.ingredient.IngredentException;
import food.ingredient.Ingredient;
import food.ingredient.IngredientDAO;
import user.users.UserException;

public class MealDAO {
	private static final String GET_INGREDIENT_ID = "SELECT idIngidient FROM igredients WHERE name = ?";
	private static final String ADD_MEA_IN_DB = "INSERT INTO meals VALUES(NULL,?,?, ?)";
	private static final String SELECT_ALL_MEALS = "SELECT * FROM meals";
	private static final String SET_MEALS_INGREDIENT = "INSERT INTO meals_have_ingidients VALUES(?,?)";
	Connection connection = DBConnection.getInstance().getConnection();

	public int addMeal(Meal meal) throws MealException {

		int mealID = 0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(ADD_MEA_IN_DB, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, meal.getName());
			ps.setBoolean(2, meal.isVegan());
			ps.setNString(3, meal.getPath());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			mealID = rs.getInt(1);
			
			for(Ingredient ingre : meal.getIngredients()){
				PreparedStatement mealPS = connection.prepareStatement(GET_INGREDIENT_ID);
				mealPS.setString(1, ingre.getName());
				ResultSet ingreRS = mealPS.executeQuery();
				ingreRS.next();
				int ingredientID = ingreRS.getInt("idIngidient");
				
				PreparedStatement orderMealPS = connection.prepareStatement(SET_MEALS_INGREDIENT);
				orderMealPS.setInt(1, mealID);
				orderMealPS.setInt(2, ingredientID);
				orderMealPS.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			throw new MealException("Meal cannot be registered now, please try again later.", e);
		}
		return mealID;
	}

	public TreeSet<Meal> getMeals() {
		TreeSet<Meal> result = new TreeSet<Meal>((o1, o2) -> o1.getName().hashCode() - o2.getName().hashCode());
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_MEALS);
			ResultSet mealsRS = ps.executeQuery();
			while (mealsRS.next()) {
				int id = mealsRS.getInt("idMeals");
				String name = mealsRS.getString("name");
				Boolean isVegan = mealsRS.getBoolean("is_vegan");
				String path = mealsRS.getString("meal_path");

				try {
					result.add(new Meal(name, isVegan, path));
				} catch (MealException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
}
