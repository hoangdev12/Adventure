package main;

import entity.NPC_OldMan;
import monster.Slime;
import object.OBJ_Axe;
import object.OBJ_Key;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		int i = 0;
		
		// KEY
		gp.obj[i] = new OBJ_Key(gp);
		gp.obj[i].worldX = gp.tileSize * 25;
		gp.obj[i].worldY = gp.tileSize * 23;
		i++;
		gp.obj[i] = new OBJ_Key(gp);
		gp.obj[i].worldX = gp.tileSize * 21;
		gp.obj[i].worldY = gp.tileSize * 19;
		i++;
		gp.obj[i] = new OBJ_Key(gp);
		gp.obj[i].worldX = gp.tileSize * 26;
		gp.obj[i].worldY = gp.tileSize * 21;
		i++;
		
		// AXE
		gp.obj[i] = new OBJ_Axe(gp);
		gp.obj[i].worldX = gp.tileSize * 33;
		gp.obj[i].worldY = gp.tileSize * 21;
		i++;
		
		// SHIELD BLUE
		gp.obj[i] = new OBJ_Shield_Blue(gp);
		gp.obj[i].worldX = gp.tileSize * 35;
		gp.obj[i].worldY = gp.tileSize * 21;
		i++;
		
		// POTION RED
		gp.obj[i] = new OBJ_Potion_Red(gp);
		gp.obj[i].worldX = gp.tileSize * 22;
		gp.obj[i].worldY = gp.tileSize * 27;
		i++;
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
