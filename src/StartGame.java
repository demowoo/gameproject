import game.core.GameMain;
import game.protocol.NoSuchProtocolException;
import game.protocol.PlayerProtocol;

public class StartGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameMain.start();
//		test();
	}
	
	public static void test() throws NullPointerException{
		PlayerProtocol p;
		try {
			p = PlayerProtocol.getEnum(3);
		} catch (NoSuchProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("ddd");
			e.printStackTrace();
		}
//		System.out.println(p.LOGOUT);
		String p1 = "";
		switch(p1){
		case "bb":
			System.out.println(p1);
			break;
		default:
			System.out.println(p1);
			break;
		}
	}

}
