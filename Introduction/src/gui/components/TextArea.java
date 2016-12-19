package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextArea extends TextLabel{

	public TextArea(int x, int y, int w, int h, String text) {
		super(x,y,w,h,text);
	}

	public void update (Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.black);
		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		FontMetrics fm = g.getFontMetrics();
//		String[] words = getText().split(" ");
//		String firstLine = "";
//		int width = getWidth();
//		for(int i = 0; i < words.length; i++) {
//			int length = fm.stringWidth(words[i]);
//			if(length < width) {
//				firstLine += words[i];
//				width = width - length;
//			}
//		}
		if (getText() != null) {
			g.setColor(Color.black);
			g.drawString(getText(), 4, getHeight() - 5);
		}
	}
}
