import database.List;
import database.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {

	static List list = List.getInstance();
	static Scanner scanner = new Scanner(System.in);

	private static void processOperation(String operation) {
		if(operation.isEmpty() || operation.isBlank()) return;
		switch (operation) {
			case "1":
				System.out.println("Enter product properties:");
				System.out.print("Name: ");
				String name = scanner.nextLine();
				System.out.print("Price: ");
				int price = scanner.nextInt();
				System.out.print("Quantity: ");
				int quantity = scanner.nextInt();
				list.add(name, price, quantity);
				System.out.println();
				scanner.nextLine();
				break;
			case "2":
				list.show();
				break;
			case "3":
				System.out.print("Enter product ID to be deleted: ");
				int id = scanner.nextInt();
				list.delete(id);
				System.out.println();
				scanner.nextLine();
				break;
			case "4":
				System.out.print("Enter product ID to be updated: ");
				int updatingID = scanner.nextInt();
				scanner.nextLine();
				System.out.println();
				System.out.println("Enter updating properties:");
				System.out.print("Name: ");
				String updatingName = scanner.nextLine();
				System.out.print("Price: ");
				int updatingPrice = scanner.nextInt();
				System.out.print("Quantity: ");
				int updatingQuantity = scanner.nextInt();
				list.update(updatingID, updatingName, updatingPrice, updatingQuantity);
				System.out.println();
				scanner.nextLine();
				break;
			case "5":
				System.out.print("Enter keywords: ");
				String keywords = scanner.nextLine();
				ArrayList<Product> response = list.search(keywords);
				if(response.size() == 0) System.out.println("[ERROR]: Not Found\n");
				else list.display(response);
				break;
			default:
				System.out.println("[ERROR]: Unknown Operation");
				System.out.println();
		}
	}

	public static void main(String[] args){
		while(true) {

			list.displayOperations();
			System.out.print("Enter operation: ");
			String operation = scanner.nextLine();
			try {
				processOperation(operation);
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("[ERROR]: Invalid Value");
				System.out.println();
			}
		}
	}
}
