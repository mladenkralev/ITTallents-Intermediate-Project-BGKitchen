package food.meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.DBConnection;
import user.users.UserException;

public class MealDAO {

	private static final String ADD_MEA_IN_DB = "INSERT INTO meals VALUES(NULL,?,?)";

	public int addMeal(Meal meal) throws MealException {
		Connection connection = DBConnection.getInstance().getConnection();
		int id = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(ADD_MEA_IN_DB, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, meal.getName());
			ps.setBoolean(2, meal.isVegan());
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
}
