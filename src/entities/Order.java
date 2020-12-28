package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	public Order () {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	List<OrderItem> list = new ArrayList<>();

	public void addItem (int quantity, double price, Product product) {
		list.add(new OrderItem(quantity, price, product));
	}
	
	public void removeItem (int quantity, double price, Product product) {
		list.remove(new OrderItem(quantity, price, product));
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem c : list) {
			sum += c.subTotal();
		}
		return sum;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n" + "Order moment: " + sdf2.format(moment) + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append("Client: " + client.getName() + "(" + sdf1.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Order items: " + "\n");
		for (OrderItem c : list) {
			sb.append(c.getProduct().getName() + ", $" + c.getPrice() + ", Quantity: " + c.getQuantity() + " Subtotal: " + c.subTotal() + "\n");
		}
		return sb.toString();
	}
}
