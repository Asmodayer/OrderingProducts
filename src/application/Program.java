package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
		
		System.out.println("Enter client data: \n Name:");
		String clientName = sc.next();
		sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birht date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
	
		Client client = new Client(clientName, email, birthDate);
		
		System.out.println("Enter order data: \n Status: ");
		String orderStatus = sc.nextLine();
		
		Date d = new Date();
		Order order = new Order(d , OrderStatus.valueOf(orderStatus), client);
		
		System.out.println("How many itens to this order? ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			System.out.println("Enter #" +i + " iten data:");
			System.out.println("Product name: ");
			String name = sc.next();
			System.out.println("Product price: ");
			double price = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(name, price);
			order.addItem(quantity, price, product);
		}
		
		System.out.print(order);
		System.out.println("Total Price: " + order.total());
		
		sc.close();
	}

}
