import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class ScoreGauge {
	static int playerScore;
	private Rectangle meter;
	
	public ScoreGauge(){
		playerScore = 0;
		meter = new Rectangle(200, 1000);
	}
	
	//we need a updates method to update the animation for ScoreGauge... (get a rectangle, gradually fill it up).
	
	public void updateScore(int scoreChange, GraphicsContext gc){
		gc.setFill(Color.ROYALBLUE);
		gc.setStroke(Color.BLACK);
		//fill the rectangle as playerScore increases:
		gc.strokeRect(meter.getX(), meter.getY(), meter.getWidth() ,meter.getHeight());
		gc.fillRect(meter.getX(), meter.getY(), playerScore, meter.getHeight());
	}
	
}
