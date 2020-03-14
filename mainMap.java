package application;

//	import java.io.FileInputStream;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class mainMap extends Application {
	private static int speed = 5;
	private static ArrayList<int[]> battle = new ArrayList<int[]>();
	private static ArrayList<int[]> itemDrop = new ArrayList<int[]>();
	private static ArrayList<int[]> healSpot = new ArrayList<int[]>();
	private static int width = 36;
	private static int height = 24;
	private static int cornersize = 25;
	private static List<Corner>player = new ArrayList<>();
	private static Dir direction = Dir.space;
	private static boolean battleHappen = false;
	private static boolean foundItem = false;
	private static boolean healPlayer = false;
	private static Random rand = new Random();
	private static Scene scene;
	
	
	public enum Dir{
		up, down, left, right, space
	}
	
	
	public static class Corner{
		int x;
		int y;
		
		public Corner(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
		
	
	@Override
	public void start(Stage primaryStage) {
		try {
			newEvent();
			VBox root = new VBox();
			Canvas c = new Canvas(width*cornersize, height*cornersize);
			GraphicsContext gc = c.getGraphicsContext2D();
			
			root.getChildren().add(c);
			
			new AnimationTimer() {
				long lastTick = 0;
				
				public void handle(long now) {
					if (lastTick == 0) {
						lastTick = now;
						tick(gc);
					//	return;
					}
					if (now-lastTick > 500000000/speed) {
						lastTick = now;
						tick(gc);				
					}
				}
			}.start();
			
			
			scene = new Scene(root,width*cornersize,height*cornersize);
			
			//controls
			scene.addEventFilter(KeyEvent.KEY_PRESSED,key ->{
				if (key.getCode() == KeyCode.SPACE) {
					direction = Dir.space;
				}
				if (key.getCode() == KeyCode.UP) {
					direction = Dir.up;
				}
				if (key.getCode() == KeyCode.DOWN) {
					direction = Dir.down;
				}
				if (key.getCode() == KeyCode.LEFT) {
					direction = Dir.left;
				}
				if (key.getCode() == KeyCode.RIGHT) {
					direction = Dir.right;
				}
			});
			
			scene.addEventFilter(KeyEvent.KEY_RELEASED, key ->{
				direction = Dir.space;
			});
			
			//add starting player into map
			player.add(new Corner(width/2, height/2));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dummy RPG");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//tick
	public static void tick (GraphicsContext gc) {
	
		for (int i = player.size()-1; i >=1; i--) {
			player.get(i).x = player.get(i-1).x;
			player.get(i).y = player.get(i-1).y;
		}
		
		//check collision for the events
		
		switch(direction) {
		case up:
			player.get(0).y--;
			if(player.get(0).y < 0) {
				player.get(0).y = 0;
			}
			for(int[] e:battle) {
				if(e[0] == player.get(0).x && e[1] == player.get(0).y) {
					battleHappen = true;
				}
			}
			
			for(int[] i:itemDrop) {
				if(i[0] == player.get(0).x && i[1] == player.get(0).y) {
					foundItem = true;
				}
			}
			
			for (int [] h:healSpot) {
				if(h[0] == player.get(0).x && h[1] == player.get(0).y) {
					healPlayer = true;
				}
			}
			break;
		
			
		case down:
			player.get(0).y++;
			if(player.get(0).y >= height) {
				player.get(0).y = height - 1;
			}
			for(int[] e:battle) {
				if(e[0] == player.get(0).x && e[1] == player.get(0).y) {
					battleHappen = true;
				}
			}
			
			for(int[] i:itemDrop) {
				if(i[0] == player.get(0).x && i[1] == player.get(0).y) {
					foundItem = true;
				}
			}
			
			for (int [] h:healSpot) {
				if(h[0] == player.get(0).x && h[1] == player.get(0).y) {
					healPlayer = true;
				}
			}
			break;
			
		case left:
			player.get(0).x--;
			if(player.get(0).x < 0) {
				player.get(0).x = 0;
			}
			for(int[] e:battle) {
				if(e[0] == player.get(0).x && e[1] == player.get(0).y) {
					battleHappen = true;
				}
			}
			
			for(int[] i:itemDrop) {
				if(i[0] == player.get(0).x && i[1] == player.get(0).y) {
					foundItem = true;
				}
			}
			
			for (int [] h:healSpot) {
				if(h[0] == player.get(0).x && h[1] == player.get(0).y) {
					healPlayer = true;
				}
			}
			break;
			
		case right:
			player.get(0).x++;
			if(player.get(0).x >= width) {
				player.get(0).x = width - 1;
			}
			for(int[] e:battle) {
				if(e[0] == player.get(0).x && e[1] == player.get(0).y) {
					battleHappen = true;
				}
			}
			
			for(int[] i:itemDrop) {
				if(i[0] == player.get(0).x && i[1] == player.get(0).y) {
					foundItem = true;
				}
			}
			
			for (int [] h:healSpot) {
				if(h[0] == player.get(0).x && h[1] == player.get(0).y) {
					healPlayer = true;
				}
			}
			break;
			
		default:
			break;
		}
		
		
		//background color
		gc.setFill(Color.GREY);
		gc.fillRect(0,0,width*cornersize, height*cornersize);

		
		//event colors
		Color ec = Color.WHITE;
	
		for(int[] e:battle) {
			gc.setFill(Color.RED);
			gc.fillOval(e[0]*cornersize,e[1]*cornersize,cornersize,cornersize);
		}
		
		for(int[] i:itemDrop) {
			gc.setFill(Color.YELLOW);
			gc.fillOval(i[0]*cornersize,i[1]*cornersize,cornersize,cornersize);
		}
		
		for (int[] h:healSpot) {
			gc.setFill(Color.LIGHTGREEN);
			gc.fillOval(h[0]*cornersize, h[1]*cornersize, cornersize, cornersize);
		}
		
		ec = Color.WHITE;
		gc.setFill(ec);
		
		
		
		//put player on map
		for (Corner c:player) {
			
		/*	Image ch = new Image ("file:image0.png");
			ImageView mv = new ImageView(ch);
			
			mv.setImage(ch);
		*/
			gc.setFill(Color.BLUE);
			gc.fillRect(c.x*cornersize,c.y*cornersize,cornersize-1,cornersize-1);
			gc.setFill(Color.LIGHTBLUE);
			gc.fillRect(c.x*cornersize,c.y*cornersize,cornersize-1,cornersize-1);
			
			
			//stat display
			gc.setFill(Color.DARKGREEN);
			gc.setFont(new Font("",20));
			gc.fillText("HP: 100/100", 20,30);
			gc.fillText("Attk:15",20,50);
			gc.fillText("Def:10", 20,70);
			
		/*	gc.setFill(Color.LIGHTBLUE);
			gc.setFont(new Font("",20));
			gc.fillText("Player : Dummy", 380, 30,80);
			gc.fillText("Press i for inventory", 380, 50,100);
		*/	
		}

		if (battleHappen) {
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 70));
			gc.fillText("Enter Battle",290, 300);
			scene.addEventFilter(KeyEvent.KEY_PRESSED, key ->{
				battleHappen = false;
				for (int[] e:battle) {
					if (e[0] == player.get(0).x && e[1] == player.get(0).y) {
						battle.remove(e);
						battle.add(new int[] {rand.nextInt(width),rand.nextInt(height)});
					}
				}
			});
		}
		
		if (foundItem) {
			gc.setFill(Color.YELLOW);
			gc.setFont(new Font("", 50));
			gc.fillText("You've found an item!",210, 300);
			scene.addEventFilter(KeyEvent.KEY_PRESSED, key ->{
				foundItem = false;
				for (int[] i:itemDrop) {
					if (i[0] == player.get(0).x && i[1] == player.get(0).y) {
						itemDrop.remove(i);
						itemDrop.add(new int[] {rand.nextInt(width),rand.nextInt(height)});
					}
				}
			});
		}
		
		if (healPlayer) {
			gc.setFill(Color.LIGHTGREEN);
			gc.setFont(new Font("", 50));
			gc.fillText("Recovered to full health!", 200, 300);
			scene.addEventFilter(KeyEvent.KEY_PRESSED, key ->{
				healPlayer = false;
				for (int[] h:healSpot) {
					if (h[0] == player.get(0).x && h[1] == player.get(0).y) {
						healSpot.remove(h);
						healSpot.add(new int[] {rand.nextInt(width), rand.nextInt(height)});
					}
				}
			});
			
		}
	}

	
	//events
	public static void newEvent() {
		for (int i = 0; i < 10; i++) {
			int[] enemy = new int[2];
			enemy[0] = rand.nextInt(width);
			enemy[1] = rand.nextInt(height);
			battle.add(enemy);
		}
		
		for (int i = 0; i < 4; i++) {
			int[] item = new int[2];
			item[0] = rand.nextInt(width);
			item[1] = rand.nextInt(height);
			itemDrop.add(item);
		}
		
		for (int i = 0; i < 3;i++) {
			int[] heal = new int[2];
			heal[0] = rand.nextInt(width);
			heal[1] = rand.nextInt(height);
			healSpot.add(heal);
		}
		
		start: while(true) {
			for (Corner c: player) {
				for (int[] e:battle) {
					if(c.x == e[0] && c.y == e[1]) {
						continue start;
					}
				}
			}
			for (Corner c: player) {
				for (int[] i:itemDrop) {
					if(c.x == i[0] && c.y == i[1]) {
						continue start;
					}
				}
			}
			for (Corner c:player) {
				for (int [] h:healSpot) {
					if(c.x == h[0] && c.y == h[1]) {
						continue start;
					}
				}
			}
			break;
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
