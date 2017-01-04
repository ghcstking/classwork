package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Networking.Client;
import feature.BasicFeature;

public class MyClient extends JFrame{

	private int windowWidth;
	private int windowHeight;
	private ArrayList<Feature> features;
	private Feature playerTwo;
	private NetworkMouseFollower follower;

	private String message;
	private String lastMessage;

	private boolean ableToSend;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String serverIP;//IP Address of the Server
	private Socket connection;//In JAva, connections are called "sockets"

	public static void main(String[] args){
		MyClient charlie;
		charlie = new MyClient("127.0.0.1");//this is the IP address fpr the local host (the computer that I am at)
		charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charlie.startRunning();
	}
	//this computer is given the IP address of the server it is going to connect to
	public MyClient(String host){
		super("Client");
		message = "...";
		showMessage("Starting up...");
		applySettings();
		serverIP = host;
		setVisible(true);
		features = new ArrayList<Feature>();
		addMouseMotionListenerObjects();
		ableToSend = false;
		playerTwo = null;
		addMouseMotionListenerObjects();
		Timer t = new Timer(10, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MyClient.this.repaint();
				int[] followerData = {follower.getX(), follower.getY()};
				if(ableToSend)sendData(followerData);
			}
		});
		t.start();
	}

	protected void applySettings() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
		windowWidth = 1000;
		windowHeight = 800;
		setSize(windowWidth,windowHeight);
		setLocation((monitorWidth-windowWidth)/2, (monitorHeight-windowHeight)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//so that the game terminates after the windo is closed
		setUndecorated(false);//windowBar
		setResizable(true);
	}

	private void addMouseMotionListenerObjects() {
		follower = new NetworkMouseFollower(300, 300, Color.blue);
		features.add(follower);//to make visible
		addMouseMotionListener(follower);//to make active
	}

	public void paint(Graphics screen){
		BufferedImage imageOnTheSide = new BufferedImage(
				getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
	
		Graphics2D g2 = imageOnTheSide.createGraphics();
		g2.setColor(Color.white);
		g2.fillRect(25,35, 300, 50);
		g2.setColor(Color.black);
		g2.drawString(lastMessage, 30, 55);
		g2.drawString(message, 30, 75);
	
		for(Feature f : features){
			g2.drawImage(f.getImage(),
					f.getX(), 
					f.getY(),null);
		}
		if(playerTwo != null)g2.drawImage(playerTwo.getImage(), playerTwo.getX(), playerTwo.getY(), null);
	
		screen.drawImage(imageOnTheSide,0,0,null);
	}

	public void showMessage(String s){
		lastMessage = message;
		message = s;
	}



	//connect to server
	public void startRunning(){
		try{
			connectToServer();//client is responsible for connecting to the server
			setUpStreams();
			whileConnected();
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
		connection = new Socket(InetAddress.getByName(serverIP), MyServer.PORT);//IP address and port
		showMessage("Connected to "+connection.getInetAddress().getHostName()+"\n");
	}

	private void setUpStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\nYour streams are set up");
	}

	private void whileConnected() throws IOException{
		showMessage("You are now connected!");
		ableToSend(true);
		do{
			try{
				InfoPacket data = (InfoPacket)input.readObject();
				playerTwo = new BasicFeature(data.getInfo()[0],data.getInfo()[1]);
				
			}catch(ClassNotFoundException cnfe){
				cnfe.printStackTrace();
				showMessage("Client sent an unknown object");
			}catch(ClassCastException cce){
				cce.printStackTrace();
				showMessage("Client sent an object that cannot be cast");
			}
		}while(true);
	}

	private void close(){
		showMessage("\nClosing connections...");
		ableToSend(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException io){
			io.printStackTrace();
		}
	}

	private void sendData(int[] followerData){
		try{
			InfoPacket data = new InfoPacket(follower.getX(), follower.getY());
			output.writeObject(data);//send the message on the strem
			output.flush();
		}catch(IOException e){
			showMessage("Failed to update client.");
		}
	}

	//this is necessary because without a connection, problems would result from trying to send a message
	private void ableToSend(final boolean b){

		ableToSend = b;


	}
}
