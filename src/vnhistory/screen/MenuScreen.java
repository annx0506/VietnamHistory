package vnhistory.screen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuScreen {
	public Scene getMenuScene(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainmenu.fxml"));
		MenuScreenController controller = new MenuScreenController();
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
