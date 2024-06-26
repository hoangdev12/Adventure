package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import ai.PathFinder;
import data.SaveLoad;
import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile.Map;
import tile.TileManager;
import tiles_contact.ContactTile;

public class GamePanel extends JPanel implements Runnable{
	
      // setting screen
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //960 px
	public final int screenHeight = tileSize * maxScreenRow; //576 px
	
	//WORLD SETTING	
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldHeight = tileSize * maxWorldRow;
    public final int worldWidth = tileSize * maxWorldCol;
	public final int maxMap = 10;
	public int currentMap = 3;
    
    // FULL SCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    public boolean fullScreenOn = false;
	
	//FPS
	int FPS = 60;
	
	//SYSTEM
	public TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Config config = new Config(this);
	public PathFinder pFinder = new PathFinder(this);
	EnvironmentManager eManager = new EnvironmentManager(this);
	Map map = new Map(this);
	SaveLoad saveLoad = new SaveLoad(this);
	Thread gameThread;
	
	
	//SOUND EFFECT
	Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	
	
	//ENTITY AND OBJECT
	public Player player = new Player(this,keyH);
	public Entity obj[][] = new Entity[maxMap][20];
	public Entity npc[][] = new Entity[maxMap][20];
	public Entity monster[][] = new Entity[maxMap][20];
	public ContactTile cTile[][] = new ContactTile[maxMap][50];
	public Entity projectile[][] = new Entity[maxMap][20];
//	public ArrayList<Entity> projectileList = new ArrayList<>();
	public ArrayList<Entity> particleList = new ArrayList<>();
	ArrayList<Entity> entityList = new ArrayList<>();
	
	
	// GAMESTATE
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3; // Doi thoai giua PLAYER va NPC
	public final int characterState = 4;
	public final int optionsState = 5; // MENU
	public final int gameOver = 6;
	public final int transitionState = 7;
	public final int tradeState = 8;
	public final int sleepState = 9;
	public final int mapState = 10;
	
	//AREA
	public int currentArea;
	public int nextArea;
	public final int outside = 50;
	public final int indoor = 51;
	public final int dungeon = 52;
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		aSetter.setContactTile();
		eManager.setup();
		
		gameState = titleState;
		currentArea = outside;
		
		tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		g2 = (Graphics2D)tempScreen.getGraphics();
		
