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

public class PlaceNguoikesuCrawler implements Crawler{
	String aaaa = "Thờ phụng";
	String bbbb = "Địa chỉ";
	String cccc = "Thành lập";
	String dddd = "Lễ hội";
	String eeee = "Người sáng lập";
	String ffff = "Công trạng";
	String gggg = "Khu vực";

	private static JSONArray diaDiemArray = new JSONArray();

	public void getSingleEntityInfor(String link) throws IOException {
		JSONObject diaDiemDetails = new JSONObject();
		Connection webConnection = Jsoup.connect(link);
		Document data = webConnection.get();
		String header = data.getElementsByClass("page-header").get(1).text();
		diaDiemDetails.put(Keyword.TEN, header);
		Elements infomation = data.select("table");
		for (Element infoElement : infomation.select("[scope=row]")) {
			if (infoElement.text().equals(aaaa)) {
				diaDiemDetails.put("Tho phung", infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(bbbb)) {
				diaDiemDetails.put(Keyword.DIACHI, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(cccc)) {
				diaDiemDetails.put(Keyword.THANHLAP, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(dddd)) {
				diaDiemDetails.put(Keyword.LEHOI, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(eeee)) {
				diaDiemDetails.put(Keyword.NGUOISANGLAP, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(ffff)) {
				diaDiemDetails.put(Keyword.CONGTRANG, infoElement.parent().select("td").text());
				continue;
			} else if (infoElement.text().equals(gggg)) {
				diaDiemDetails.put("Khu vuc", infoElement.parent().select("td").text());
				continue;
			}
		}
		JSONObject diaDiemObject = new JSONObject();
		diaDiemObject.put("Dia diem", diaDiemDetails);
		diaDiemArray.add(diaDiemObject);
	}
	
	public void getEntityinfor(String link) throws IOException {
		List<String> linkDiaDiem = new ArrayList<>();
		Connection web = Jsoup.connect(link + "di-tich-lich-su?types[0]=1");
		Document doc = web.get();
		Elements dataE = doc.select("h3").select("a");
		for (Element i : dataE) {
			linkDiaDiem.add(i.attr("href"));
		}
		web = Jsoup.connect(link + "di-tich-lich-su?types[0]=1&start=10");
		doc = web.get();
		dataE = doc.select("h3").select("a");
		for (Element i : dataE) {
			linkDiaDiem.add(i.attr("href"));
		}
		web = Jsoup.connect(link + "di-tich-lich-su?types[0]=1&start=20");
		doc = web.get();
		dataE = doc.select("h3").select("a");
		for (Element i : dataE) {
			linkDiaDiem.add(i.attr("href"));
		}
		for (int l = 0; l < linkDiaDiem.size(); l++) {
			getSingleEntityInfor(link + linkDiaDiem.get(l));
		}
		try (FileWriter file = new FileWriter("VNHistoryData/nguoikesu/diadiem.json")) {
			file.write(diaDiemArray.toJSONString());
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
