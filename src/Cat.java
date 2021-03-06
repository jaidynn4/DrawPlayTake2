import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	
	// New addition - nose (will just be the mouth but half the size and in the middle of the head)
	private static final int NOSE_Y = HEAD_DIMENSION/2;
	private static final int NOSE_X = HEAD_DIMENSION/2;
	private static final int NOSE_HEIGHT = 10;
	private static final int NOSE_WIDTH = 5;
	
	// New addition - ears (two triangles the same size as the eyes sticking straight up from the top of the head)
	private static final int EAR_ONE_Y = HEAD_DIMENSION/5;
	private static final int EAR_ONE_X = HEAD_DIMENSION/5;
	private static final int EAR_TWO_Y = HEAD_DIMENSION/6;
	private static final int EAR_TWO_X = HEAD_DIMENSION/2;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY, Color furColor)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw the head
		g2.setColor(furColor);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.green);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		// Draw the nose
		x = catX + NOSE_X;
		y = catY + NOSE_Y;
		g2.fillOval(x, y, NOSE_WIDTH, NOSE_HEIGHT);
		
		
		g2.setColor(furColor);
		x = catX + EAR_ONE_X;
		y = catY + EAR_ONE_Y;
		g2.fillPolygon(new int[] {x-5, x, x+5}, new int[] {y, y-30, y}, 3);
		x = catX + EAR_TWO_X;
		y = catY + EAR_TWO_Y;
		g2.fillPolygon(new int[] {x-5, x, x+5}, new int[] {y, y-30, y}, 3);
		
		
		g2.setColor(Color.black);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Hello There!", catX, catY+HEAD_DIMENSION+10);	
	}
}
