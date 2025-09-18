package vnhistory;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vnhistory.crawler.HeroVansuCrawler;
import vnhistory.crawler.WikiCrawler;
import vnhistory.entity.Dynasty;
import vnhistory.entity.Event;
import vnhistory.entity.Festival;
import vnhistory.entity.Figure;
import vnhistory.entity.Place;
import vnhistory.json.toentity.GetInfor;
import vnhistory.screen.MenuScreen;
import vnhistory.store.EntityStore;

public class VNHistory extends Application {
	public static EntityStore<Figure> figurestore = new EntityStore<>();
	public static EntityStore<Dynasty> dynstore = new EntityStore<>();
	public static EntityStore<Place> placestore = new EntityStore<>();
	public static EntityStore<Event> eventstore = new EntityStore<>();
	public static EntityStore<Festival> festivalstore = new EntityStore<>();

	public static void main(String[] args) throws IOException {
//		HeroVansuCrawler c = new HeroVansuCrawler();
//		c.getEntityinfor("https://vansu.vn");
//		WikiCrawler c = new WikiCrawler();
//		c.getKing();
		GetInfor getter = new GetInfor();
		getter.getFromNguoikesu();
		getter.getFromWiki();
		getter.getFromVansu();
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Scene menu = new MenuScreen().getMenuScene(arg0);
		arg0.setTitle("Lmao");
		arg0.setScene(menu);
		arg0.show();
	}

}