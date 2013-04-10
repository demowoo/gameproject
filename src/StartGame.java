import game.protocol.PlayerProtocol;

public class StartGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		if(PlayerProtocol.LOGOUT.getValue() == 1)
			System.out.println(2);
	}

}
