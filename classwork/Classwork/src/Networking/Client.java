package Networking;


import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.MyClient;

public class Client extends JFrame{

	//Java Tutorial 38
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;//IP Address of the Server
	private Socket connection;//In JAva, connections are called "sockets"
	
	public static void main(String[] args){
		MyClient charlie;
		charlie = new MyClient("127.0.0.1");//this is the IP address fpr the local host (the computer that I am at)
		charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charlie.startRunning();
	}

	
	//this computer is given the IP address of the server it is going to connect to
	public Client(String host){
		super("Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);//sets to false until a connection is made
		userText.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				sendMessage(e.getActionCommand());
				userText.setText("");
			}
		});
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300,150);
		setVisible(true);
	}
	
	//connect to server
	public void startRunning(){
		try{
			connectToServer();//client is responsible for connecting to the server
			setUpStreams();
			whileChatting();
		}catch(EOFException e){
			showMessage("\nClient terminated the connection");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	private void connectToServer() throws UnknownHostException, IOException{
		showMessage("Attempting connection....\n");
		connection = new Socket(InetAddress.getByName(serverIP), 6789);//IP address and port
		showMessage("Connected to "+connection.getInetAddress().getHostName()+"\n");
	}
	
	private void setUpStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\nYour streams are set up");
	}
	
	private void whileChatting() throws IOException{
		message = "You are now connected!";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
				
			}catch(ClassNotFoundException cnfe){
				showMessage("Client sent an unknown object");
			}
		}while(!message.equals("SERVER - END"));
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
	
	//send messages to server
	private void sendMessage(String message){
		try{
			output.writeObject("CLIENT - "+message);//send the message on the strem
			output.flush();
			showMessage("\nCLIENT - " + message);
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
