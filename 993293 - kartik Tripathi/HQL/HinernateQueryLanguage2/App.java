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

//		Query q =session.createQuery("select rollno,name,marks from Student where rollno = 7");

//		Object[] student = (Object[])q.uniqueResult();

//		for(Object s:student) {
//			System.out.println(s);
//		}

		// OR

//		System.out.println(student[0] +":"+student[1]+":"+student[2]);

		// TO get Whole TABLE as LIST using select statement

//		Query q = session.createQuery("select rollno,name,marks from Student");
//		List<Object[]> students = (List<Object[]>) q.list();
//
//		for (Object[] student : students) {
//
//			System.out.println(student[0] + ":" + student[1] + ":" + student[2]);
//
//		}
		
		//to fetch only those rows where marks greater than > 60 . Also giving alias to avoid ambiguty for database for which database we are taking values

		
//		Query q = session.createQuery("select rollno,name,marks from Student where marks>60");
//		List<Object[]> students = (List<Object[]>) q.list();
//
//		for (Object[] student : students) {
//
//			System.out.println(student[0] + ":" + student[1] + ":" + student[2]);
//
//		}
		
		
		//to fetch sum of only one column(i.e marks)
		
//		
//		Query q = session.createQuery("select sum(marks) from Student where marks>60");
//		Long totalMarks = (Long) q.uniqueResult();
//
//	
//
//			System.out.println("Total marks of all Students :" +totalMarks);

		//To fetch data using dynamic value like we use to give in case of prepared statement
		
		int a=60;
		
		Query q = session.createQuery("select sum(marks) from Student s where s.marks > :a ");
		q.setParameter("a", a);
		Long totalMarks = (Long) q.uniqueResult();

	

			System.out.println("Total marks of all Students whose marks are grater than 60 :" +totalMarks);
			
			
		tx.commit();

	}

}
