import java.sql.Connection;

import org.junit.Test;

import controller.DBConnection;
import junit.framework.TestCase;
import user.users.PasswordException;
import user.users.User;
import user.users.UserDAO;

public class UserTest extends TestCase {
	
	
	@Test
	private void testUser() throws PasswordException {
		User testUser = new User("Gosho", "parolata", "asd");
		int id = new UserDAO().registerUser(testUser);
		
		//assertNotEquals(id, 0);
	}
}
