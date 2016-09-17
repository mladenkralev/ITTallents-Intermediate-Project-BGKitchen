import java.sql.Connection;

import org.junit.Test;

import controller.DBConnection;
import junit.framework.TestCase;
import user.users.PasswordException;
import user.users.User;
import user.users.UserDAO;
import user.users.UserException;

public class UserTest extends TestCase {
	
	
	@Test
	public void testUser() throws PasswordException, UserException {
		User testUser = new User("AsdD", "parolata", "asd");
		int id = new UserDAO().registerUser(testUser);
		
		assertNotSame(id, 0);
		
		
		id = new UserDAO().removeUser(testUser);
		System.out.println(id);
		assertSame(id, 0);
	}
}
