import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class BufferedOrNot extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7605304053428962671L;
	int width = 200;
	int height = 500;

	public static void main(String[] args) {
		new BufferedOrNot();
	}

	public BufferedOrNot(){
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
	}

	public void paint(Graphics g){
		//to demonstarte, change g1 to g and g to g2 or vice versa
		BufferedImage b = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) b.getGraphics();
		//g1.drawString("Painting the image...", width/2-100, height/2);
		int squareDim = 10;
		int r=0;
		int c = 0;
		for(int c1=0; c1<255;c1++){
			for(int c2=0; c2<255; c2++){
				for(int c3=0; c3<255; c3++){
					g.setColor(new Color(c1,c2,c3));
					g.fillRect(r, c, squareDim, squareDim);
					r+=squareDim+2;
					if(r>width){
						r=0;
						c+=squareDim+2;
						if(c>height){
							c=0;
							r=0;
						}
					}
				}
			}
		}
//		g.drawImage(b, 0, 0, null);
	}
}
