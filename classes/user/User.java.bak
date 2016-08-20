package classes.user;

import classes.cart.Cart;
import interfaces.ICart;

public class User {
	private String userName;
	private String password;
	private String email;
	private ICart cart;

	public User(String userName, String password, String email) {
		this.userName= userName;
		this.email = email;
		this.password = password;
		this.cart = new Cart();
		
		
		
	}
//
//	private String hashPass(String password2) {
//		
//	}

	public String getUserName() {
		return userName;
	}

	public boolean checkPassword(String password) {
		if(this.password.equals(password)){
			return true;
		}
		return false;
	}

	public ICart getCart() {
		return cart;
		
	}

}
