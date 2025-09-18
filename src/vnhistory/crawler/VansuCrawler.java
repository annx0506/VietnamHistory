package vnhistory.crawler;

import java.io.IOException;

public class VansuCrawler {
	HeroVansuCrawler getHero = new HeroVansuCrawler();
	private static final String vansuLink = "https://vansu.vn";
	
	public void getHero() throws IOException {
		getHero.getEntityinfor(vansuLink);
	}
	
	public void getIn() throws IOException {
		getHero();
	}
}
