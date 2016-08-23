package classes.user;

import java.util.HashMap;
import java.util.Map;
import classes.food.*;
import exceptions.LogInException;
import exceptions.RegistrationException;
import exceptions.SiteException;
import interfaces.IMenu;

public class Site {
	private static final int MINIMUM_LENGTH_FOR_PASSWORD = 6;
	private static final String PREFIX_FOR_EMAIL_VALIDATION = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	private String name;
	private Map<String, User> users = new HashMap<String, User>();
	private IMenu menu;
	private PromotionMenu promoMenu;

	public Site(String name, IMenu menu) throws SiteException {
		if(menu!=null){
			this.menu=menu;
		}
		if(name!=null && name.trim().length()>0){
		if ((name == null) || (name.trim().equals(""))) {
			throw new SiteException("The name for the site is invalid");
		}
		this.name = name;
		}else{
			throw new SiteException("Invalid name was given for this site");
		}
	}
	
	

	public void generateDailyMenu() throws SiteException{
		this.promoMenu = new PromotionMenu(this.menu);
	}

	public void registerUser(String userName, String password, String email) throws RegistrationException {
		if (userName != null && userName.trim().length() > 0) {
			if (isUserNameFree(userName)) {
				if (password != null && password.trim().length() >= MINIMUM_LENGTH_FOR_PASSWORD) {
					if (email.matches(PREFIX_FOR_EMAIL_VALIDATION)) {
						users.put(userName, new User(userName, password, email));
					} else {
						throw new RegistrationException("Invalid email was entered");
					}
				} else {
					throw new RegistrationException("Your password must be at least 6 symbols!");
				}
			} else {
				throw new RegistrationException("This username is used.");
			}
		} else {
			throw new RegistrationException("Please enter username.");
		}
	}

	public User logInUser(String userName, String password) throws LogInException {
		if (users.containsKey(userName)) {
			User login = users.get(userName);
			if (login.checkPassword(password)) {
				return login;
			} else {
				throw new LogInException("Wrong password or username");
			}
		} else {
			throw new LogInException("Wrong password or username");
		}

	}
	

	private boolean isUserNameFree(String userName) {
		if (users.containsKey(userName)) {
			return false;
		}

		return true;
	}
	

	public PromotionMenu getPromoMenu() {
		return promoMenu;
	}



	public IMenu getMenu() {
		return menu;
	}


	public String getName() {
		return name;
	}

}
