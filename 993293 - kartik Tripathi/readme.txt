->Cookies servelet folder contains implementation of Cookies using servelet.

->HQL

		->HibernateQueryLanguage - contains basic Hql query (i.e Fetching and displaying data)
		->HibernateQueryLanguage2 - contains the program for fetching only particulary columns in a record 
									using HQL query.
		->HibernateQueryLanguage3 - Contains implmentaion of native Query using hibernate.

->Mapping
		->OneToOne - contains hibernate implementation for mapping one to one relationship
			between student and laptop class (i.e one student can have one laptop) which is then stored 
			in database.
		
		->OneToMany&ManyToOne - contains hibernate implementation for mapping one-to-many and many-to-one relationship
			between student and laptop class (i.e one student can have many laptops and many laptopns can be owned by one student) 
			which is then stored in database.
			
		->ManyToMany - contains hibernate implementation for mapping many-to-many relationship
			between student and laptop class (i.e any student can have multiple laptops and vice-versa) which is then stored 
			in database.

->ProductCRUDProject- contains CRUD operation implementation using hibernate in a user friendly manner.
->XMLMapping - contains Student class which is mapped using Student.hbm.xml file to the database instead of using Annotations.
