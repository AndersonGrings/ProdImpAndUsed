package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.ImportedProduct;
import entites.Product;
import entites.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (type == 'c') {
				list.add(new Product(name, price));
			} else if (type == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			} else {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}

		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		sc.close();
	}

}
