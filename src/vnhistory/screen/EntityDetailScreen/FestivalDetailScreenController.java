package vnhistory.screen.EntityDetailScreen;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vnhistory.entity.Festival;
import vnhistory.screen.EntityScreen.FestivalScreen;
public class FestivalDetailScreenController {
	

	    @FXML
	    private Label lanDauF;

	    @FXML
	    private Label nhanVatF;

	    @FXML
	    private Label diaDiemF;

	    @FXML
	    private Label batDauF;

	    @FXML
	    private Label tenF;

	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new FestivalScreen().getFestivalScene(stage));
	    }
	    void setFestival(Festival festival) {
			tenF.setText(festival.getTen());
			lanDauF.setText(festival.getLanDau());
			nhanVatF.setText(festival.getNhanVat());
			diaDiemF.setText(festival.getDiaDiem());
			batDauF.setText(festival.getBatDau());
		}

	}


