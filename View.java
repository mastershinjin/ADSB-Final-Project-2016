import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class View extends Application 
{
	int points=0;
	int counter=0;
	boolean tf = false;
	
    public static void main(String[] args) 
    {
        launch(args);
        
        /* Displays available fonts in this system, that you can use!
        String fonts[] = 
        	      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        	    for ( int i = 0; i < fonts.length; i++ ){
        	      System.out.println(fonts[i]);}
         */
    }

    @Override
    public void start(Stage theStage) {
    	
    	//The music playing part of the code (it works)
    	theStage.setTitle("Uso!");

    	String musicFile = "Nightcore - Infinity.mp3";     // For example

    	Media sound = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.play();
    
    	//The animation part of the code 
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene( theScene );
        
        
		
        Canvas canvas = new Canvas( 1272, 817 );
        root.getChildren().add( canvas );
        

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Adds background images and buttons to the scene
        Image space = new Image( "usobackground1.jpg" );
        MusicButton b = new MusicButton(196,196);
        MusicButton b1 = new MusicButton(196,196);
        MusicButton b2 = new MusicButton(196,196);
        MusicButton b3 = new MusicButton(196,196);
        MusicButton b4 = new MusicButton(196,196);
        MusicButton b5 = new MusicButton(196,196);
        MusicButton b6 = new MusicButton(196,196);
        MusicButton b7 = new MusicButton(196,196);
        MusicButton b8 = new MusicButton(196,196);
        MusicButton b9 = new MusicButton(196,196);
        MusicButton b10 = new MusicButton(196,196);
        MusicButton b11 = new MusicButton(196,196);
        MusicButton b12 = new MusicButton(196,196);
        MusicButton b13 = new MusicButton(196,196);
        MusicButton b14 = new MusicButton(196,196);
        MusicButton b15 = new MusicButton(196,196);
        MusicButton b16 = new MusicButton(196,196);
        MusicButton b17 = new MusicButton(196,196);
        MusicButton b18 = new MusicButton(196,196);
        MusicButton b19 = new MusicButton(196,196);
        MusicButton b20 = new MusicButton(196,196);
        MusicButton b21 = new MusicButton(196,196);
        MusicButton b22 = new MusicButton(196,196);
        
        List<MusicButton> buttons = new ArrayList<MusicButton>();
        buttons.add(b1);buttons.add(b2);buttons.add(b3);buttons.add(b4);buttons.add(b5);
        buttons.add(b6);buttons.add(b7);buttons.add(b8);buttons.add(b9);buttons.add(b10);
        buttons.add(b11);buttons.add(b12);buttons.add(b13);buttons.add(b14);buttons.add(b15);
        buttons.add(b16);buttons.add(b17);buttons.add(b18);buttons.add(b19);buttons.add(b20);
        buttons.add(b21);buttons.add(b22);
	
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
                
                //draws music buttons according to the time
                gc.drawImage( b.getImage(), x, y);
                if (counter>=180){
                	gc.drawImage( b1.getImage(), y+ 100, x+100);
                }if (counter>=270){
                	gc.drawImage( b2.getImage(), x-100, y+300);
                }if (counter>=350){
                	gc.drawImage( b3.getImage(), x+200, x+300);
                }if (counter>=450){
                    gc.drawImage( b4.getImage(), x+700, x+200);
                }if (counter>=550){
                	gc.drawImage( b5.getImage(), x+150, x+75);
                }if (counter>=620){
                	gc.drawImage( b6.getImage(), x+500, y+200);
                }if (counter>=725){
                	gc.drawImage( b7.getImage(), x+400, y+150);
                }if (counter>=800){
                	gc.drawImage( b8.getImage(), x-100, y-100);
                }if (counter>=950){
                	gc.drawImage( b9.getImage(), x-100, y-100);
                }if (counter>=900){
                	gc.drawImage( b10.getImage(), x+500, y+10);
                }if (counter>=970){
                	gc.drawImage( b11.getImage(), x+800, y+50);
                }if (counter>=1090){
                	gc.drawImage( b12.getImage(), x+250, y+75);
                }if (counter>=1120){
                	gc.drawImage( b13.getImage(), x+700, y-50);
                }if (counter>=1200){
                	gc.drawImage( b14.getImage(), x+310, y+200);
                }if (counter>=1350){
                	gc.drawImage( b15.getImage(), x+650, y+100);
                }if (counter>=1500){
                	gc.drawImage( b16.getImage(), y+100, y+150);
                }if (counter>=1600){
                	gc.drawImage( b17.getImage(), x+300, x+400);
                }if (counter>=1870){
                	gc.drawImage( b18.getImage(), x-50, x-50);
                }
                
                
                
                
                //Makes/draws score guage:
                ScoreGauge sc = new ScoreGauge();
        		
                Rectangle meter = new Rectangle(1200, 30, 30, 200);
                meter.setArcWidth(15);
                meter.setArcHeight(15);
                root.getChildren().add(meter);
                
        		theScene.setOnMouseClicked(
        				new EventHandler<MouseEvent>(){
        					public void handle(MouseEvent e){
        						for (MusicButton button: buttons){
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
        						}
        						//MusicButton next = new MusicButton(196,196); WE PROBABLY DON'T NEED THIS ANYMORE
        						
        					}
        				}
        			);
        		
        	
        		Text fontText = new Text(1170, 23, "SCORE:");
        		fontText.setFont(Font.font ("Script MT Bold", 25));
        		fontText.setFill(Color.MAGENTA);
        		root.getChildren().add(fontText);
        		
        			
        		//Displays black screen and score at end of game
                if (counter>4500){
                	Image black = new Image( "blackBackground.jpg" );
                	gc.drawImage(black, 0, 0);
                	Text lastText = new Text(550, 180, "GAME OVER\n\nYOUR SCORE: \n\n" + points);
            		lastText.setFont(Font.font ("Script MT Bold", 50));
            		lastText.setFill(Color.ROYALBLUE);
            		root.getChildren().add(lastText);
                }
        		
                //Displays counter, for reference:
        		counter++;
        		gc.strokeText("Counter: " + counter, 20, 20);
        		
        		//Displays number of points:
                gc.strokeText("Number of points: " + points, 50, 50);
                
                
            }
        }.start();
		
		
		
        theStage.show();
        
        
    }
}


