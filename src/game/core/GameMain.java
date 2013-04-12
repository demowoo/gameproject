package game.core;

import game.util.GamePathUtil;
import game.util.PropertiesUtil;
import game.util.SystemContext;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
public class GameMain{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private final File logbackFile = GamePathUtil.getInstance().getConfigChildsPath("logback.xml");
	private final File globalConfigFile = GamePathUtil.getInstance().getGlobalConfig(); 
	
	public static void start(){
		GameMain game = new GameMain();
		game.initGame();
	}
	
	/**
	 *权限设成private，使之不可实例化
	 */
	private GameMain(){
		log.info("开始启动游戏,Staring......");
	}
	
	/**
	 * 初始化游戏
	 */
	private void initGame(){
		//设置日志文件配置路径,影响到所有的日志设置,所以要放在最前面初始化
		if(logbackFile.exists())
			setLogbackConfigPath(logbackFile);
		else
			 System.out.println("加载logback配置文件失败!!!\n文件不存在:"+logbackFile);
		
		PropertiesUtil prop = new PropertiesUtil();
		Map<String, String> propmap = prop.getMapFromProp(globalConfigFile);
		
		//初始化spring上下文环境
		log.info("***开始初始化spring上下文...***");
		SystemContext.init();
	}
	
	/**
	 * 设置logback日志的配置文件路径
	 * @param path
	 */
	private void setLogbackConfigPath(File path){
		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure(path);
            log.info("成功加载logback配置文件: {}", path);
        } catch (JoranException e) {
            log.error("加载logback配置文件失败: {}", path);
            log.error(e.getMessage(), e);
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
	}
	
}
