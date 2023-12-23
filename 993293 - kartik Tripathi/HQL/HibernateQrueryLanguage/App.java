package com;

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
		
		
		
		Random r = new Random();
		
		
		
		//Query q = session.createQuery("from Student");  //fetch all students data
		//Query q = session.createQuery("from Student where marks > 50"); //it shows only the record where marks are grater than 50
		//List<Student> students = q.list();
		
//		for(Student s: students) {
//			System.out.println(s);
//		}
//		
		
//		Query q = session.createQuery("from Student where rollno=7");
//		Student student = (Student) q.uniqueResult();
		
		
		Query q = session.createQuery("select rollno,name,marks from Student where rollno=7"); //we will get Error
																//as it will return array of String instead of Object List of Strings;
		
		Student student = (Student) q.uniqueResult();
		System.out.println(student);
		
//		for(int i = 0;i<=50;i++) {
//			Student s = new Student();
//			s.setRollno(i);
//			s.setName("Name" + i);
//			s.setMarks(r.nextInt(100));
//			session.save(s);
//		}
		
		
		System.out.println("Student Data populated Successfully!");
		
		tx.commit();
		
		
	}

}
