package game.protocol;
/**
 * 找不到协议号异常
 */
public class NoSuchProtocolException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2934772137338821040L;

	public NoSuchProtocolException() {
       super();
    }
	
	public NoSuchProtocolException(String message) {
       super(message);
    }
}
