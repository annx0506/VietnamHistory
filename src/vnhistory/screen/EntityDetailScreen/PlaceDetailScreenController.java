package vnhistory.screen.EntityDetailScreen;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vnhistory.entity.Place;
import vnhistory.screen.EntityScreen.PlaceScreen;
public class PlaceDetailScreenController {
	

	

	    @FXML
	    private Label leHoiF;

	    @FXML
	    private Label thanhLapF;

	    @FXML
	    private Label diaChiF;

	    @FXML
	    private Label nguoiLapF;

	    @FXML
	    private Label congTrangF;

	    @FXML
	    private Label tenF;
	    void setPlace(Place place) {
			tenF.setText(place.getTen());
			leHoiF.setText(place.getLeHoi());
			thanhLapF.setText(place.getThanhLap());
			diaChiF.setText(place.getDiaChi());
			nguoiLapF.setText(place.getNguoiLap());
			congTrangF.setText(place.getCongTrang());
		}
	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new PlaceScreen().getPlaceScene(stage));
	    }

	}


