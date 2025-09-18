package vnhistory.crawler;

import java.io.IOException;

public interface Crawler {
	public void getSingleEntityInfor(String link) throws IOException;
	public void getEntityinfor(String link) throws IOException ;
}
