package com.niit.collaborationpjtbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.collaborationpjtbackend.model.blogcomments;
import com.niit.collaborationpjtbackend.model.blogmaster;
import com.niit.collaborationpjtbackend.model.eventmaster;
import com.niit.collaborationpjtbackend.model.forumcomments;
import com.niit.collaborationpjtbackend.model.forummaster;
import com.niit.collaborationpjtbackend.model.friends;
import com.niit.collaborationpjtbackend.model.jobcarrier;
import com.niit.collaborationpjtbackend.model.register;
import com.niit.collaborationpjtbackend.model.role;



@Configuration
@ComponentScan("com.niit.collaborationpjtbackend")
@EnableTransactionManagement
public class Applicationconfig {
	
	@Bean(name="dataSource")
	public DataSource getOracleDataSource()
	{
		System.out.println("Data source");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl11g");
		
		dataSource.setUsername("anju");
		dataSource.setPassword("anju");
		return dataSource;
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(blogmaster.class);
	sessionBuilder.addAnnotatedClass(blogcomments.class);
	sessionBuilder.addAnnotatedClass(register.class);
	sessionBuilder.addAnnotatedClass(role.class);
	sessionBuilder.addAnnotatedClass(forummaster.class);
	sessionBuilder.addAnnotatedClass(forumcomments.class);
	sessionBuilder.addAnnotatedClass(eventmaster.class);
	sessionBuilder.addAnnotatedClass(friends.class);
	sessionBuilder.addAnnotatedClass(jobcarrier.class);
	return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transcationManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
		
	}

}
