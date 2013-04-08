package game.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {
	
	final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);  
	
	public Map<String, String> getMapFromProp(String propPath){
		
		Map<String, String> propMap = new HashMap<String, String>();
		
		try {
			Properties prop = new Properties();//属性集合对象 
			FileInputStream fis = new FileInputStream(propPath);//属性文件输入流 
			prop.load(fis);//将属性文件流装载到Properties对象中
			logger.info("载入properties文件：{}", propPath);
			Set<String> propNames = prop.stringPropertyNames();
			for (String name : propNames) {
				propMap.put(name, prop.getProperty(name));
				logger.info("读取键值对: {}, {}", name, prop.getProperty(name));
			}
			fis.close();//关闭流 
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return propMap;
	}
	
}
