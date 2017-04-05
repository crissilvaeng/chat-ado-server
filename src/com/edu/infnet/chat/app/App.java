package com.edu.infnet.chat.app;

import java.io.IOException;
import java.util.logging.Logger;

import com.edu.infnet.chat.communication.Connection;
import com.edu.infnet.chat.communication.Server;
import com.edu.infnet.chat.protocol.Protocol;
import com.edu.infnet.chat.storage.Storage;
import com.edu.infnet.logging.Log;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class App {

	private static Logger LOGGER = Log.getInstance().getLogger("App");
	
	public static void main(String[] args) {
		ArgumentParser parser = ArgumentParsers.newArgumentParser("server")
				.defaultHelp(true)
				.description("Provides a TCP/IP server for chat communication.");
		parser.addArgument("-p", "--port").dest("port")
				.help("Port to make the server available.");
		
		int port = 0;
		try {
			Namespace ns = parser.parseArgs(args);
			port = Integer.parseInt(ns.get("port"));			
		} catch (ArgumentParserException e) {
			parser.handleError(e);
			System.exit(1);
		} catch (NumberFormatException e) {
			LOGGER.throwing("App", "main", e);
			System.exit(1);
		}
				
		Server server = new Server(port);
		System.out.println("Listening in 0.0.0.0:" + port + " ...");
		
		try {
			server.start();
			Storage storage = new Storage();
			
			LOGGER.info("Searching clients...");
			while(true) {
				Connection connection = new Connection(server.getClient(), new Protocol(storage));
				connection.start();		
			}
		} catch (IOException e) {
			LOGGER.throwing("App", "main", e);
			System.exit(1);
		}
	}
}
