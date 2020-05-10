package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Customer;

public class TestMain {

	public static void main(String[] args) {
		
		 final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .configure() // configures settings from hibernate.cfg.xml
	                .build();
	        try {
	            SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	            Session session = factory.openSession();
	            Transaction transaction = session.beginTransaction();
	             
	            Customer customer = new Customer("Alexander", "alexander@gmail.com");
	             
	            session.save(customer);
	             
	            transaction.commit();
	             
	            session.close();
	            factory.close();
	            
	        } catch (Exception ex) {
	            StandardServiceRegistryBuilder.destroy(registry);
	        }

	}

}
