package vnhistory.screen.EntityDetailScreen;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vnhistory.entity.Dynasty;
import vnhistory.screen.EntityScreen.DynastyScreen;
public class DynastyDetailScreenController {
	
	
	    @FXML
	    private Label ngonNguF;

	    @FXML
	    private Label chinhPhuF;

	    @FXML
	    private Label viTheF;

	    @FXML
	    private Label tinhTrangF;

	    @FXML
	    private Label tienTeF;

	    @FXML
	    private Label tonGiaoF;

	    @FXML
	    private Label thuDoF;

	    @FXML
	    private Label tenF;
	    void setDynasty(Dynasty dynatsy) {
			tenF.setText(dynatsy.getTen());
			ngonNguF.setText(dynatsy.getNgonNgu());
			chinhPhuF.setText(dynatsy.getChinhPhu());
			viTheF.setText(dynatsy.getViThe());
			tinhTrangF.setText(dynatsy.getTinhTrang());
			tienTeF.setText(dynatsy.getTienTe());
			tonGiaoF.setText(dynatsy.getTonGiao());
			thuDoF.setText(dynatsy.getThuDo());
		}
	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new DynastyScreen().getDynastyScene(stage));
	    }

	}


