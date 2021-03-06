package utility;

//import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static ServiceRegistry serviceRegistry;

	static {
		try {

			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(

					configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException he) {
			throw new ExceptionInInitializerError(he);
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;

	}

}
