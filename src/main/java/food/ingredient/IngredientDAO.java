package food.ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.DBConnection;
import food.meal.Meal;
import food.meal.MealException;

public class IngredientDAO {
	private static final String ADD_INGREDIENT_IN_DB = "INSERT INTO ingidients VALUES (NULL,?,?);";

	public int addIngredient(Ingredient ingredient) throws IngredentException {
		Connection connection = DBConnection.getInstance().getConnection();
		int id = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(ADD_INGREDIENT_IN_DB, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ingredient.getName());
			ps.setFloat(2, ingredient.getPrice());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			id = rs.getInt(1);
		} catch (SQLException e) {
			throw new IngredentException("Ingreadient cannot be registered now, please try again later.", e);
		}
		return id;
	}
}
