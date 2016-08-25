package order;

import java.time.LocalDateTime;
import cart.ICart;

public class Order implements IOrder {
	private ICart cart;
	private LocalDateTime dateAndHours;
	private Status status;

	public Order(ICart cart) throws OrderException {
		if (cart == null) {
			throw new OrderException("Cant order this, your cart doesnt exist");
		}

		if (cart.getBallance() <= 0) {
			throw new OrderException("Your ballance is invalid");
		}

		this.cart = cart;
		this.dateAndHours = LocalDateTime.now();
		this.status = status.ORDERED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see order.IOrder#readyForTravelling()
	 */
	@Override
	public void readyForTravelling() {
		this.status = Status.ON_OTS_WAY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see order.IOrder#delivered()
	 */
	@Override
	public void delivered() {
		this.status = Status.DELIVERED;
	}

	@Override
	public String toString() {
		return "Order [cart=" + cart + ", dateAndHours= " + dateAndHours + ", status=" + status + "]";
	}
}
