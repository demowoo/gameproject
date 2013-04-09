package game.util;

import java.io.File;

public class GamePathUtil {
	
	//程序的classpath路径(.../bin)
	private final static File ROOT_PATH = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath());
	//游戏路径（bin的父级目录）
	private final static File GLOBAL_PATH = ROOT_PATH.getParentFile();
	//程序的配置路径
	private final static File CONFIG_PATH = new File(ROOT_PATH, "config");
	
	private final static GamePathUtil instance = new GamePathUtil();
	
	private GamePathUtil(){}
	
	public static GamePathUtil getInstance(){
		return instance;
	}
	
	public String getRootPath(){
		return ROOT_PATH.getPath();
	}
	
	public File getGlobalConfig(){
		return new File(GLOBAL_PATH, "globalconfig.properties");
	}
	
	public File getConfigChildsPath(String child){
		return generateFile(CONFIG_PATH, child);
	}
	
	public File getConfigChildsPath(String child1, String child2){
		return generateFile(CONFIG_PATH, child1, child2);
	}
	
	public File getConfigChildsPath(String[] childs){
		return generateFile(CONFIG_PATH, childs);
	}
	
	private File generateFile(File parent, String child){
		if(parent == null)
			return null;
		else
			return new File(parent,child);
	}
	
	private File generateFile(File parent, String child1, String child2){
		String[] strArr = {child1, child2};
		return generateFile(parent, strArr);
	}
	
	private File generateFile(File parent, String[] childs){
		if(parent == null)
			return null;
		else if(childs==null || childs.length<1)
			return new File(parent.toString());
		String tempChilds = "";
		for(int i=0; i<childs.length; i++){
			tempChilds += childs[i];
			if(i != childs.length)
				tempChilds += File.separator;
		}
		return new File(parent, tempChilds);
	}
}
