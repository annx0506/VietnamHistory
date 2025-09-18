package vnhistory.screen.EntityDetailScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vnhistory.entity.Festival;

public class FestivalDetailScreen {
FestivalDetailScreenController controller = new FestivalDetailScreenController();
	
	public Scene getFestivalDetailScene(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FestivalDetail.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
	
	public void setController(Festival festival) {
		controller.setFestival(festival);
	}
}
