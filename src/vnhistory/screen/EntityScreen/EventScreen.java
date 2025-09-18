package vnhistory.screen.EntityScreen;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventScreen {
	public Scene getEventScene(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Event.fxml"));
		EventScreenController controller = new EventScreenController();
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
