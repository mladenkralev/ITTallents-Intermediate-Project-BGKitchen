package food.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import controller.DBConnection;
import user.users.UserException;

public class MealDAO {

	private static final String ADD_MEA_IN_DB = "INSERT INTO meals VALUES(NULL,?,?, ?)";

	private static final String SELECT_ALL_MEALS = "SELECT * FROM meals";
	Connection connection = DBConnection.getInstance().getConnection();

	public int addMeal(Meal meal) throws MealException {

		int id = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(ADD_MEA_IN_DB, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, meal.getName());
			ps.setBoolean(2, meal.isVegan());
			ps.setNString(3, meal.getPath());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println(id);
			id = rs.getInt(1);
		} catch (SQLException e) {
			throw new MealException("Meal cannot be registered now, please try again later.", e);
		}
		return id;
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
