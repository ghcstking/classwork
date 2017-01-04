package Networking;

import javax.swing.JFrame;

public class ServerTest {

	public static void main(String[] arg){
		MyChatServer sally = new MyChatServer();
		sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sally.startRunning();
	}
}
