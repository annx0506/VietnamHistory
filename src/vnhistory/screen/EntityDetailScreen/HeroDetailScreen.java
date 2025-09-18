package vnhistory.screen.EntityDetailScreen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vnhistory.entity.Hero;

public class HeroDetailScreen {
HeroDetailScreenController controller = new HeroDetailScreenController();
	
	public Scene getHeroDetailScene(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HeroDetail.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
	
	public void setController(Hero hero) {
		controller.setHero(hero);
	}
}
