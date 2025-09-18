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
import vnhistory.entity.Dynasty;
import vnhistory.screen.MenuScreen;
import vnhistory.screen.EntityDetailScreen.DynastyDetailScreen;
public class DynastyScreenController implements Initializable {


	    @FXML
	    private TextField searchText;

	    @FXML
	    private TableColumn<Dynasty, String> nameCol;

	    @FXML
	    private TableColumn<Dynasty, String> capitalCol;

	    @FXML
	    private TableView<Dynasty> table;
	    private ObservableList<Dynasty> dynastyList;
	    private List<Dynasty> dynastyArrayList = new ArrayList<>();
	    @FXML
	    void searchDynasty(ActionEvent event) {
	    	List<Dynasty> subList = new ArrayList<>();
			String searchName = searchText.getText();
			for(Dynasty i:dynastyArrayList) {
				if(i.getTen().contains(searchName))
					subList.add(i);
			}
			ObservableList<Dynasty> subOList = FXCollections.observableArrayList(subList);
			table.setItems(subOList);
	    }

	    @FXML
	    void exit(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new MenuScreen().getMenuScene(stage));
	    }

	    @FXML
	    void detail(ActionEvent event) throws IOException {
	    	Dynasty dynasty = table.getSelectionModel().getSelectedItem();
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Dynasty");
	        DynastyDetailScreen screen = new DynastyDetailScreen();
	        stage.setScene(screen.getDynastyDetailScene(stage));
	        screen.setController(dynasty);
	    }
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			dynastyArrayList = VNHistory.dynstore.getEntityList();
			dynastyList = FXCollections.observableArrayList(dynastyArrayList);
			nameCol.setCellValueFactory(new PropertyValueFactory<Dynasty,String>("ten"));
			capitalCol.setCellValueFactory(new PropertyValueFactory<Dynasty,String>("thuDo"));
			table.setItems(dynastyList);
		}

	}


