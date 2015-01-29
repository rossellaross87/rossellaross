package com.ats.exChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class A_Chat_Server {

	// Globals
	public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
	public static ArrayList<String> CurrentUsers = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		try {
			final int PORT = 53846;
			ServerSocket SERVER = new ServerSocket(PORT);
			System.out.println("Waiting for clients...");
			// while we are in the try block
			while (true) {
				//Un socket � un canale di comunicazione di rete con altre macchine; in un certo senso � come un file, 
				//con la differenza che scrivendo in questo canale, qualcun altro "dall'altra parte" potr� leggere quello che si � scritto;
				//inoltre il canale � bidirezionale, cio� chi scrive pu� anche leggere
				Socket SOCK = SERVER.accept();
				ConnectionArray.add(SOCK);
				// Display ip address and host name
				System.out.println("Client connected from: "
						+ SOCK.getLocalAddress().getHostName());
				// addUserName to the list of users online
				addUserName(SOCK);
				A_Chat_Server_Return CHAT = new A_Chat_Server_Return(SOCK);
				Thread X = new Thread(CHAT);
				X.start();
			}

		} catch (Exception X) {

			System.out.print(X);

		}
	}

	private static void addUserName(Socket X) throws IOException {
		Scanner INPUT = new Scanner(X.getInputStream());
		String UserName = INPUT.nextLine();
		CurrentUsers.add(UserName);
		//Display gli users online
		for (int i = 1; i <= A_Chat_Server.ConnectionArray.size(); i++) {
			Socket TEMP_SOCK = (Socket) A_Chat_Server.ConnectionArray
					.get(i - 1);
			PrintWriter OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
			OUT.println("#?!" + CurrentUsers);
			// Il metodo OutputStream.flush() obbliga lo stream a svuotare il
			// buffer,
			// inviando a destinazione l'output nel buffer
			OUT.flush();

		}

	}

}
