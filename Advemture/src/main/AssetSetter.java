package main;

import entity.NPC_OldMan;
import monster.Slime;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import tiles_contact.CT_DryTree;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		int i = 0;
		
		// KEY
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
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
		
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize * 25;
		gp.obj[i].worldY = gp.tileSize * 27;
		i++;
		
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize * 22;
		gp.obj[i].worldY = gp.tileSize * 30;
		i++;
	}
	
	public void setNPC() {
		
		int i = 0;
		
		gp.npc[i] = new NPC_OldMan(gp);
		gp.npc[i].worldX = gp.tileSize * 21;
		gp.npc[i].worldY = gp.tileSize * 21;
		i++;
	}
	
	public void setMonster() {
		
		int i = 0;
		
		gp.monster[i] = new Slime(gp);
		gp.monster[i].worldX = gp.tileSize * 20;
		gp.monster[i].worldY = gp.tileSize * 21;
		i++;
		
		gp.monster[i] = new Slime(gp);
		gp.monster[i].worldX = gp.tileSize * 11;
		gp.monster[i].worldY = gp.tileSize * 11;
		i++;
	}
	
	public void setContactTile() {
		
		int i = 0;
		
		gp.cTile[i] = new CT_DryTree(gp,27,12);i++;
		
		gp.cTile[i] = new CT_DryTree(gp,28,12);i++;
		
		gp.cTile[i] = new CT_DryTree(gp,29,12);i++;
		
		gp.cTile[i] = new CT_DryTree(gp,30,12);i++;
		
		gp.cTile[i] = new CT_DryTree(gp,31,12);i++;
		
		gp.cTile[i] = new CT_DryTree(gp,32,12);i++;
		
		gp.cTile[i] = new CT_DryTree(gp,33,12);i++;
		
	}
}
