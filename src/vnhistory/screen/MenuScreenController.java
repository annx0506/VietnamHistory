package vnhistory.screen;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import vnhistory.screen.EntityScreen.DynastyScreen;
import vnhistory.screen.EntityScreen.EventScreen;
import vnhistory.screen.EntityScreen.FestivalScreen;
import vnhistory.screen.EntityScreen.FigureScreen;
import vnhistory.screen.EntityScreen.PlaceScreen;

public class MenuScreenController {
	    @FXML
	    void figureScene(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Figure");
	        stage.setScene(new FigureScreen().getFigureScene(stage));
	        stage.show();
	    }

	    @FXML
	    void dynScene(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Dynasty");
	        stage.setScene(new DynastyScreen().getDynastyScene(stage));
	        stage.show();
	    }

	    @FXML
	    void fesScene(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Festival");
	        stage.setScene(new FestivalScreen().getFestivalScene(stage));
	        stage.show();
	    }

	    @FXML
	    void eventScene(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Event");
	        stage.setScene(new EventScreen().getEventScene(stage));
	        stage.show();
	    }

	    @FXML
	    void placeScene(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        stage.setTitle("Place");
	        stage.setScene(new PlaceScreen().getPlaceScene(stage));
	        stage.show();
	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	Platform.exit();
	    }
}
