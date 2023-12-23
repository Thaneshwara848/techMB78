package Prac.Student;

import java.util.List;
import java.util.Random;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Query;




import org.hibernate.service.*;

public class App {

	public static void main(String[] args) {
		
		
//		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
//		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		
		
		Student s = new Student();
		
		s.setName("Amal");
		s.setRollno(3);
		s.setMarks(75);
		
		session.save(s);
		
		
			
		System.out.println("Student Data populated Successfully!");
		
		tx.commit();
		
		
	}

}
