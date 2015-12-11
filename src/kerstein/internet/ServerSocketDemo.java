package kerstein.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) throws IOException {
		//a server accepts connections
				//so create server socket
				//needs port # - has to be the same as client port
				ServerSocket serverSocket= new ServerSocket(52746);
				Socket socket=serverSocket.accept();  //waits for s/o to connect to it
				//once it connects socket.accept() returns socket object
				
				InputStream in = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				
				//serve read one line of message and write response
				
				String response=reader.readLine();
				
				System.out.println("Response:");
				System.out.println(response);
				
				//client sending message and reading one line of response
				PrintWriter out = new PrintWriter(socket.getOutputStream());

				out.write("How are you doing?\n");

				out.flush();
				serverSocket.close();
	}
	
	

}


