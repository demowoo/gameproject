package game.protocol;
public enum PlayerProtocol {
	/**
	 * 登陆
	 */
	LOGIN(1),
	/**
	 * 登出
	 */
	LOGOUT(2);
	
	private int protocolNum;
	
	private PlayerProtocol(int i){
		this.protocolNum = i;
	}
	
	public int getValue(){
		return this.protocolNum;
	}
	
	@Override
	public String toString() {
        return String.valueOf (this.protocolNum);
    }
}
