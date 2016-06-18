import java.awt.Graphics;
import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class View extends Application 
{
	int points=0;
	
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
    	
    	//The music playing part of the code (it works)
    	theStage.setTitle("Uso!");

    	String musicFile = "Nightcore - Infinity.mp3";     // For example

    	Media sound = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.play();
    
    	//The animation part of the code (it works)
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene( theScene );
        
        
		
        Canvas canvas = new Canvas( 1272, 817 );
        root.getChildren().add( canvas );
        

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Adds background images and buttons to the scene
        Image space = new Image( "usobackground1.jpg" );
        MusicButton button = new MusicButton(196,196);
        MusicButton button1 = new MusicButton(196,196);
        MusicButton button2 = new MusicButton(196,196);
        MusicButton button3 = new MusicButton(196,196);
        MusicButton button4 = new MusicButton(196,196);
        MusicButton button5 = new MusicButton(196,196);
        MusicButton button6 = new MusicButton(196,196);
        MusicButton button7 = new MusicButton(196,196);
        MusicButton button8 = new MusicButton(196,196);
        MusicButton button9 = new MusicButton(196,196);
        MusicButton button10 = new MusicButton(196,196);
 
        
		int var1 = points;
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // Clear the canvas
                gc.clearRect(0, 0, 1272,817);

                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                
                gc.drawImage( button.getImage(), x, y);
                
                
                gc.drawImage( button1.getImage(), x+100, y+500);
                
                /*
                gc.drawImage( button2.getImage(), x+525, y+605);
                gc.drawImage( button3.getImage(), x+700, y+1000);
                gc.drawImage( button4.getImage(), x+500, y+90);
                gc.drawImage( button5.getImage(), x-100, y-90);
                gc.drawImage( button6.getImage(), x+700, y+60);
                gc.drawImage( button7.getImage(), x-70, y-100);
                gc.drawImage( button8.getImage(), x+10, y+15);
                gc.drawImage( button9.getImage(), x+3, y+4);
                gc.drawImage( button10.getImage(), x+5, y+11);
                */
                
                
                /*
                for (int i=0; i<100; i++){
                	MusicButton button1 = new MusicButton(Math.random()*1272, Math.random()*817);
                	gc.drawImage(button1.getImage(),  x,  y);
                }
                */
                
                ScoreGauge sc = new ScoreGauge();
        		
                
        		theScene.setOnMouseClicked(
        				new EventHandler<MouseEvent>(){
        					public void handle(MouseEvent e){
        						if(button.hitCircle.contains(e.getX(), e.getY())){
        							if(button.isAlive(sc)){
        								button.disappear();
        								sc.updateScore(10, gc);
        								points+=20;
        							}else{
        								button.disappear();
        								sc.updateScore(-15, gc);
        								points+=20;
        							}
        						}
        						MusicButton next = new MusicButton(100,100);
        						
        					}
        				}
        			);
        		
        		theScene.setOnMouseClicked(
        				new EventHandler<MouseEvent>(){
        					public void handle(MouseEvent e){
        						if(button1.hitCircle.contains(e.getX(), e.getY())){
        							if(button1.isAlive(sc)){
        								button1.disappear();
        								sc.updateScore(10, gc);
        								points+=20;
        							}else{
        								button1.disappear();
        								sc.updateScore(-15, gc);
        								points+=20;
        							}
        						}
        						MusicButton next = new MusicButton(100,100);
        						
        					}
        				}
        			);
        		
        		
               
        			/*
        			Text pointsText = new Text (40, 40, "Number of points: " + points);
            		pointsText.setFont(Font.font ("Verdana", 20));
            		pointsText.setFill(Color.RED);
            		root.getChildren().add(pointsText);
        			root.getChildren().remove(pointsText);
        			*/
        		
                gc.strokeText("Number of points: " + points, 50, 50);
                
            }
        }.start();
		
		
		
        theStage.show();
        
        
    }
}

