package user.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.DBConnection;

public class UserDAO {
	private static final String DELETE_USER = "DELETE from users where idUsers = ?;";
	private static final String REGISTER_USER_TO_DB = "INSERT into users VALUES(NULL,?,?)";

	public int registerUser(User user) throws UserException{
		Connection connection = DBConnection.getInstance().getConnection();
		System.out.println(connection);
		int id = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(REGISTER_USER_TO_DB, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUserName());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println(id);
			id = rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be registered now, please try again later.", e);
		}
		return id;
		
			
	}
	
	public int removeUser(User user) throws UserException{
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_USER);
			ps.setInt(1, user.getId());
			return ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			throw new UserException("User cannot be deleted now, please try again later.", e);
		}
	}
}
