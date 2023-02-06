package barbarianAttack;

import java.awt.Graphics2D;
import java.awt.Image;




public abstract class Barbarian {

	protected int x, y;
	protected int vx;
	protected Image[] images;
	protected int width, height;
	protected int drawIndex, drawCycle = 10;

	
	
	public Barbarian(Image[] images, int x, int y, int vx) {
		this.images = images;
		this.x = x;
		this.y = y;
		this.vx = vx;
		
		width = images[0].getWidth(null);
		height = images[0].getHeight(null);
	}
	
	
	public abstract void move();
	
	
	public void draw(Graphics2D g){
		int select = drawIndex++%drawCycle<drawCycle/2? 0:1;
		g.drawImage(images[select], x, y, null);
	}
	
	
	public boolean isHit(Arrow arrow){
		double arrowX = arrow.getX();
		double arrowY = arrow.getY();
		boolean isHit = arrowX>=x && arrowX<=x+width && arrowY>=y && arrowY<=y+height;
		if(isHit)
		{
			Coordinator.score++;
		}
		return isHit;
	}
}






