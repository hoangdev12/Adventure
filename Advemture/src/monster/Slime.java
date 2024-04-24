package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class Slime extends Entity {

	GamePanel gp;
	
	public Slime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Slime";
		speed = 1;
		maxLife = 4;
		life = maxLife;
		attack = 5;
		defense = 0;
		exp = 6;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		
		up1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
	    up2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
	    down1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
	    down2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
	    left1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
	    left2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
	    right1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
	    right2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
	    
	}
	
	public void setAction() {
		
		actionLockCounter ++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; // pick up a number from 1 to 100
		
			if(i <= 25) {
				direction = "up";
			}
			else if(i <= 50) {
				direction = "down";
			}
			else if(i <= 75) {
				direction = "left";
			}
			else if(i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}
	}
	
	public void damageReaction() {
		
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
}
