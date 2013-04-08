package game.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SystemContext {
	
	final static Logger log = LoggerFactory.getLogger(SystemContext.class);
	
	private static ApplicationContext CTX = null;

	private SystemContext(){}
	
	/**
	 * 初始化spring上下文环境
	 */
	public static void init(){
		log.info("***开始初始化spring上下文...***");
		if(CTX == null)
			CTX = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
		else
			log.info("本来已经初始化，请勿重复调用初始化方法!");
	}
	
	public static ApplicationContext getContext(){
		return CTX;
	}
	
	public static Object getBean(String beanId){
		return CTX.getBean(beanId);
	}
}
