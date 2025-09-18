package vnhistory.crawler;

import java.io.IOException;

public class WikiCrawler {
	static final String wikiLink = "https://vi.wikipedia.org";

	private KingWikiCrawler kingCrawler = new KingWikiCrawler();
	private FestivalWikiCrawler festivalCrawler = new FestivalWikiCrawler();
	private DynastyWikiCrawler dynastyCrawler = new DynastyWikiCrawler();

	public void getFestival() throws IOException {
		festivalCrawler.getEntityinfor(wikiLink);
	}

	public void getKing() throws IOException {
		kingCrawler.getEntityinfor(wikiLink);
	}

	public void getDynasty() throws IOException {
		dynastyCrawler.getEntityinfor(wikiLink);
	}
	
	public void getIn() throws IOException {
		getFestival();
		getKing();
		getDynasty();
	}
}
