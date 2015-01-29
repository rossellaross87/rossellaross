package com.ats.exChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class A_Chat_Server_Return implements Runnable {
	//Globals
	Socket SOCK;
	
	private Scanner INPUT;
	private PrintWriter OUT;
	String MESSAGE = "";
	
	
	//Quando il costruttore termina X viene distrutta perchè è una variabile locale ,
	//ma passandola come argomento del costruttore, ho un 
	//puntatore al valore originale della variabile globale SOCK che persiste in memoria
	public A_Chat_Server_Return(Socket X) {
		this.SOCK =X;
	}
	
	public void CheckConnection() throws IOException {
		if(!SOCK.isConnected()){
			for(int i=1; i<= A_Chat_Server.ConnectionArray.size(); i++){
				if(A_Chat_Server.ConnectionArray.get(i)==SOCK)
				{
					A_Chat_Server.ConnectionArray.remove(i);
				}
			}
			for(int i=1; i<= A_Chat_Server.ConnectionArray.size(); i++){
				Socket TEMP_SOCK = (Socket) A_Chat_Server.ConnectionArray.get(i-1);
				PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
				TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName() + "disconnected!");
				TEMP_OUT.flush();
				//Show disconnection at server
				System.out.println(TEMP_SOCK.getLocalAddress().getHostName() + "disconnected!");
				
			}
		}
	}


	public void run() {
		try{
			try{
				
				INPUT = new Scanner(SOCK.getInputStream());
				OUT = new PrintWriter(SOCK.getOutputStream());
				while(true){
					CheckConnection();
					if(!INPUT.hasNext()){
						return;
					}
					MESSAGE = INPUT.nextLine();
					System.out.println("Client said: " + MESSAGE);
					for(int i=1; i<=A_Chat_Server.ConnectionArray.size(); i++){
						Socket TEMP_SOCK = (Socket) A_Chat_Server.ConnectionArray.get(i-1);
						PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
						TEMP_OUT.println(MESSAGE);
						TEMP_OUT.flush();
						System.out.println("Sent to: " + TEMP_SOCK.getLocalAddress().getHostName());
						
					}
				}
				}finally {
					SOCK.close();
				}
		} catch(Exception X){
			System.out.print(X);
		}
		
	}

}
