package Trabalho;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	@SuppressWarnings("deprecation")
	public static Session getSession(){
		
		if (sf==null) {
			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
			cfg.setProperty("hibernate.connection.username", "sa");
			cfg.setProperty("hibernate.connection.password", "");
			cfg.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:./banco/dados");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
			cfg.setProperty("hibernate.current_session_context_class", "thread");
			cfg.setProperty("hibernate.show_sql", "false");
			cfg.addClass(Empresa.class);
			cfg.addClass(Funcionario.class);
			sf = cfg.buildSessionFactory();
		}
		return sf.getCurrentSession();
	}
	public static void begin(){
		getSession().beginTransaction();
	} 
	public static void commit(){
		getSession().getTransaction().commit();
	} 
	public static void rollback(){
		getSession().getTransaction().rollback();
	}
	public static void close(){
		getSession().close();
	}

}
