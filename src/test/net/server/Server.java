package test.net.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);

	private final static int PORT = 8099;
	
	public static void main(String[] args) {
		SocketAcceptor ioAcceptor = new NioSocketAcceptor();
		ioAcceptor.getFilterChain().addLast(
				"codec", new ProtocolCodecFilter( 
						new TextLineCodecFactory( Charset.forName( "UTF-8" ))
						));
//		ioAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		ioAcceptor.setHandler(new ServerHandler());
		try {
			ioAcceptor.bind(new InetSocketAddress(PORT));
			LOGGER.debug("server start...");
		} catch (IOException e) {
			LOGGER.debug("bind error", e);
		}
		
	}

}
