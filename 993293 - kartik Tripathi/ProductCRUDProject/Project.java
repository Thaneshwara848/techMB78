



import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class Operations {

	public static void insert() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Product p = new Product();
		Scanner sc = new Scanner(System.in);
		System.out.println("ID :");
		int id = sc.nextInt();
		System.out.println("NAME :");
		String name = sc.next();
		System.out.println("Price :");
		int price = sc.nextInt();
		System.out.println("Descripton:");
		String description = sc.next();
		System.out.println("Location:");
		String Location = sc.next();
		p.setPid(id);
		p.setName(name);
		p.setPrice(price);
		p.setDesc(description);
		p.setLocation(Location);
		session.save(p);
		tx.commit();
		System.out.println("Data inserted Succesfully...!");
	}

	public static void delete() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Product p = new Product();
		Scanner sc = new Scanner(System.in);
		System.out.println("ID :");
		int id = sc.nextInt();

		p.setPid(id);
		session.save(p);
		session.delete(p);
		tx.commit();
		System.out.println("Data Deleted Succesfully...!");
	}

	public static void read() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);

		List<Product> prod =  session.createQuery("from Product").list();
		Iterator<Product> i = prod.iterator();
		while (i.hasNext()) {
			Product pp = (Product) i.next();
			System.out.println("Product ID= " + pp.getPid());
			System.out.println("Product Name : " + pp.getName());
			System.out.println("Product price " + pp.getPrice());
			System.out.println("Product Description: " + pp.getDesc());
			System.out.println("==============================");
		}
		tx.commit();
		System.out.println("Data Deleted Succesfully...!");
	}

	public static void update() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Product p = new Product();
		Scanner sc = new Scanner(System.in);
		System.out.println("ID :");
		int id = sc.nextInt();
		System.out.println("Price :");
		int price = sc.nextInt();

		p.setPid(id);
		p.setPrice(price);
	
		session.update(p);
		tx.commit();
		System.out.println("Data Updated Succesfully...!");

	}
}

public class Project {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("1 ) Insert ");

			System.out.println(" 2 ) DELETE ");

			System.out.println(" 3 ) READ ");

			System.out.println("4 ) UDPATE ");
			System.out.println("Enter the choice : ");
			ch = sc.nextInt();
			if (ch == 1) {
				Operations.insert();
			}
			if (ch == 2) {
				Operations.delete();
			}
			if (ch == 3) {
				Operations.read();
			}
			if (ch == 4) {
				Operations.update();
			}
		} while (ch <= 4);
	}
}