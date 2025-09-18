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
import vnhistory.entity.Place;
import vnhistory.screen.MenuScreen;
import vnhistory.screen.EntityDetailScreen.PlaceDetailScreen;
public class PlaceScreenController implements Initializable {


	    @FXML
	    private TextField searchText;

	    @FXML
	    private TableColumn<Place, String> nameCol;

	    @FXML
	    private TableColumn<Place, String> adressCol;

	    @FXML
	    private TableView<Place> table;
	    private ObservableList<Place> placeList;
	    private List<Place> placeArrayList = new ArrayList<>();

	    @FXML
	    void searchPlace(ActionEvent event) {
	    	List<Place> subList = new ArrayList<>();
			String searchName = searchText.getText();
			for(Place i:placeArrayList) {
				if(i.getTen().contains(searchName))
					subList.add(i);
			}
			ObservableList<Place> subOList = FXCollections.observableArrayList(subList);
			table.setItems(subOList);
		}
	

	    @FXML
	    void exit(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new MenuScreen().getMenuScene(stage));
	    }

	    @FXML
	    void detail(ActionEvent event) throws IOException {
	    	Place place = table.getSelectionModel().getSelectedItem();
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Place");
	        PlaceDetailScreen screen = new PlaceDetailScreen();
	        stage.setScene(screen.getPlaceDetailScene(stage));
	        screen.setController(place);
	    }
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			placeArrayList = VNHistory.placestore.getEntityList();
			placeList = FXCollections.observableArrayList(placeArrayList);
			nameCol.setCellValueFactory(new PropertyValueFactory<Place,String>("ten"));
			adressCol.setCellValueFactory(new PropertyValueFactory<Place,String>("diaChi"));
			table.setItems(placeList);
		}

	}

