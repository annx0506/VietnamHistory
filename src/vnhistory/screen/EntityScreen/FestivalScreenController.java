package vnhistory.screen.EntityScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import vnhistory.VNHistory;
import vnhistory.entity.Festival;
import vnhistory.screen.MenuScreen;
import vnhistory.screen.EntityDetailScreen.FestivalDetailScreen;

public class FestivalScreenController implements Initializable{

	@FXML
	private TextField searchText;

	@FXML
	private TableColumn<Festival, String> nameCol;

	@FXML
	private TableColumn<Festival, String> adressCol;

	@FXML
	private TableView<Festival> table;
	private ObservableList<Festival> festivalList;
	private List<Festival> festivalArrayList = new ArrayList<>();

	@FXML
	void searchFestival(ActionEvent event) {
		List<Festival> subList = new ArrayList<>();
		String searchName = searchText.getText();
		for (Festival i : festivalArrayList) {
			if (i.getTen().contains(searchName))
				subList.add(i);
		}
		ObservableList<Festival> subOList = FXCollections.observableArrayList(subList);
		table.setItems(subOList);
	}

	@FXML
	void exit(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new MenuScreen().getMenuScene(stage));
	}

	@FXML
	void detail(ActionEvent event) throws IOException {
		Festival festival = table.getSelectionModel().getSelectedItem();
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Festival");
        FestivalDetailScreen screen = new FestivalDetailScreen();
        stage.setScene(screen.getFestivalDetailScene(stage));
        screen.setController(festival);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		festivalArrayList = VNHistory.festivalstore.getEntityList();
		festivalList = FXCollections.observableArrayList(festivalArrayList);
		nameCol.setCellValueFactory(new PropertyValueFactory<Festival, String>("ten"));
		adressCol.setCellValueFactory(new PropertyValueFactory<Festival, String>("diaDiem"));
		table.setItems(festivalList);
	}

}
