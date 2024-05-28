package tiles_contact;

import entity.Entity;
import main.GamePanel;

public class ContactTile extends Entity {

	GamePanel gp;
	public boolean destructible = false;
	
	public ContactTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}

	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		
		if(entity.currentWeapon.type == type_axe && gp.keyH.enterPressed == true) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
	
	public void PlaySE() {}
	
	public ContactTile getDestroyedForm() {
		ContactTile tile = null;
		return tile;
	}
	
	public void update() {
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 20) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
	}
}
