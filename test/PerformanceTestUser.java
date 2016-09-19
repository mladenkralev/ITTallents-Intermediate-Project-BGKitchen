import java.util.LinkedList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.TestCase;
import user.users.PasswordException;
import user.users.User;
import user.users.UserDAO;
import user.users.UserException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerformanceTestUser extends TestCase {
	private static final int NUMBER_OF_ITERATION = 100;
	private List<User> list = new LinkedList<User>();

	@Test
	public void B() throws PasswordException, UserException {
		long start = System.currentTimeMillis();

		for (int index = 0; index < NUMBER_OF_ITERATION; index++) {
			User testUser = new User("test" + index, "parolata", "test" + index);
			int id = new UserDAO().registerUser(testUser);
			list.add(testUser);
			assertNotSame(id, 0);
		}
		System.out.println("Time taken for INSERTION " + NUMBER_OF_ITERATION + " = "
				+ (System.currentTimeMillis() - start) + "ms");
	}

	@Test
	public void A() throws UserException {

		long start = System.currentTimeMillis();
		for (User user : list) {
			int id = new UserDAO().removeUser(user);
			assertNotSame(id, 0);
		}
		System.out.println("Time taken for DELETION " + NUMBER_OF_ITERATION + " = "
				+ (System.currentTimeMillis() - start) + "ms");
	}

}
