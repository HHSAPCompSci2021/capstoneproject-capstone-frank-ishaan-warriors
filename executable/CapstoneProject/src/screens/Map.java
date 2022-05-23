package screens;

import main.*;
import processing.core.PImage;
import characters.*;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Map extends Screen
{
		
		private DrawingSurface surface;
		private Rectangle screenRect;
		private Mario a;
		private Bob b;
		private List<Sprite> obstacles;
		private int aTime = 0, bTime = 0;
		private boolean aSpecial = false, bSpecial = false;
		private int aUse = 3, bUse = 3;
		private Weapon c;
		private HealthBoost d;
		private HealthBoost d2;
		private HealthBoost d3;
		private int bobHurt = 0, marioHurt = 0;
		private boolean bobRed = false, marioRed = false;
		private int marioRecoveryRate=0;
		private int bobRecoveryRate=0;		
		
		public Map(DrawingSurface surface) {
			super(2000, 2000);
			this.surface = surface;
			screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
			obstacles = new ArrayList<Sprite>();
		}
		
		public void spawnNewBob(int x, int y, int h) 
		{
			b = new Bob(surface.loadImage("image/bobFight.png"),x,y,h);
		}
		
		public void spawnNewBob(int x, int y, int h,String img) 
		{
			b = new Bob(surface.loadImage(img),x,y,h);
		}
		
		public void spawnNewMario(int x, int y, int h) 
		{
			a = new Mario(surface.loadImage("image/marioFight.png"),x,y, h);
		}
		
		public void spawnNewMario(int x, int y, int h,String img) 
		{
			a = new Mario(surface.loadImage(img),x,y,h);
		}
		public void spawnWeapon(int x, int y) {
			c = new Weapon(surface.loadImage("image/taswer.png"), x, y, 1000);
		}
		public void spawnNewHealth() {
			d = new HealthBoost(surface.loadImage("image/health2.PNG"), 200 + (int)(Math.random() * 1600), 200 +(int)(Math.random() * 1600), 1000);
		}

		// The statements in the setup() function 
		// execute once when the program begins
		public void setup() 
		{
			spawnNewMario(500, 250, 1000,"image/marioIdle.png");
			spawnNewBob(100, 250, 1000,"image/marioIdle.png");
		}

		// The statements in draw() are executed until the 
		// program is stopped. Each statement is executed in 
		// sequence and after the last line is read, the first 
		// line is executed again.
		public void draw() {
			PImage img;
			img = surface.loadImage("image/ab.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
			// drawing stuff
			if (c == null)
			{spawnWeapon(950, 970);}
			if (a == null) 
			{
				spawnNewMario(500, 250, 1000,"image/marioFight.png");
		    }
			
			if (b == null) 
			{
				spawnNewBob(100, 250, 1000,"image/bobFight.png");
			}
			
			if (d == null) {
				spawnNewHealth();
			}
			surface.fill(0);
			surface.rect(165,0, 300, 200, 10, 10, 10, 10);
   			//To print health of first player

			Integer h1 = b.getHealth();
			String str = h1.toString();
			surface.fill(4, 150, 7);
			surface.textSize(100);
			surface.text(str, 185, 137);
			
   			//To print health of second player
			surface.fill(0);
			surface.rect(2000 - 165-300 - 20,0, 300, 200, 10, 10, 10, 10);
			Integer h2 = a.getHealth();
			String str2 = h2.toString();
			surface.fill(4, 150, 7);
			surface.textSize(100);
			surface.text(str2, 1000 + 500 + 50, 137);
			if (aSpecial) {
			    aTime++;
			    if (aTime == 200) {
			    	spawnNewMario((int)a.getX(), (int)a.getY(), a.getHealth());
			    	aSpecial = false;
			    	aUse--;
			    }
			}
			if (bSpecial) {
			    bTime++;
			    if (bTime == 200) {
			    	spawnNewBob((int)b.getX(), (int)b.getY(), b.getHealth());
			    	bSpecial = false;
			    	bUse--;
			    }
			}
			a.draw(surface);
			b.draw(surface);
			d.draw(surface);
			if (a.getHealth() < 500 || b.getHealth() < 500) 
			{
				c.draw(surface);
		    }
			
			if (a.getHealth() < 500 || b.getHealth() < 500) {
				if (d2 == null) {
				    d2 = new HealthBoost(surface.loadImage("image/health2.PNG"), 200 + (int)(Math.random() * 1600), 200 +(int)(Math.random() * 1600), 1000);
				}
				d2.draw(surface);
			}
			
			if (a.getHealth() < 100 || b.getHealth() < 100) {
				if (d3 == null) {
				    d3 = new HealthBoost(surface.loadImage("image/health2.PNG"), 200 + (int)(Math.random() * 1600), 200 +(int)(Math.random() * 1600), 1000);
				}
				d3.draw(surface);
			}
			if(marioRed && !bSpecial)
			{
				marioHurt++;
				if(marioHurt == 100)
				{
					spawnNewMario((int)a.getX(), (int)a.getY(), a.getHealth(),"image/marioFight.png");
				}
			}
			if(bobRed && !aSpecial)
			{
				bobHurt++;
				if(bobHurt == 100)
				{
					spawnNewBob((int)b.getX(), (int)b.getY(), b.getHealth(),"image/bobFight.png");
				}
			}
			a.draw(surface);
			b.draw(surface);
			if (surface.isPressed(KeyEvent.VK_UP)) 
			{
				b.up();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			
			if (surface.isPressed(KeyEvent.VK_DOWN)) 
			{
				b.down();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			
			if (surface.isPressed(KeyEvent.VK_RIGHT))
			{
				b.right();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			
			if (surface.isPressed(KeyEvent.VK_LEFT)) 
			{
				b.left();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			
			if (surface.isPressed(KeyEvent.VK_W)) 
			{
		
				a.up();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			if (surface.isPressed(KeyEvent.VK_A))
			{
				a.left();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			if (surface.isPressed(KeyEvent.VK_S)) 
			{
				a.down();
				marioRecoveryRate++;
				bobRecoveryRate++;
			}
			if (surface.isPressed(KeyEvent.VK_D)) 
			{
				a.right();
				marioRecoveryRate++;
				bobRecoveryRate++;				  
			}
			if (surface.mousePressed && a.getW()) {
				c.shoot(surface, surface.mouseX *2.5, surface.mouseY * 3.333333333333333333333333333333333333333333333333333333333333333333333333333333, a, b);
				if(b.getHealth()<0)
				{
					spawnWeapon(950, 970);
					spawnNewMario(500, 250, 1000);
					spawnNewBob(100, 250,1000);
					a.setHealth(1000);
					b.setHealth(1000);
					a.setW(false);
					b.setW(false);
					aTime = 0;
					bTime = 0;
					aSpecial = false;
					bSpecial = false;
					aUse = 3;
					bUse = 3;
					surface.switchScreen(4);
					
				}
			}
			if (surface.mousePressed && b.getW()) {
				c.shoot(surface, surface.mouseX *2.5, surface.mouseY * 3.333333333333333333333333333333333333333333333333333333333333333333333333333333, b, a);
				if(a.getHealth()<0)
				{
					spawnWeapon(950, 970);
					spawnNewMario(500, 250, 1000);
					spawnNewBob(100, 250,1000);
					a.setHealth(1000);
					b.setHealth(1000);
					a.setW(false);
					b.setW(false);
					aTime = 0;
					bTime = 0;
					aSpecial = false;
					bSpecial = false;
					aUse = 3;
					bUse = 3;
					surface.switchScreen(3);
					
				}
			}

			if (surface.isPressed(KeyEvent.VK_E) && !aSpecial && aUse > 0) 
			{
				
				a.special(surface);
				aTime = 0;
				aSpecial = true;
			}
			
			if (surface.isPressed(KeyEvent.VK_SHIFT) && !bSpecial && bUse > 0) 
			{
				b.special(surface);
				bTime = 0;
				bSpecial = true;
			}
			if (surface.isPressed(KeyEvent.VK_CONTROL))
			{
		  			if (a.intersects(b)) {
						marioRecoveryRate=0;
						marioRed = true;
						if (!aSpecial) {
							spawnNewMario((int)a.getX(), (int)a.getY(), a.getHealth(),"image/marioHurt.png");
							b.attack(a);
						}
		  			}
		  			
					if (b.intersects(c)) {
						b.attack(c);
					}
					
					if (b.intersects(d)) {
						b.attack(d);
					}
					
					if(a.getHealth() >0 && a.getHealth() <=2)
					{
						spawnNewMario((int)a.getX(), (int)a.getY(), a.getHealth(),"image/marioDeath.png");
					}
					
					if(a.getHealth()<0)
					{
						spawnWeapon(950, 970);
						spawnNewMario(500, 250, 1000);
						spawnNewBob(100, 250,1000);
						a.setHealth(1000);
						b.setHealth(1000);
						a.setW(false);
						b.setW(false);
						aTime = 0;
						bTime = 0;
						aSpecial = false;
						bSpecial = false;
						aUse = 3;
						bUse = 3;
						surface.switchScreen(3);
						
					}
			}
			
			if (surface.isPressed(KeyEvent.VK_Q))
			{
					if(a.intersects(b) || b.intersects(a))
					{
						bobRecoveryRate=0;
						bobRed = true;
						if (!bSpecial) {
							spawnNewBob((int)b.getX(), (int)b.getY(), b.getHealth(),"image/bobHurt.png");
							a.attack(b);
						}
					}
					
					if (a.intersects(c)) {
						a.attack(c);
					}
					
					if (a.intersects(d)) {
						a.attack(d);
					}
					
					if(b.getHealth() >0 && b.getHealth() <=2)
					{
						spawnNewBob((int)b.getX(), (int)b.getY(), b.getHealth(),"image/bobDeath.png");
					}
										
					if(b.getHealth()<=0)
					{
						spawnWeapon(950, 970);
						spawnNewMario(500, 250, 1000);
						spawnNewBob(100, 250,1000);
						a.setHealth(1000);
						b.setHealth(1000);
						a.setW(false);
						b.setW(false);
						aTime = 0;
						bTime = 0;
						aSpecial = false;
						bSpecial = false;
						aUse = 3;
						bUse = 3;
						surface.switchScreen(4);
					}
			}							
		}
}