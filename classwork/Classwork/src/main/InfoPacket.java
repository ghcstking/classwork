package main;

import java.io.Serializable;

public class InfoPacket implements Serializable {

	int[] info;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7937139701795525216L;

	
	public InfoPacket(int x, int y){
		info = new int[2];
		info[0] = x;
		info[1] = y;
	}
	
	public int[] getInfo(){
		return info;
	}
}
