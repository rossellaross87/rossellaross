package com.ats.exChat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class A_Chat_Client_GUI {

	// Globals
	private static A_Chat_Client ChatClient;
	public static String UserName = "Anonymous";

	// GUI Globals-Main Window
	public static JFrame MainWindow = new JFrame();
	private static JButton B_ABOUT = new JButton();
	private static JButton B_CONNECT = new JButton();
	private static JButton B_DISCONNECT = new JButton();
	private static JButton B_HELP = new JButton();
	private static JButton B_SEND = new JButton();
	private static JLabel L_Message = new JLabel("Message: ");
	public static JTextField TF_Message = new JTextField(20);
	private static JLabel L_Conversation = new JLabel();
	public static JTextArea TA_Conversation = new JTextArea();
	private static JScrollPane SP_Conversation = new JScrollPane();
	private static JLabel L_Online = new JLabel();
	public static JList JL_Online = new JList();
	private static JScrollPane SP_Online = new JScrollPane();
	private static JLabel L_LoggedInAs = new JLabel();
	private static JLabel L_LoggedInAsBox = new JLabel();

	// Gui Globals-Login Window
	public static JFrame LoginWindow = new JFrame();
	public static JTextField TF_UserNameBox = new JTextField(20);
	private static JButton B_ENTER = new JButton("ENTER");
	private static JLabel L_EnterUserName = new JLabel("Enter username: ");
	private static JPanel P_Login = new JPanel();

	public static void main(String[] args) {

		BuildMainWindow();
		Initialize();
	}

	public static void Connect() {
		try {
			final int PORT = 53846;
			final String HOST = "192.168.1.100";
			Socket SOCK = new Socket(HOST, PORT);
			System.out.println("You connected to: " + HOST);

			ChatClient = new A_Chat_Client(SOCK);
			// Send name to add to "Online" List
			PrintWriter OUT = new PrintWriter(SOCK.getOutputStream());
			OUT.println(UserName);
			OUT.flush();

			Thread X = new Thread(ChatClient);
			X.start();
		} catch (Exception X) {
			System.out.print(X);
			JOptionPane.showMessageDialog(null, "Server not responding");
			System.exit(0);

		}
	}

	public static void Initialize() {
		B_SEND.setEnabled(false);
		B_DISCONNECT.setEnabled(false);
		B_CONNECT.setEnabled(true);

	}

	public static void BuildMainWindow() {
		MainWindow.setTitle(UserName + "'s Chat Box");
		MainWindow.setSize(450, 500);
		MainWindow.setLocation(220, 180);
		MainWindow.setResizable(false);
		ConfigureMainWindow();
		MainWindow_Action();
		MainWindow.setVisible(true);
	}

	public static void MainWindow_Action() {
		B_SEND.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ACTION_B_SEND();
			}
		});
		B_DISCONNECT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ACTION_B_DISCONNECT();
			}
		});
		B_CONNECT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BuildLoginWindow();
			}
		});
		B_HELP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ACTION_B_HELP();
			}
		});
		B_ABOUT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ACTION_B_HELP();
			}
		});
		
		

	}

	public static void ACTION_B_SEND() {
		if (!TF_Message.getText().equals("")) {
			ChatClient.SEND(TF_Message.getText());
			TF_Message.requestFocus();
		}
	}

	public static void ACTION_B_DISCONNECT() {
		try {
			ChatClient.DISCONNECT();
		} catch (Exception Y) {
			Y.printStackTrace();
		}
	}

	public static void ACTION_B_HELP() {
		JOptionPane.showMessageDialog(null, "Chat Room");
	}

	private static void ConfigureMainWindow() {
		MainWindow.setBackground(new java.awt.Color(255, 255, 255));
		MainWindow.setSize(500, 320);
		MainWindow.getContentPane().setLayout(null);

		B_SEND.setBackground(new java.awt.Color(0, 0, 255));
		B_SEND.setForeground(new java.awt.Color(255, 255, 255));
		B_SEND.setText("SEND");
		MainWindow.getContentPane().add(B_SEND);
		B_SEND.setBounds(250, 40, 81, 25);

		B_DISCONNECT.setBackground(new java.awt.Color(0, 0, 255));
		B_DISCONNECT.setForeground(new java.awt.Color(255, 255, 255));
		B_DISCONNECT.setText("DISCONNECT");
		MainWindow.getContentPane().add(B_DISCONNECT);
		B_DISCONNECT.setBounds(10, 40, 110, 25);

		B_CONNECT.setBackground(new java.awt.Color(0, 0, 255));
		B_CONNECT.setForeground(new java.awt.Color(255, 255, 255));
		B_CONNECT.setText("CONNECT");
		B_CONNECT.setToolTipText("");
		MainWindow.getContentPane().add(B_CONNECT);
		B_CONNECT.setBounds(130, 40, 110, 25);

		B_HELP.setBackground(new java.awt.Color(0, 0, 255));
		B_HELP.setForeground(new java.awt.Color(255, 255, 255));
		B_HELP.setText("HELP");
		MainWindow.getContentPane().add(B_HELP);
		B_HELP.setBounds(420, 40, 70, 25);

		B_ABOUT.setBackground(new java.awt.Color(0, 0, 255));
		B_ABOUT.setForeground(new java.awt.Color(255, 255, 255));
		B_ABOUT.setText("ABOUT");
		MainWindow.getContentPane().add(B_ABOUT);
		B_ABOUT.setBounds(340, 40, 70, 25);

		L_Message.setText("Message: ");
		MainWindow.getContentPane().add(L_Message);
		L_Message.setBounds(10, 10, 60, 20);

		TF_Message.setForeground(new java.awt.Color(0, 0, 255));
		TF_Message.requestFocus();
		MainWindow.getContentPane().add(TF_Message);
		TF_Message.setBounds(70, 4, 260, 30);

		L_Conversation.setHorizontalAlignment(SwingConstants.CENTER);
		L_Conversation.setText("Conversation");
		MainWindow.getContentPane().add(L_Conversation);
		L_Conversation.setBounds(100, 70, 140, 16);

		TA_Conversation.setColumns(20);
		TA_Conversation.setFont(new java.awt.Font("Tahoma", 0, 12));
		TA_Conversation.setForeground(new java.awt.Color(0, 0, 255));
		TA_Conversation.setLineWrap(true);
		TA_Conversation.setRows(5);
		TA_Conversation.setEditable(false);

		SP_Conversation
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		SP_Conversation
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		SP_Conversation.setViewportView(TA_Conversation);
		MainWindow.getContentPane().add(SP_Conversation);
		SP_Conversation.setBounds(10, 90, 330, 180);

		L_Online.setHorizontalAlignment(SwingConstants.CENTER);
		L_Online.setText("Currently Online");
		L_Online.setToolTipText("");
		MainWindow.getContentPane().add(L_Online);
		L_Online.setBounds(350, 70, 130, 16);

		// String[] TestNames = { "Bob", "Sue", "Jenny", "Anna" };
		JL_Online.setForeground(new java.awt.Color(0, 0, 255));
		// JL_Online.setListData(TestNames);

		SP_Online
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		SP_Online
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		SP_Online.setViewportView(JL_Online);
		MainWindow.getContentPane().add(SP_Online);
		SP_Online.setBounds(350, 90, 130, 180);

		L_LoggedInAs.setFont(new java.awt.Font("Tahoma", 0, 12));
		L_LoggedInAs.setText("Currently Logged In As");
		MainWindow.getContentPane().add(L_LoggedInAs);
		L_LoggedInAs.setBounds(348, 0, 140, 15);

		L_LoggedInAsBox.setHorizontalAlignment(SwingConstants.CENTER);
		L_LoggedInAsBox.setFont(new java.awt.Font("Tahoma", 0, 12));
		L_LoggedInAsBox.setForeground(new java.awt.Color(255, 0, 0));
		L_LoggedInAsBox.setBorder(BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		MainWindow.getContentPane().add(L_LoggedInAsBox);
		L_LoggedInAsBox.setBounds(340, 17, 150, 20);

	}

	public static void BuildLoginWindow() {
		LoginWindow.setTitle("What's your name?");
		LoginWindow.setSize(400, 100);
		LoginWindow.setLocation(250, 200);
		LoginWindow.setResizable(false);
		P_Login = new JPanel();
		P_Login.add(L_EnterUserName);
		P_Login.add(TF_UserNameBox);
		P_Login.add(B_ENTER);
		LoginWindow.add(P_Login);

		Login_Action();
		LoginWindow.setVisible(true);
	}

	private static void Login_Action() {
		B_ENTER.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ACTION_B_ENTER();
			}

		});

	}

	private static void ACTION_B_ENTER() {
		if (!TF_UserNameBox.getText().equals("")) {
			UserName = TF_UserNameBox.getText().trim();
			L_LoggedInAsBox.setText(UserName);
			A_Chat_Server.CurrentUsers.add(UserName);
			MainWindow.setTitle(UserName + "'s Chat Box");
			LoginWindow.setVisible(false);
			B_SEND.setEnabled(true);
			B_DISCONNECT.setEnabled(true);
			B_CONNECT.setEnabled(false);
			Connect();
		} else {
			JOptionPane.showMessageDialog(null, "Please enter a name!");
		}

	}

}