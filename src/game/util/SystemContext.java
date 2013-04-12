package game.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SystemContext {
	
	private final static ApplicationContext CTX = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");

	private SystemContext(){}
	
	/**
	 * 初始化spring上下文环境
	 */
	public static void init(){
		//调用此空方法在程序启动时初始化spring上下文，避免第一次调用时再初始化
	}
	
	public static ApplicationContext getContext(){
		return CTX;
	}
	
	public static Object getBean(String beanId){
		return CTX.getBean(beanId);
	}
}
