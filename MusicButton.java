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
	private Image musicButton;
	private boolean wasPressed;
	
	//Constructors:
	public MusicButton(double xCoordinate, double yCoordinate){
		musicButton = new Image("http://www.tsunderepanda.com/TsunderePanda/osu!/Skins/cardcaptor%20sakura/hitcircleselect.png", xCoordinate, yCoordinate, false, false);
		initialTime = System.nanoTime()/1000000000;
		wasPressed = false;
	}
	
	
	//methods:
	public long getTime(){
		return initialTime;
	}
	
	public Image getImage(){
		return musicButton;
	}
	
	public boolean isAlive(ScoreGauge scoreKeeper){
		if(wasPressed || (System.nanoTime() - initialTime)/1000000000 > 1){
			if(!wasPressed){
				//rethink this?
				scoreKeeper.playerScore -= 30;
			}
			return false;
		}else{
			return true;
		}
	}
	
}
