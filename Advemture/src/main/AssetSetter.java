package main;

import entity.NPC_OldMan;
import monster.Slime;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
	}
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize * 21;
		gp.npc[0].worldY = gp.tileSize * 21;

	}
	
	public void setMonster() {
		
		gp.monster[0] = new Slime(gp);
		gp.monster[0].worldX = gp.tileSize * 20;
		gp.monster[0].worldY = gp.tileSize * 21;

		gp.monster[1] = new Slime(gp);
		gp.monster[1].worldX = gp.tileSize * 11;
		gp.monster[1].worldY = gp.tileSize * 11;
	}
}
