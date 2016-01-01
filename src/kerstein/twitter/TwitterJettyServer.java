package kerstein.twitter;

import org.eclipse.jetty.server.Server;

public class TwitterJettyServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080); // port number

		// singler server response - give it to a handler
		server.setHandler(new TwitterHandler());

		server.start();
		server.join();

	}

}