		if(fullScreenOn == true) {
			setFullScreen();
		}
		
	}
	
	public void resetGame(boolean restart) {
		
		currentArea = outside;
		player.setDefaultPositions();
		player.restoreStatus();
		player.resetCounter();
		aSetter.setNPC();
		aSetter.setMonster();
		
		
		if(restart == true) {
			player.setDefaultValues();
			aSetter.setObject();
			aSetter.setContactTile();
			eManager.lighting.resetDay();
		}
		
	}
	
	public void setFullScreen() {
		
		// GET LOCAL SCREEN DEVICE
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(Main.window);
		
		// GET FULL SCREEN WIDTH AND HEIGHT
		screenWidth2 = Main.window.getWidth();
		screenHeight2 = Main.window.getHeight();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
		    currentTime = System.nanoTime();
		    
		    delta += (currentTime - lastime) / drawInterval;
		    timer +=(currentTime - lastime);
		    lastime = currentTime;
		    
		    if(delta >= 1) {
		    	update();
		    	drawToTempScreen(); // draw everything to the buffered iamge
		    	drawToScreen(); // draw  the buffered image to the screen
		    	delta--;
		    	drawCount++;
		    }
		    
		    if(timer > 1000000000) {
//		    	System.out.println("FPS:" + drawCount);
		    	drawCount = 0;
		    	timer = 0;
		    }
		}
	}
	
	public void update(){
		
		if(gameState == playState) {
			
			// PLAYER
			player.update();
			
			// NPC
			for(int i = 0; i < npc[1].length; i ++) {
				if(npc[currentMap][i] != null) {
					npc[currentMap][i].update();
				}
			}
			
			// MONSTER
			for(int i = 0; i < monster[1].length; i++) {
				
				if(monster[currentMap][i] != null) {
					if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false) {
						monster[currentMap][i].update();
					}
					
					if(monster[currentMap][i].alive == false) {
						monster[currentMap][i].checkDrop();
						monster[currentMap][i] = null;
					}
				}
			}
			
			// PROJECTILE
			for(int i = 0; i < projectile[1].length; i ++) {
				if(projectile[currentMap][i] != null) {
					
					if(projectile[currentMap][i].alive == true) {
						projectile[currentMap][i].update();
					}
					
					if(projectile[currentMap][i].alive == false) {
						projectile[currentMap][i] = null;
					}
				}
			}
			
			// PARTICLE
			for(int i = 0; i < particleList.size(); i ++) {
				if(particleList.get(i) != null) {
					
					if(particleList.get(i).alive == true) {
						particleList.get(i).update();
					}
					
					if(particleList.get(i).alive == false) {
						particleList.remove(i);
					}
				}
			}
			
			for(int i = 0; i < cTile[1].length; i++) {
				
				if(cTile[currentMap][i] != null) {
					cTile[currentMap][i].update();
				}
			}
			eManager.update();
		if(gameState == pauseState) {
			//nothing
		}
	}
}
	
	public void drawToTempScreen() {
		
		// DEBUG
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		
		// TITLE SCREEN
		if(gameState == titleState) {
			ui.draw(g2);
		}
		
		// MAP SCREEN
		else if(gameState == mapState) {
			map.drawFullMapScreen(g2);
		}
		
		// OTHER
		else {
			
			// TILE
			tileM.draw(g2);
			
			// CONTACT TILE
			for(int i = 0; i < cTile[1].length; i++) {
				if(cTile[currentMap][i] != null) {
					cTile[currentMap][i].draw(g2);
				}
			}
			
			// ADD ENTITIES TO THE LIST
			entityList.add(player);
			
			for(int i = 0; i < npc[1].length; i++) {
				if(npc[currentMap][i] != null) {
					entityList.add(npc[currentMap][i]);
				}
			}
			
			for(int i = 0; i < obj[1].length; i++) {
				if(obj[currentMap][i] != null) {
					entityList.add(obj[currentMap][i]);
				}
			}
			
			for(int i = 0; i < monster[1].length; i++) {
				if(monster[currentMap][i] != null) {
					entityList.add(monster[currentMap][i]);
				}
			}
			
			for(int i = 0; i < projectile[1].length; i++) {
				if(projectile[currentMap][i] != null) {
					entityList.add(projectile[currentMap][i]);
				}
			}
			
			for(int i = 0; i < particleList.size(); i++) {
				if(particleList.get(i) != null) {
					entityList.add(particleList.get(i));
				}
			}
			// SORT
			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					
					int result = Integer.compare(e1.worldX, e2.worldY);
					return 0;
				}
				
			});
			
			// DRAW ENTITIES
			for(int i = 0 ; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			
			// EMPTY ENTITY LIST
			for(int i = 0 ; i < entityList.size(); i++) {
//				entityList.remove(i);
				entityList.clear();
			}
			
			// ENVIRONMENT
			eManager.draw(g2);
			
			// MINI MAP
			map.drawMiniMap(g2);
			
		
			
			//UI
			ui.draw(g2);
		}
		
		// DEBUG
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed , 10, 400);
			g2.drawString("God Mode: " + keyH.godModeOn, 10 ,400);
			System.out.println("Draw Time: " + passed);
		}
	}
		
	public void drawToScreen() {
		
		Graphics g = getGraphics();
		g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
		g.dispose();
	}
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	
	public void stopMusic() {
		
		music.stop();
	}
	
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
	}
	public void changeArea() {
		
		if(nextArea != currentArea) {
		    
			stopMusic();
			
			if(nextArea == outside) {
				playMusic(0);									
			}
			if(nextArea == indoor) {
				playMusic(17);									
			}
			if(nextArea == dungeon) {
				playMusic(18);									
			}
			
			aSetter.setNPC();
		}
		
		currentArea = nextArea;
		aSetter.setMonster();
	}
}
