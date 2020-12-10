package database;

import java.util.ArrayList;

public class List {

	private int idCounter = 1;

	private static  List list = null;

	public ArrayList<Product> products;

	private List() {
		products = new ArrayList<>();
	}

	public static List getInstance() {
		if(list == null) list = new List();
		return list;
	}

	public void displayOperations() {
		System.out.println("Operations:");
		System.out.println("1. Add products");
		System.out.println("2. Display all products");
		System.out.println("3. Delete a product");
		System.out.println("4. Update a product");
		System.out.println("5. Search for product name");
		System.out.println("'ID + Enter' to trigger an operation");
	}

	public void add(String name, int price, int quantity) {
		products.add(new Product(
			idCounter++,
			name, price, quantity
		));
	}

	public int findIndex(int id) {
		int index = 0;
		for(Product product: products) {
			if(product.id == id) return index;
			index++;
		}
		System.out.println("[ERROR]: Not Found");
		return -1;
	}

	public boolean delete(int id) {
		int index = findIndex(id);
		if(index == -1) return false;
		products.remove(index);
		return true;
	}

	public boolean update(int id, String name, int price, int quantity) {
		int index = findIndex(id);
		if(index == -1) return false;
		products.set(index, new Product(id, name, price, quantity));
		return true;
	}

	public ArrayList<Product> search(String name) {
		ArrayList<Product> response = new ArrayList<>();
		for(Product product: products) {
			int status = product.name.indexOf(name);
			if(status != -1) response.add(product);
		}
		return response;
	}

	public void show() {
		display(products);
	}

	public void display(ArrayList<Product> products) {

		String[] menus = {"ID", "Name", "Price", "Quantity"};

		System.out.println();
		for(String menu:menus) {
			System.out.print(menu + "\t\t");
		}

		System.out.println();

		for(Product product: products) {
			System.out.print(product.id + "\t\t");
			System.out.print(product.name + "\t\t");
			System.out.print(product.price + "\t\t");
			System.out.print(product.quantity + "\n");
		}

		System.out.println();
	}
}
