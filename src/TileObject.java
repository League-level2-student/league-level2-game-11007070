import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TileObject {
	String valueT;
	int value;
	int tileSize = 70;
	int x;
	int y;
	int valueX;
	int valueY;
	int offsetX = 100;
	int offsetY = 120;
	Font valueFont = new Font("Arial", Font.PLAIN, 25);
	
	public void draw(Graphics g) {
		if (value == 0) {
			valueT = "";
			g.setColor(Color.LIGHT_GRAY);
		}
		else {
			valueT = value+"";
		}
		
		if (value == 2) {
			g.setColor(Color.GRAY);
		}
		else if (value == 4) {
			g.setColor(Color.DARK_GRAY);
		}
		else if (value == 8) {
			g.setColor(Color.yellow);
		}
		else if (value == 16) {
			g.setColor(Color.orange);
		}
		else if (value == 32) {
			g.setColor(Color.getHSBColor(250,173,106));
		}
		else if (value == 64) {
			g.setColor(Color.red);
		}
		else if (value == 128) {
			g.setColor(Color.green);
		}
		else if (value == 256) {
			g.setColor(Color.CYAN);
		}
		else if (value == 512) {
			g.setColor(Color.BLUE);
		}
		else if (value == 1024) {
			g.setColor(Color.magenta);
		}
		else if (value == 2048) {
			g.setColor(Color.pink);
		}
		
		g.fillRect(x,y, tileSize, tileSize);
		g.setColor(Color.BLACK);
		g.drawRect(x,y, tileSize, tileSize);
		g.setColor(Color.BLACK);
		g.drawString(valueT, valueX, valueY);
	}
	
	public void update(int i, int j) {
		y = i*tileSize + offsetX;
		x = j*tileSize + offsetY;
		valueX = x+30;
		valueY = y+45;
	}
	
	TileObject (int i, int j) {
		y = i*tileSize + offsetX;
		x = j*tileSize + offsetY;
		valueX = x+30;
		valueY = y+45;
		//valueT = Integer.toString(value);
	}
}
