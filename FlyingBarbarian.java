package barbarianAttack;

import java.awt.Image;

public class FlyingBarbarian extends Barbarian {

	private int upperLimit, lowerLimit;
	private int vy;
	
	public FlyingBarbarian(Image[] images, int x, int y, int vx, int flySpan) {
		super(images, x, y, vx);
		vy = (int)(Math.random()*4);
		upperLimit = y + flySpan;
		lowerLimit = y - flySpan;
	}

	public void move(){
		x += vx;
		y += vy;
		if(x>Coordinator.GAME_OVER_X) Coordinator.gameOver = true;
		if(y>upperLimit || y<lowerLimit) vy = -vy;
	}
	
	
}
