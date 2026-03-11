package edu.neumont.csc150.server;

import edu.neumont.csc150.controllers.EsPayController;

import java.net.*;
import java.io.*;
import java.util.function.Consumer;


public class Server {
	private static ServerSocket serverSocket;

	public static void run() throws IOException {
		serverSocket = new ServerSocket(8080);
		System.out.println("Waiting for ESP32 connection...");
		try {
			while (true) {
				Socket clientSocket = serverSocket.accept(); // throws when closed
				System.out.println("ESP32 connected: " + clientSocket.getInetAddress());
				new Thread(() -> openCardReader(clientSocket, cardNum -> EsPayController.readCard(cardNum))).start();
				stopServer();
			}
		} catch (SocketException e) {
			System.out.println("Server closed."); // expected when stopServer() is called
		}
	}

	public static void stopServer() throws IOException {
		if (serverSocket != null && !serverSocket.isClosed()) {
			serverSocket.close(); // causes serverSocket.accept() to throw SocketException
		}
	}

	public static void openCardReader(Socket socket, Consumer<String> onCardRead) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(
				socket.getOutputStream(), true)) {
			String cardNum;
			while ((cardNum = in.readLine()) != null && !serverSocket.isClosed()) {
//				Display Card Number
//				System.out.println("Card Number: " + cardNum);
				onCardRead.accept(cardNum);
				stopServer();
			}
		} catch (IOException e) {
			System.out.println("Client disconnected.");
		}
	}

//	public static void openCardReader(Socket socket) {
//		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(
//				socket.getOutputStream(), true)) {
//			String cardNum;
//			while ((cardNum = in.readLine()) != null) {
//				System.out.println("Card Number: " + cardNum); // Displays received Card Number
//				out.println("received.");
//
//			}
//		} catch (IOException e) {
//			System.out.println("Client disconnected.");
//		}
//	}

}
