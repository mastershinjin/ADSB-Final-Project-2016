import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UsoGameView extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	
	public void start(Stage theStage) throws Exception {
		Group root = new Group();
		Scene gameScene = new Scene(root);
		theStage.setScene(gameScene);
		
		Canvas canvas = new Canvas(1000,1000);
		
		root.getChildren().add(canvas);
		
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		MusicButton test = new MusicButton(100,100);
		
		ScoreGauge sc = new ScoreGauge();
		
		gameScene.setOnMouseClicked(
				new EventHandler<MouseEvent>(){
					public void handle(MouseEvent e){
						if(test.hitCircle.contains(e.getX(), e.getY())){
							if(test.isAlive(sc)){
								test.disappear();
								sc.updateScore(10, gc);
							}else{
								test.disappear();
								sc.updateScore(-15, gc);
							}
						}
						MusicButton next = new MusicButton(100,100);
						
					}
				}
			);
		
		
		
		new AnimationTimer(){
			public void handle(long currentNanoTime){
				// Clear the canvas
	            gc.setFill( new Color(0.85, 0.85, 1.0, 1.0) );
	            gc.fillRect(0,0, 512,512);
	            gc.drawImage(test.getImage(), 100, 100);
			}
		}.start();
		
		
		theStage.show();
		
	}

}
