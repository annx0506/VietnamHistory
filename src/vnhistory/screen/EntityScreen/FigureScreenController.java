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
import vnhistory.entity.Figure;
import vnhistory.entity.Hero;
import vnhistory.entity.King;
import vnhistory.screen.MenuScreen;
import vnhistory.screen.EntityDetailScreen.HeroDetailScreen;
import vnhistory.screen.EntityDetailScreen.KingDetailScreen;

public class FigureScreenController implements Initializable {

	@FXML
	private TableView<Figure> table;

	@FXML
	private TextField searchText;

	@FXML
	private TableColumn<Figure, String> nameCol;

	@FXML
	private TableColumn<Figure, String> dynCol;

	private ObservableList<Figure> figureList;
	private List<Figure> figureArrayList = new ArrayList<>();

	@FXML
	void searchKing(ActionEvent event) {
		List<Figure> subList = new ArrayList<>();
		String searchName = searchText.getText();
		for (Figure i : figureArrayList) {
			if (i.getTen().contains(searchName))
				subList.add(i);
		}
		ObservableList<Figure> subOList = FXCollections.observableArrayList(subList);
		table.setItems(subOList);
	}

	@FXML
	void exit(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new MenuScreen().getMenuScene(stage));
	}

	@FXML
	void detail(ActionEvent event) throws IOException {
		Figure figure = table.getSelectionModel().getSelectedItem();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Figure");
		if (figure instanceof King) {
			King king = (King) figure;
			KingDetailScreen screen = new KingDetailScreen();
			stage.setScene(screen.getKingDetailScene(stage));
			screen.setController(king);
		}
		else if (figure instanceof Hero) {
			Hero hero = (Hero) figure;
			HeroDetailScreen screen = new HeroDetailScreen();
			stage.setScene(screen.getHeroDetailScene(stage));
			screen.setController(hero);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		figureArrayList = VNHistory.figurestore.getEntityList();
		figureList = FXCollections.observableArrayList(figureArrayList);
		nameCol.setCellValueFactory(new PropertyValueFactory<Figure, String>("ten"));
		dynCol.setCellValueFactory(new PropertyValueFactory<Figure, String>("trieuDai"));
		table.setItems(figureList);
	}
}
