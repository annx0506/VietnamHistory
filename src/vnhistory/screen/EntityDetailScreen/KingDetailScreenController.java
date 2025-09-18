package vnhistory.screen.EntityDetailScreen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vnhistory.entity.King;
import vnhistory.screen.EntityScreen.FigureScreen;

public class KingDetailScreenController {
	@FXML
	private Label triViF;

	@FXML
	private Label anNghiF;

	@FXML
	private Label trieuDaiF;

	@FXML
	private Label chaF;

	@FXML
	private Label namMatF;

	@FXML
	private Label namSinhF;

	@FXML
	private Label tienNhiemF;

	@FXML
	private Label keNhiemF;

	@FXML
	private Label tenF;

	@FXML
	private Label meF;

	void setKing(King king) {
		tenF.setText(king.getTen());
		namSinhF.setText(king.getNgaySinh());
		namMatF.setText(king.getNgayMat());
		chaF.setText(king.getCha());
		meF.setText(king.getMe());
		tienNhiemF.setText(king.getTienNhiem());
		keNhiemF.setText(king.getKeNhiem());
		trieuDaiF.setText(king.getTrieuDai());
		triViF.setText(king.getThoiGianTriVi());
		anNghiF.setText(king.getNoiAnNghi());
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new FigureScreen().getFigureScene(stage));
	}

}
