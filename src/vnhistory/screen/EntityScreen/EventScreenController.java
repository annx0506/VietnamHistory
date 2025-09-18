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
import vnhistory.entity.Event;
import vnhistory.screen.MenuScreen;
import vnhistory.screen.EntityDetailScreen.EventDetailScreen;
public class EventScreenController implements Initializable {

	    @FXML
	    private TableColumn<Event, String> timeCol;

	    @FXML
	    private TextField searchText;

	    @FXML
	    private TableColumn<Event, String> nameCol;

	    @FXML
	    private TableView<Event> table;
	    private ObservableList<Event> eventList;
	    private List<Event> eventArrayList ;
	    @FXML
	    void searchEvent(ActionEvent event) {
	    	List<Event> subList = new ArrayList<>();
			String searchName = searchText.getText();
			for(Event i:eventArrayList) {
				if(i.getTen().contains(searchName))
					subList.add(i);
			}
			ObservableList<Event> subOList = FXCollections.observableArrayList(subList);
			table.setItems(subOList);
		}

	    @FXML
	    void exit(ActionEvent event) throws IOException {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new MenuScreen().getMenuScene(stage));
		}

	    @FXML
	    void detail(ActionEvent event) throws IOException {
	    	Event evenT = table.getSelectionModel().getSelectedItem();
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Event");
	        EventDetailScreen screen = new EventDetailScreen();
	        stage.setScene(screen.getEventDetailScene(stage));
	        screen.setController(evenT);
	    }
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
	    	eventArrayList = VNHistory.eventstore.getEntityList();
	    	eventList = FXCollections.observableArrayList(eventArrayList);
			nameCol.setCellValueFactory(new PropertyValueFactory<Event,String>("ten"));
			timeCol.setCellValueFactory(new PropertyValueFactory<Event,String>("thoiGian"));
			table.setItems(eventList);
		}

	}
