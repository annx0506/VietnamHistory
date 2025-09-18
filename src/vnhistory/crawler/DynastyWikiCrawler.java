package vnhistory.crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import vnhistory.resources.Keyword;

public class DynastyWikiCrawler implements Crawler{
	private static String aaa = "Thủ đô";
	private static String bbb = "Ngôn ngữ thông dụng";
	private static String ccc = "Chính phủ";
	private static String ddd = "Hiện nay là một phần của";
	private static String ggg = "Đơn vị tiền tệ";
	private static String hhh = "Vị thế";
	private static String yyy = "Tôn giáo chính";
	private static String kkk = "Tiết độ sứ";

	public static JSONArray trieuDaiArray = new JSONArray();

	public void getSingleEntityInfor(String link) throws IOException {
		// TODO Auto-generated method stub
		JSONObject trieuDaiDetails = new JSONObject();
		Connection webConnection = Jsoup.connect(link);
		Document data = webConnection.get();
		String title = data.getElementsByClass("mw-page-title-main").text();
		// System.out.println(title);
		trieuDaiDetails.put(Keyword.TEN, title);
		Elements info = data.getElementsByClass("infobox").select("[style*=width:22em]");
		for (Element kgh : info) {
			// System.out.println(info);
		}
		for (Element infoElement : info.select("[scope=row]")) {
			// System.out.println(infoElement);
			if (infoElement.text().equals(aaa)) {
				trieuDaiDetails.put(Keyword.THUDO, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(bbb)) {
				trieuDaiDetails.put(Keyword.NGONNGU, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(ccc)) {
				trieuDaiDetails.put(Keyword.CHINHPHU, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(ddd)) {
				trieuDaiDetails.put(Keyword.TINHTRANG, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(ggg)) {
				trieuDaiDetails.put(Keyword.TIENTE, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(hhh)) {
				trieuDaiDetails.put(Keyword.VITHE, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(yyy)) {
				trieuDaiDetails.put(Keyword.TONGIAO, infoElement.parent().select("td").text());
				continue;
			}
		}
		JSONObject trieuDaiObject = new JSONObject();
		trieuDaiObject.put("Trieu Dai", trieuDaiDetails);
		trieuDaiArray.add(trieuDaiObject);
	}

	public void getEntityinfor(String link) throws IOException {
		// TODO Auto-generated method stub
		Connection web = Jsoup.connect(link + "/wiki/L%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam");
		Document doc = web.get();
		Elements table = doc.select("table[align*=right]");
		List<String> linkTrieuDai = new ArrayList<>();

		for (Element i : table.select("a")) {
			linkTrieuDai.add(i.attr("href"));
		}
		for (int l = 0; l < linkTrieuDai.size(); l++) {
			if (l == 0 || l == linkTrieuDai.size() - 1) {
				continue;
			} else {
				getSingleEntityInfor(link + linkTrieuDai.get(l));
			}
		}
		try (FileWriter file = new FileWriter("VNHistoryData/wiki/trieudai.json")) {
			file.write(trieuDaiArray.toJSONString());
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
