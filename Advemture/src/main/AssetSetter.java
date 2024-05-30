package main;

import entity.NPC_Merchant;
import entity.NPC_OldMan;
import monster.Slime;
import object.OBJ_Axe;
import object.OBJ_Chest;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
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
		
		int mapNum = 0;
		int i = 0;
		
		gp.obj[mapNum][i] = new OBJ_Axe(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize * 33;
		gp.obj[mapNum][i].worldY = gp.tileSize * 7;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Door(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize * 14;
		gp.obj[mapNum][i].worldY = gp.tileSize * 28;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Door(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize * 12;
		gp.obj[mapNum][i].worldY = gp.tileSize * 12;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Chest(gp, new OBJ_Key(gp));
		gp.obj[mapNum][i].worldX = gp.tileSize * 30;
		gp.obj[mapNum][i].worldY = gp.tileSize * 29;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize * 21;
		gp.obj[mapNum][i].worldY = gp.tileSize * 20;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize * 20;
		gp.obj[mapNum][i].worldY = gp.tileSize * 20;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize * 17;
		gp.obj[mapNum][i].worldY = gp.tileSize * 21;
		i++;
	}
	
	public void setNPC() {
		
		// MAP 0
		int mapNum = 0;
		int i = 0;
		
		gp.npc[mapNum][i] = new NPC_OldMan(gp);
		gp.npc[mapNum][i].worldX = gp.tileSize * 21;
		gp.npc[mapNum][i].worldY = gp.tileSize * 21;
		i++;
		
		// MAP 1
		mapNum = 1;
		i = 0;
		
		gp.npc[mapNum][i] = new NPC_Merchant(gp);
		gp.npc[mapNum][i].worldX = gp.tileSize * 12;
		gp.npc[mapNum][i].worldY = gp.tileSize * 7;
		i++;
		
//		gp.npc[mapNum][i] = new NPC_OldMan(gp);
//		gp.npc[mapNum][i].worldX = gp.tileSize * 21;
//		gp.npc[mapNum][i].worldY = gp.tileSize * 21;
//		i++;
//		
//		gp.npc[mapNum][i] = new NPC_OldMan(gp);
//		gp.npc[mapNum][i].worldX = gp.tileSize * 21;
//		gp.npc[mapNum][i].worldY = gp.tileSize * 21;
//		i++;
	}
	
	public void setMonster() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize * 20;
		gp.monster[mapNum][i].worldY = gp.tileSize * 21;
		i++;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize * 11;
		gp.monster[mapNum][i].worldY = gp.tileSize * 11;
		i++;
	}
	
	public void setContactTile() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,27,12);i++;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,28,12);i++;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,29,12);i++;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,30,12);i++;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,31,12);i++;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,32,12);i++;
		
		gp.cTile[mapNum][i] = new CT_DryTree(gp,33,12);i++;
		
	}
}
