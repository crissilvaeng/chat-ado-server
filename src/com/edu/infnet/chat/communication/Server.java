package com.edu.infnet.chat.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import com.edu.infnet.logging.Log;

public class Server {
	
	private static Logger LOGGER = Log.getInstance().getLogger("Server");
	
	private int port;
	private ServerSocket server;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void start() throws IOException {
		LOGGER.info("Starting the server socket in port " + this.port + ".");
		this.server = new ServerSocket(this.port);
	}

	public Socket getClient() throws IOException {
		LOGGER.info("Retrieving the client connection.");
		return this.server.accept();
	}
	
	public void shutdown() throws IOException {
		LOGGER.info("Stoping the server socket.");
		if (this.server != null) {
			this.server.close();	
		}
	}
}
