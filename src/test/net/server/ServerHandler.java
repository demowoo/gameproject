package test.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends IoHandlerAdapter {

	private final static Logger LOGGER = LoggerFactory.getLogger(ServerHandler.class);

	@Override
	public void sessionOpened(IoSession session) {
		// Set reader idle time to 10 seconds.
		// sessionIdle(...) method will be invoked when no data is read
		// for 10 seconds.
//		session.getConfig().setIdleTime(IdleStatus.READER_IDLE, 10);
		LOGGER.debug("session open~~~~");
	}

	@Override
	public void sessionClosed(IoSession session) {
		// Print out total number of bytes read from the remote peer.
		LOGGER.debug("Total " + session.getReadBytes() + " byte(s)");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		// Close the connection if reader is idle.
//		if (status == IdleStatus.READER_IDLE) {
//			session.close(true);
//		}
		LOGGER.debug("server session idle");
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		IoBuffer buf = (IoBuffer) message;
		// Print out read buffer content.
		while (buf.hasRemaining()) {
			System.out.print((char) buf.get());
		}
		System.out.flush();
	}
}
