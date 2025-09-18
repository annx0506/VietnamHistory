package vnhistory.screen.EntityScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FestivalScreen {
	public Scene getFestivalScene(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Festival.fxml"));
		FestivalScreenController controller = new FestivalScreenController();
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
