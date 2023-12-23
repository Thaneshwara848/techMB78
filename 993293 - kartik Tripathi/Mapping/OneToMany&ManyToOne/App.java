package com;



import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory ;

//import com.mysql.cj.xdevapi.SessionFactory;

public class App {

	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");
		
		
		Student s = new Student();
		s.setName("Navin");
		s.setRollno(1);
		s.setMarks(50);
		s.getLaptop().add(laptop);

//		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		
		
//		Error : Getting Null value for rollno when using mappedBy for mapping
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		org.hibernate.SessionFactory factory =  cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(laptop);
		session.save(s);
		
		tx.commit();
		
		System.out.println("Student and Laptop created and Added Successfully(OneToMany)");
		
	}
	

}
