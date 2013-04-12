package game.protocol;

import java.util.HashMap;

public enum PlayerProtocol{
	/**
	 * 登陆
	 */
	LOGIN(1),
	/**
	 * 登出
	 */
	LOGOUT(2);

	private static final HashMap<Integer, PlayerProtocol> lookup = new HashMap<Integer, PlayerProtocol>();

	static {
		for (PlayerProtocol pro : values()) {
			lookup.put(pro.getInt(), pro);
		}
	}
	
	private int protocolNum;

	private PlayerProtocol(int i) {
		this.protocolNum = i;
	}

	private int getInt() {
		return this.protocolNum;
	}
	
	public static PlayerProtocol getEnum(int protoNum) throws  NoSuchProtocolException{
		PlayerProtocol procotol =  lookup.get(protoNum);
		if(procotol == null)
			throw new NoSuchProtocolException("找不到协议号："+protoNum);
		else
			return procotol;
	}

	@Override
	public String toString() {
		return String.valueOf("("+this.getClass().getName()+"类中)"+this.name()+"的值为:"+this.protocolNum);
	}
}
