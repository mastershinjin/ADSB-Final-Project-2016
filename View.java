

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class View extends Application{
	public static void main(String[] args){
		launch(args);
	}
	public void start(Stage primaryStage){
		primaryStage.setTitle("Uso");
		
		Group root = new Group();
		Scene theScene = new Scene(root);
		primaryStage.setScene(theScene);
		
		Canvas canvas = new Canvas(400, 200);
		
		String path = "USB20FD/CS/musicFiles/sample1";
		Media blah = new Media(new File(path).toURI().toString());
		MediaPlayer player = new MediaPlayer(blah);
		MediaView view = new MediaView(player);
		view.getMediaPlayer().play();
		
;		primaryStage.show();
		
	}
}
