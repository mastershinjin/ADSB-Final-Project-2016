import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MusicButton {
	private final long initialTime = System.nanoTime()/1000000000;
	private Image musicButton;
	private double width;
	private double height;
	private boolean wasPressed;
	
	//methods:
	
	public void update(double time){
		long currTime = System.nanoTime()/1000000000;
		if(currTime - initialTime > 3){
			wasPressed = false;
			ScoreGauge.playerScore -= 150;
		}
	}
	
}
