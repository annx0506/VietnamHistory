package vnhistory.screen.EntityDetailScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vnhistory.entity.Place;

public class PlaceDetailScreen {
PlaceDetailScreenController controller = new PlaceDetailScreenController();
	
	public Scene getPlaceDetailScene(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlaceDetail.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
	
	public void setController(Place place) {
		controller.setPlace(place);
	}
}
