package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.net.*;
import java.io.*;

import feature.BasicFeature;
import feature.CustomGraphics;
import feature.MouseFollower;

public class MyServer extends JFrame{

	private int windowWidth;
	private int windowHeight;
	private ArrayList<Feature> features;
	private String message;
	private String lastMessage;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private boolean ableToSend;
	private NetworkMouseFollower follower;
	private Feature playerTwo;

	public static final int PORT = 8081;

	public MyServer() {
		super("Draw with friends!");
		applySettings();
		message = "You are running the server!";
		lastMessage ="";
		showMessage(message);
		setVisible(true);
		features = new ArrayList<Feature>();
		addMouseMotionListenerObjects();
		ableToSend = false;
		playerTwo = null;
		addMouseMotionListenerObjects();
		Timer t = new Timer(10, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MyServer.this.repaint();
				
				if(ableToSend)sendData(new InfoPacket(follower.getX(), follower.getY()));
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
		follower = new NetworkMouseFollower(300, 300,Color.red);
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

	public void startRunning(){
		try{
			server = new ServerSocket(PORT, 100);
			//6789 is the port for this Java application
			//100 is the backlog (number of people to be in line
			//at this port)
			while(true){
				try{
					waitForAConnection();
					setupStreams();
					whileConnected();
				}catch(EOFException eof){
					showMessage("\nServer ended the connection");
				}finally{
					close();
				}
			}

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void waitForAConnection() throws IOException{
		showMessage("Waiting for someone to connect...");
		connection = server.accept();
		showMessage("Now connected to "+
		connection.getInetAddress().getHostName());
	}
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();//only output can flush, clears out the output stream (rids of all bytes)
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("Streams are now set up!");
		
	}
	
	private void whileConnected() throws IOException{
		showMessage("You are now connected!");
		ableToSend(true);
		do{
			try{
				InfoPacket data = (InfoPacket)input.readObject();
				playerTwo = new BasicFeature(data.getInfo()[0],data.getInfo()[1]);
				
			}catch(ClassNotFoundException cnfe){
				showMessage("Client sent an unknown object");
			}
		}while(!message.equals("CIENT - END"));
	}
	
	
	private void ableToSend(final boolean b){
		ableToSend = b;
	}
	
	private void close(){
		showMessage("Closing connections...");
		ableToSend(false);
		try{
			output.close();
			input.close();
			connection.close();
			playerTwo = null;
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	private void sendData(InfoPacket data){
		try{
			output.writeObject(data);//send the message on the strem
			output.flush();
		}catch(IOException e){
			showMessage("Failed to update client.");
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyServer server = new MyServer();
		server.startRunning();
	}

















}
