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

public class KingWikiCrawler implements Crawler{
	String aa = "Trị vì";
	String bb = "Tiền nhiệm";
	String cc = "Kế nhiệm";
	String dd = "Sinh";
	String ee = "Mất";
	String ff = "An táng";
	String gg = "Thời kỳ";
	String hh = "Triều đại";
	String yy = "Thân phụ";
	String kk = "Thân mẫu";

	public static JSONArray vuaArray = new JSONArray();

	public void getSingleEntityInfor(String link) throws IOException {
		// TODO Auto-generated method stub

		Connection webConnection = Jsoup.connect(link);
		Document data = webConnection.get();
		Elements info = data.getElementsByClass("infobox").select("[style=width:22em]");
		for (Element i : info) {
			JSONObject vuaDetails = new JSONObject();
			String ten = i.select("th").get(0).text();
			vuaDetails.put(Keyword.TEN, ten);
			Elements infomation = i.select("tr");
			// Lay thong tin theo tung truong thong tin
			for (Element infoElement : infomation.select("[scope=row]")) {
				// System.out.println("getting infor");
				if (infoElement.text().equals(aa)) {
					vuaDetails.put(Keyword.THOIGIANTRIVI, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(bb)) {
					vuaDetails.put(Keyword.TIENNHIEM, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(cc)) {
					vuaDetails.put(Keyword.KENHIEM, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(dd)) {
					vuaDetails.put(Keyword.SINH, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(ee)) {
					vuaDetails.put(Keyword.MAT, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(ff)) {
					vuaDetails.put(Keyword.NOIANTANG, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(gg) || infoElement.text().equals(hh)) {
					vuaDetails.put(Keyword.TRIEUDAI, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(yy)) {
					vuaDetails.put(Keyword.CHA, infoElement.parent().select("td").text());
					continue;
				} else if (infoElement.text().equals(kk)) {
					vuaDetails.put(Keyword.ME, infoElement.parent().select("td").text());
					continue;
				}
			}
			JSONObject vuaObject = new JSONObject();
			vuaObject.put("Vua", vuaDetails);
			vuaArray.add(vuaObject);
		}

	}

	public void getEntityinfor(String link) throws IOException {
		// TODO Auto-generated method stub
		Connection web = Jsoup.connect(link + "/wiki/Vua_Vi%E1%BB%87t_Nam");
		Document doc = web.get();
		Elements table = doc.select("table[cellpadding = 0] tbody");
		List<String> links = new ArrayList<>();

		for (Element i : table) {
			Elements hang = i.select("tr[style *= height:50px;]");
			for (Element i1 : hang) {
				Element x = i1.select("td").get(1);
				Element y = x.getElementsByTag("a").get(0);
				links.add(y.attr("href"));

			}
		}

		for (int i = 0; i < links.size(); i++) {
			getSingleEntityInfor(link + links.get(i));

		}

		try (FileWriter file = new FileWriter("VNHistoryData/wiki/vua.json")) {
			file.write(vuaArray.toJSONString());
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
