package user.users;

import java.util.HashSet;
import java.util.Set;

import cartAndOrder.Cart;
import cartAndOrder.ICart;
import cartAndOrder.OrderException;

public class User {
	private Set<Cart.Order> allOrdersHistory;
	private String userName;
	private String password;
	private String email;
	private ICart cart;

	public User(String userName, String password, String email) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.allOrdersHistory = new HashSet<Cart.Order>();
		this.cart = new Cart();
	}
	//
	// private String hashPass(String password2) {
	//
	// }

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

	public boolean checkPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public ICart getCart() {
		return cart;

	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
