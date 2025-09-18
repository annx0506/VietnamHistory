package vnhistory.screen.EntityScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FigureScreen {
	public Scene getFigureScene(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/figure.fxml"));
		FigureScreenController controller = new FigureScreenController();
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
