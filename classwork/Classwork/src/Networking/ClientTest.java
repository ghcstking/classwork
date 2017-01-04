package Networking;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientTest {
	public static void main(String[] args){
		Client charlie;
		charlie = new Client("127.0.0.1");//this is the IP address fpr the local host (the computer that I am at)
		charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charlie.startRunning();
	}
}
