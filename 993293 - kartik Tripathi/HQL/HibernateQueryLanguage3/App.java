package com;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.service.*;

public class App {

	public static void main(String[] args) {


		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		//Native Query
		
//		SQLQuery query = session.createSQLQuery("select * from student where marks > 60");
//		
//		
//		query.addEntity(Student.class); //This is the solution (for below mentioned hash values problem)
//		List<Student> students = query.list();  // This will return hash values(or object location maybe)
//		
//		for(Object o : students ) {
//			System.out.println(o);
//		}
//		
		
		//This is the way to fetch only the certain column not entire row(like name, marks) , In this case we cannot use addEntity() as we are not fetching the entire rows
		
		
		SQLQuery query = session.createSQLQuery("select name,marks from student where marks > 60");
		
		 //The solution is to use map by makinh the colummns as key value pairs (use setResultTransformer())
		
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);  //it will convert our output into MAP format
		
	
		
		
		List students = query.list();  
		
		for(Object o : students) {
			Map m = (Map)o;
			System.out.println(m.get("name") + ":" + m.get("marks"));
		}
		
		
	
		
		
		tx.commit();

	}

}
