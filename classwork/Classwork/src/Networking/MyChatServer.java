package Networking;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyChatServer extends JFrame{

	//Java Tutorial 38
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;//In JAva, connections are called "sockets"
	
	public MyChatServer(){
		super("Mr. Nockles' Instant Messenger");
		userText = new JTextField();
		userText.setEditable(false);//sets to false until a connection is made
		userText.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				sendMessage(e.getActionCommand());//sends the text typed into the field
				userText.setText("");
			}
		});
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	
	//set up and run the server
	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100);//port number (6789 is a dummy number) 
			//every computer has multiple applications, so whenever I connect to a server, we have to find the application that we want to interact with
			//this lets "the boat" with the information entering the computer find the port number for the application
			//100 is the backlog, which tells how many people can be waiting to wait at the port
			//from the client side application, you must also use the port number
			while(true){//repeats so that people can connect disconnect, then connect again, etc
				try{
					//connect and have conversation with someone else
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException eofException){
					showMessage("\n Server ended the connection!");
				}finally{
					close();
				}
			}
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}

	
	private void waitForConnection () throws IOException{
		showMessage("Waiting for someone to connect...");
		connection = server.accept();//this will be null until a connection is made
		showMessage("Now connected to "+connection.getInetAddress().getHostName());//returns the String of the IP address
	}

	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();//only output can flush, clears out the output stream (rids of all bytes)
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("Streams are now set up!");
		
	}
	
	private void whileChatting() throws IOException{
		String message = "You are now connected!";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
				
			}catch(ClassNotFoundException cnfe){
				showMessage("Client sent an unknown object");
			}
		}while(!message.equals("CIENT - END"));
	}
	
	
	private void close(){
		showMessage("\nClosing connections...");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	private void sendMessage(String message){
		try{
			output.writeObject("SERVER - "+message);//send the message on the strem
			output.flush();
			showMessage("\nSERVER - " + message);
		}catch(IOException e){
			chatWindow.append("\nFailed to send message");
		}
	}
	
	
	//updates chatWindow
	private void showMessage(final String text){
		SwingUtilities.invokeLater(//TODO: Why is this necessary?
				new Runnable(){
					public void run(){
						chatWindow.append(text);
					}
				}
				);

	}
	
	//this is necessary because without a connection, problems would result from trying to send a message
	private void ableToType(final boolean b){
		SwingUtilities.invokeLater(//TODO: Why is this necessary?
				new Runnable(){
					public void run(){
						userText.setEditable(b);
					}
				}
				);
		
	}
	
}


















