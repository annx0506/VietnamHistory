package vnhistory.screen.EntityScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlaceScreen {
	public Scene getPlaceScene(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Place.fxml"));
		PlaceScreenController controller = new PlaceScreenController();
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
