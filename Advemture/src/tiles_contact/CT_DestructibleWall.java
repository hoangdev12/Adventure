package tiles_contact;

import java.awt.Color;
import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;

public class CT_DestructibleWall  extends ContactTile{

	GamePanel gp;
	
	public CT_DestructibleWall(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tiles_contact/destructiblewall",gp.tileSize,gp.tileSize);
		destructible = true;
		life = 3;
	}
	
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		if(entity.currentWeapon.type == type_pickaxe) {
			isCorrectItem = true;
		}
		return isCorrectItem;
		
	}
	
	public void PlaySE() {
		gp.playSE(11);
	}
	
	public ContactTile getDestroyedForm() {
		ContactTile tile = null;
		return tile;
	}
	
	public Color getParticleColor() {
		Color color = new Color(65,65,65);
		return color;
	}
	
	public int getParticleSize() {
		int size = 6; // 6 pixels
		return size;
	}
	
	public int getParticleSpeed() {
		speed = 1;
		return speed;
	}
	
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
//	public void checkDrop() {
//		
//		// RANDOM % DROP ITEM
//		int i = new Random().nextInt(100) + 1;
//		
//		// SET THE MONSTER DROP
//		if(i <= 50) {
//			dropItem(new OBJ_Coin_Bronze(gp));
//		}
//		if(i > 50 && i <= 75) {
//			dropItem(new OBJ_Heart(gp));
//		}
//		if(i > 75 && i <= 100) {
//			dropItem(new OBJ_ManaCrystal(gp));
//		}
//	}
}
