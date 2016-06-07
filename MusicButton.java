import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MusicButton {
	private final long initialTime;
	private ImageView musicButton;
	private double x;
	private double y;
	private boolean wasPressed;
	
	//Constructors:
	public MusicButton(double xCoordinate, double yCoordinate){
		Image hitButton = new Image("http://www.tsunderepanda.com/TsunderePanda/osu!/Skins/cardcaptor%20sakura/hitcircleselect.png");
		ImageView musicButton = new ImageView(hitButton);
		initialTime = System.nanoTime()/1000000000;
		x = xCoordinate;
		y = yCoordinate;
		wasPressed = false;
	}
	
	
	//methods:
	public long getTime(){
		return initialTime;
	}
	
	public ImageView getImage(){
		return musicButton;
	}
	
	public boolean isAlive(ScoreGauge scoreKeeper){
		if(wasPressed || (System.nanoTime() - initialTime)/1000000000 > 1){
			if(!wasPressed){
				scoreKeeper.playerScore -= 30;
			}
			return false;
		}else{
			return true;
		}
	}
	
}
