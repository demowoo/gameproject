package test.spring;

import game.util.SystemContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person p = (Person)getSpringBean("person");
//		p.test();
//		SystemContext.init();
		System.out.println("testtttt%%%%%%%%%%");
		DataSource ds = (DataSource)SystemContext.getBean("bonecp");
		Connection conn;
		try {
			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user"); // do something with the connection.
			while(rs.next()){
				System.out.println(rs.getString(1)); // should print out "1"'
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public static Object getSpringBean(String bean){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
//		return ctx.getBean(bean);
//		
//	}
	
	
}
