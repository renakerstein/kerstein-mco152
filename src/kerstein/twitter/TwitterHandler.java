package kerstein.twitter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class TwitterHandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {

		// content type- how the server tells the web browser what it is
		// downloading- img...
		response.setContentType("text/html;charset=utf-8");

		// tells web browser what kind of message this is
		response.setStatus(HttpServletResponse.SC_OK);

		// have to tell request that message has been handled
		baseRequest.setHandled(true);

		// print out response in HTML - cuz thats what the web browser expects
		response.getWriter().println("<h1> Hello World</h1>");

		// this code will show up in web browser now - just type in
		// localhost:8080 in the web browser
	}
}