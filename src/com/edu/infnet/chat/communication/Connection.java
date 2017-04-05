package com.edu.infnet.chat.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import com.edu.infnet.chat.protocol.Protocol;
import com.edu.infnet.logging.Log;

public class Connection extends Thread {

		private static Logger LOGGER = Log.getInstance().getLogger("Client");
		private Socket socket;
		private Protocol protocol;
	
		public Connection(Socket socket, Protocol protocol) {
			this.socket = socket;
			this.protocol = protocol;
		}
		
		public void run() {
			try {
				PrintWriter writer = getWriter();
				BufferedReader reader = getReader();
				
				String request = null;
				while ((request = reader.readLine()) != null) {
					System.out.println("> " + request);
					String response = this.protocol.response(request);
					System.out.println("> " + response);
					writer.println(response);
				}	
			} catch(Exception e){
				LOGGER.throwing("Client", "run", e);
			} finally {
				shutdown();
			}
		}
		
		private BufferedReader getReader() throws IOException {
			LOGGER.info("Get connection Reader.");
			return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		}

		private PrintWriter getWriter() throws IOException {
			LOGGER.info("Get connection Writer.");
			return new PrintWriter(this.socket.getOutputStream(), true);
		}
		
		public void shutdown() {
			try {
				if (this.socket != null) {
					this.socket.close();
				}
				LOGGER.info("A connection client was stopped.");
			} catch(IOException e) {
				LOGGER.throwing("Client", "shutdown", e);
			}
		}
}
