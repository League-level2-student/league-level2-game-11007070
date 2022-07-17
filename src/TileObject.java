import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TileObject {
	String valueT;
	int value;
	int tileSize = 70;
	int x;
	int y;
	int offsetX = 100;
	int offsetY = 120;
	Font valueFont = new Font("Arial", Font.PLAIN, 25);
	
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x,y, tileSize, tileSize);
		g.setColor(Color.BLACK);
		g.drawRect(x,y, tileSize, tileSize);
		g.setColor(Color.BLACK);
		g.drawString(valueT, x, y);
	}
	
	TileObject (int i, int j, int value) {
		x = i*tileSize + offsetX;
		y = j*tileSize + offsetY;
		valueT = Integer.toString(value);
	}
}
