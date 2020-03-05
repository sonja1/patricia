package application;

//	import javafx.fxml.FXMLLoader;
//	import java.io.FileInputStream;
//	FXMLLoader loader = new FXMLLoader();
//	root = (VBox)loader.load(new FileInputStream("src/application/RPGDemoView.fxml"));//

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
	static int speed = 5;
	static int eventColor = 0;
	static int eventX = 0;
	static int eventY = 0;
	static int eventX1 = 0;
	static int eventY1 = 0;
	static int eventX2 = 0;
	static int eventY2 = 0;
	static int width = 20;
	static int height = 20;
	static int cornersize = 25;
	static List<Corner>player = new ArrayList<>();
	static Dir direction = Dir.space;
	static boolean eventHappen = false;
	static Random rand = new Random();
	
	
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
						return;
					}
					if (now-lastTick > 1000000000/speed) {
						lastTick = now;
						tick(gc);
						
					}
				}
			}.start();
			
			
			Scene scene = new Scene(root,width*cornersize,height*cornersize);
			
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
				
			} );
			
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
		if (eventHappen) {
		
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 50));
			gc.fillText("Enter Battle",125, 250);
		
			return;
		}
			
		
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
			if(eventX == player.get(0).x && eventY == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX1 == player.get(0).x && eventY1 == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX2 == player.get(0).x && eventY2 == player.get(0).y) {
				eventHappen = true;
			}
			break;
			
		case down:
			player.get(0).y++;
			if(player.get(0).y >= height) {
				player.get(0).y = height-1;
			}
			if(eventX == player.get(0).x && eventY == player.get(0).y) {
				eventHappen = true;	
			}
			if(eventX1 == player.get(0).x && eventY1 == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX2 == player.get(0).x && eventY2 == player.get(0).y) {
				eventHappen = true;
			}
			break;
			
		case left:
			player.get(0).x--;
			if(player.get(0).x < 0) {
				player.get(0).x = 0;
			}
			if(eventX == player.get(0).x && eventY == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX1 == player.get(0).x && eventY1 == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX2 == player.get(0).x && eventY2 == player.get(0).y) {
				eventHappen = true;
			}
			break;
			
		case right:
			player.get(0).x++;
			if(player.get(0).x >= width) {
				player.get(0).x = width-1;
			}
			if(eventX == player.get(0).x && eventY == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX1 == player.get(0).x && eventY1 == player.get(0).y) {
				eventHappen = true;
			}
			if(eventX2 == player.get(0).x && eventY2 == player.get(0).y) {
				eventHappen = true;
			}
			break;
			
		default:
			break;
		}
		
		
		//background color
		gc.setFill(Color.WHITE);
		gc.fillRect(0,0,width*cornersize, height*cornersize);
		
		//stat display
		gc.setFill(Color.GREEN);
		gc.setFont(new Font("",20));
		gc.fillText("HP:", 20,30,30);
		gc.fillText("Attk:",20,50,30);
		gc.fillText("Def:", 20,70,30);
		
		//random evenColor
		Color ec = Color.WHITE;
		
		switch(eventColor) {
	
		case 0: ec = Color.LIGHTGREEN;
		break;
		case 1: ec = Color.YELLOW;
		break;
		case 2: ec = Color.PURPLE;
		break;
		case 3: ec = Color.ORANGE;
		break;
		case 4: ec = Color.RED;
		break;
	
		}
		gc.setFill(ec);
		
		gc.fillOval(eventX*cornersize,eventY*cornersize,cornersize,cornersize);
		gc.fillOval(eventX1*cornersize,eventY1*cornersize,cornersize,cornersize);
		gc.fillOval(eventX2*cornersize,eventY2*cornersize,cornersize,cornersize);
		
		//put player on map
		for (Corner c:player) {
			gc.setFill(Color.BLUE);
			gc.fillRect(c.x*cornersize,c.y*cornersize,cornersize-1,cornersize-1);
			gc.setFill(Color.LIGHTBLUE);
			gc.fillRect(c.x*cornersize,c.y*cornersize,cornersize-1,cornersize-1);
		}
	}

	
	//events
	public static void newEvent() {
		start: while(true) {
			eventX = rand.nextInt(width);
			eventY = rand.nextInt(height);
			
			eventX1 = rand.nextInt(width);
			eventY1 = rand.nextInt(height);
			
			eventX2 = rand.nextInt(width);
			eventY2 = rand.nextInt(height);
			
			
			for (Corner c: player){
				if(c.x == eventX && c.y == eventY) {
					continue start;
				}
				if(c.x == eventX1 && c.y == eventY1) {
					continue start;
				
				}
				if(c.x == eventX2 && c.y == eventY2) {
					continue start;
				}
			}
			eventColor = rand.nextInt(5);
			break;
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
