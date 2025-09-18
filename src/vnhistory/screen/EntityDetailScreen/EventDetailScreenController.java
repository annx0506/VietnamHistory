package vnhistory.screen.EntityDetailScreen;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vnhistory.screen.EntityScreen.EventScreen;

public class EventDetailScreenController {
	


	    @FXML
	    private Label diaDiemF;

	    @FXML
	    private Label thamChienF;

	    @FXML
	    private Label nguyenNhanF;

	    @FXML
	    private Label chiHuyF;

	    @FXML
	    private Label lucLuongF;

	    @FXML
	    private Label tonThatF;

	    @FXML
	    private Label ketQuaF;

	    @FXML
	    private Label tenF;

	    @FXML
	    private Label thoiGianF;
	    void setEvent(vnhistory.entity.Event event) {
			tenF.setText(event.getTen());
			diaDiemF.setText(event.getDiaDiem());
			thamChienF.setText(event.getThamChien());
			nguyenNhanF.setText(event.getNguyenNhan());
			chiHuyF.setText(event.getChiHuy());
			lucLuongF.setText(event.getLucLuong());
			tonThatF.setText(event.getTonThat());
			ketQuaF.setText(event.getKetQua());
			thoiGianF.setText(event.getThoiGian());
		}

	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new EventScreen().getEventScene(stage));
	    }

	}


