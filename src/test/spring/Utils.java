package test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Utils {

	public static Object getSpringBean(String bean){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
		return ctx.getBean(bean);
	}

}
