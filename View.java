import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
import javafx.scene.image.Image;

public class View extends Application 
{
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

        Image earth = new Image( "earth.png" );
        Image space = new Image( "usobackground1.jpg" );
        MusicButton button = new MusicButton(196,196);
 

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
                gc.drawImage( earth, x, y );
                gc.drawImage( button.getImage(), 196, 196);
            }
        }.start();
		
		
		
        theStage.show();
        
        
    }
}

