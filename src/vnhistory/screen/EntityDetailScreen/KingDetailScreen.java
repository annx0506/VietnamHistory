package vnhistory.screen.EntityDetailScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vnhistory.entity.King;

public class KingDetailScreen {
	KingDetailScreenController controller = new KingDetailScreenController();
	
	public Scene getKingDetailScene(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/kingDetail.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
	
	public void setController(King king) {
		controller.setKing(king);
	}
}
