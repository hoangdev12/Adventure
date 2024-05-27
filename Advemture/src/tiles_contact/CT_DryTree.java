package tiles_contact;

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
		life = 3;
	}

	public void PlaySE() {
		gp.playSE(11);
	}
	
	public ContactTile getDestroyedForm() {
		ContactTile tile = new CT_Trunk(gp, worldX / gp.tileSize, worldY / gp.tileSize);
		return tile;
	}
}
