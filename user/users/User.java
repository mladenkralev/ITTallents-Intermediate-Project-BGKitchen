package user.users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cart.Cart;
import cart.ICart;
import order.Order;
import order.OrderException;

public class User {
	private Set<Order> allOrdersHistory;
	private String userName;
	private String password;
	private String email;
	private ICart cart;

	public User(String userName, String password, String email) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.allOrdersHistory = new HashSet<Order>();
		this.cart = new Cart();
	}
	//
	// private String hashPass(String password2) {
	//
	// }

	public void order() throws UserException {
		try {
			allOrdersHistory.add(new Order(this.cart));
			this.cart.removeAll();
		} catch (OrderException e) {
			throw new UserException("The order is unacceptable");
		}
	}

	public String giveMeAllOrders() {
		StringBuffer stringBuffer = new StringBuffer();
		for (Order order : allOrdersHistory) {
			stringBuffer.append(order);
			stringBuffer.append("\n");
		}

		return stringBuffer.toString();
	}

	public Order giveMeOrder(int id) {
		for (Order order : allOrdersHistory) {
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
