package vnhistory.screen.EntityDetailScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vnhistory.entity.Event;

public class EventDetailScreen {
    EventDetailScreenController controller = new EventDetailScreenController();
	
	public Scene getEventDetailScene(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EventDetail.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
	
	public void setController(Event event) {
		controller.setEvent(event);
	}
}
