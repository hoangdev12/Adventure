package tiles_contact;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class CT_DryTree extends ContactTile {

	GamePanel gp;
	
	public CT_DryTree(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tiles_contact/drytree",gp.tileSize,gp.tileSize);
		destructible = true;
		life = 1;
	}
	
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		if(entity.currentWeapon.type == type_axe) {
			isCorrectItem = true;
			
		}
		return isCorrectItem;
	}
	
	public void PlaySE() {
		gp.playSE(11);
	}
	
	public ContactTile getDestroyedForm() {
		ContactTile tile = new CT_Trunk(gp, worldX / gp.tileSize, worldY / gp.tileSize);
		return tile;
	}
	
	public Color getParticleColor() {
		Color color = new Color(65,50,30);
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
}
