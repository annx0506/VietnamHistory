package vnhistory.crawler;

import java.io.IOException;

public class NguoikesuCrawler {
	static final String nguoikesuLink = "https://nguoikesu.com/";
	
	private EventNguoikesuCrawler eventCrawler = new EventNguoikesuCrawler();
	private PlaceNguoikesuCrawler placeCrawler = new PlaceNguoikesuCrawler();
	
	public void getEvent() throws IOException {
		eventCrawler.getEntityinfor(nguoikesuLink);
	}
	
	public void getPlace() throws IOException {
		placeCrawler.getEntityinfor(nguoikesuLink);
	}
	
	public void getIn() throws IOException {
		getEvent();
		getPlace();
	}
}
