package vnhistory.screen.EntityScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DynastyScreen {
	public Scene getDynastyScene(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dynasty.fxml"));
		DynastyScreenController controller = new DynastyScreenController();
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
