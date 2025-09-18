package vnhistory.crawler;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import vnhistory.resources.Keyword;

public class FestivalWikiCrawler implements Crawler{
	@Override
	public void getEntityinfor(String link) throws IOException {
		Connection web = Jsoup.connect(link + "/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam");
		Document doc = web.get();
		Elements table = doc.select("table[class=prettytable wikitable]");
		JSONArray leHoiArray = new JSONArray();
		int k = 0;

		for (Element i : table.select("tr")) {
			if (k == 0) {
				k++;
				continue;
			} else {
				JSONObject leHoiDetails = new JSONObject();
				Element y = table.select("tr").get(k);
				leHoiDetails.put(Keyword.BATDAU, y.select("td").get(0).text());
				leHoiDetails.put(Keyword.DIADIEMTOCHUC, y.select("td").get(1).text());
				leHoiDetails.put(Keyword.TEN, y.select("td").get(2).text());
				leHoiDetails.put(Keyword.LANDAU, y.select("td").get(3).text());
				leHoiDetails.put(Keyword.NHANVAT, y.select("td").get(4).text());
				JSONObject leHoiObject = new JSONObject();
				leHoiObject.put("Le Hoi", leHoiDetails);
				leHoiArray.add(leHoiObject);
				k++;
			}
		}
		try (FileWriter file = new FileWriter("VNHistoryData/wiki/lehoi.json")) {
			file.write(leHoiArray.toJSONString());
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getSingleEntityInfor(String link) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
