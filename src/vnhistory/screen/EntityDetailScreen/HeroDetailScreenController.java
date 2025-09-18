package vnhistory.screen.EntityDetailScreen;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vnhistory.entity.Hero;
import vnhistory.screen.EntityScreen.FigureScreen;
public class HeroDetailScreenController {


	    @FXML
	    private Label trieuDaiF;

	    @FXML
	    private Label tenKhacF;

	    @FXML
	    private Label tinhThanhF;

	    @FXML
	    private Label tenF;

	    @FXML
	    private Label ngaySinhF;
	    void setHero(Hero hero) {
			tenF.setText(hero.getTen());
			trieuDaiF.setText(hero.getTrieuDai());
			tenKhacF.setText(hero.getTenKhac());
			tinhThanhF.setText(hero.getTinhThanh());
			ngaySinhF.setText(hero.getNgaySinh());
		}
	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new FigureScreen().getFigureScene(stage));
	}

}
