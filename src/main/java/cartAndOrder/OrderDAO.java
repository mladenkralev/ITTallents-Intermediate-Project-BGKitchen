package cartAndOrder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import cartAndOrder.Cart.Order;
import controller.DBConnection;
import food.meal.Meal;
import user.users.User;

public class OrderDAO {
	private static final String GET_MEAL_ID = "SELECT idMeals FROM Meals WHERE name = ?";
	private static final String INSERT_MEALS_IN_ORDERS = "INSERT INTO orders_have_meals VALUES(?,?)";
	private static final String INSER_ORDERS_IN_DB = "INSERT INTO orders VALUES(NULL,?)";
	private static final String SET_ORDERS_MEALS = "INSERT INTO orders_have_meals VALUES (?,?)";
	private Connection connection = DBConnection.getConnection();
	
	public int createAnOrder(User user) throws OrderException{
		Order order = null;
		int oderID = 0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement orderPS = connection.prepareStatement(INSER_ORDERS_IN_DB, Statement.RETURN_GENERATED_KEYS);
			orderPS.setInt(1, user.getId());
			
			orderPS.executeUpdate();
			ResultSet orderRS = orderPS.getGeneratedKeys();
			orderRS.next();
			
			oderID = orderRS.getInt(1);
			
			Set<Meal> orderMeals = user.getCart().getMealsToOrder();
			
			for(Meal meal : orderMeals){
				PreparedStatement mealPS = connection.prepareStatement(GET_MEAL_ID);
				mealPS.setString(1, meal.getName());
				ResultSet mealRS = mealPS.executeQuery();
				mealRS.next();
				int mealID = mealRS.getInt("idMeals");
				
				PreparedStatement orderMealPS = connection.prepareStatement(SET_ORDERS_MEALS);
				orderMealPS.setInt(1, oderID);
				orderMealPS.setInt(2, mealID);
				orderMealPS.executeUpdate();
			}
			
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oderID;
		
	}

}
