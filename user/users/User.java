package user.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import cartAndOrder.Cart;
import cartAndOrder.ICart;
import cartAndOrder.OrderException;

public class User {
	private Set<Cart.Order> allOrdersHistory = new HashSet<Cart.Order>();
	private String userName;
	private String password;
	private String email;
	private ICart cart;

	public User(String userName, String password, String email) throws PasswordException {
		this.userName = userName;
		this.email = email;
		this.password = hashPass(password);
		this.cart = new Cart();

	}

	private String hashPass(String password) throws PasswordException {

		MessageDigest md=null;;
		try {
			md = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {
			throw new PasswordException("Problem with the password",e);
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();

	}

	public void order() throws UserException {
		try {
			Cart.Order order = this.cart.giveMeOrder();
			allOrdersHistory.add(order);
			this.cart.removeAll();
		} catch (OrderException e) {
			throw new UserException("The order is unacceptable");
		}
	}

	public String giveMeAllOrders() {
		StringBuffer stringBuffer = new StringBuffer();
		for (Cart.Order order : allOrdersHistory) {
			stringBuffer.append(order);
			stringBuffer.append("\n");
		}

		return stringBuffer.toString();
	}

	public Cart.Order giveMeOrder(int id) {
		for (Cart.Order order : allOrdersHistory) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public Object logOut() {
		return null;
	}

	public boolean checkPassword(String password) throws PasswordException {
		if (this.password.equals(hashPass(password))) {
			return true;
		}
		return false;
	}

	public ICart getCart() {
		return cart;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
