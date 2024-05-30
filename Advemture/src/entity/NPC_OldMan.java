package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity{
	
	

	public NPC_OldMan(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 2;
		
		solidArea = new Rectangle();
		solidArea.x = 8; 
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		
		up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/oldman_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/oldman_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/oldman_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/oldman_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/oldman_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/oldman_right_2", gp.tileSize, gp.tileSize);
	}
	
	public void setDialogue() {
		
		dialogues[0] = "... Hello";
		dialogues[1] = "So u wanna find the treasure?";
		dialogues[2] = "Well, Good luck on you.";
		dialogues[3] = "... GoodBye!";
	}
	
	public void setAction() {
		
		if(onPath == true) {
			
			int goalCol = (gp.player.worldX + gp.player.solidAreaDefaultX) / gp.tileSize;
			int goalRow = (gp.player.worldY + gp.player.solidAreaDefaultY) / gp.tileSize;
			
			searchPath(goalCol, goalRow);
		}
		else {

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
	}
		
	
	public void speak() {
		
		super.speak();
		
		onPath = true;
	}
}
