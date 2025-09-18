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

public class EventNguoikesuCrawler implements Crawler{
	String a = "Thời gian";// td valign="top"
	String b = "Địa điểm";// td valign="top"
	String c = "Kết quả";// td valign="top"
	String d = "Tham chiến";// th colspan="2"
	String e = "Chỉ huy";// th colspan="2"
	String f = "Lực lượng";// th colspan="2"
	String g = "Tổn thất";// th colspan="2"
	String h = "Nguyên nhân bùng nổ";// td valign="top"

	private JSONArray sukienArray = new JSONArray();

	public void getSingleEntityInfor(String link) throws IOException {
		JSONObject suKienDetails = new JSONObject();
		Connection web = Jsoup.connect(link);
		Document doc = web.get();
		suKienDetails.put(Keyword.TEN, doc.getElementsByClass("page-header").text());
		Elements infomation1 = doc.select("td[valign=top]");
		Elements infomation2 = doc.select("th[colspan=2]");
		for (Element infoElement : infomation1) {
			if (infoElement.text().equals(a)) {
				suKienDetails.put(Keyword.THOIGIAN, infoElement.parent().select("td").get(1).text());
				continue;
			}
			if (infoElement.text().equals(b)) {
				suKienDetails.put(Keyword.DIADIEM, infoElement.parent().select("td").get(1).text());
				continue;
			}
			if (infoElement.text().equals(c)) {
				suKienDetails.put(Keyword.KETQUA, infoElement.parent().select("td").get(1).text());
				continue;
			}
			if (infoElement.text().equals(h)) {
				suKienDetails.put(Keyword.NGUYENNHAN, infoElement.parent().select("td").get(1).text());
				continue;
			}
		}
		for (Element infoElement : infomation2) {
			if (infoElement.text().equals(d)) {
				suKienDetails.put(Keyword.THAMCHIEN, infoElement.parent().nextElementSibling().text());
				continue;
			}
			if (infoElement.text().equals(e)) {
				suKienDetails.put(Keyword.CHIHUY, infoElement.parent().nextElementSibling().text());
				continue;
			}
			if (infoElement.text().equals(f)) {
				suKienDetails.put(Keyword.LUCLUONG, infoElement.parent().nextElementSibling().text());
				continue;
			}
			if (infoElement.text().equals(g)) {
				suKienDetails.put(Keyword.TONTHAT, infoElement.parent().nextElementSibling().text());
				continue;
			}
		}
		JSONObject suKienObject = new JSONObject();
		suKienObject.put("Su kien", suKienDetails);
		sukienArray.add(suKienObject);
	}

	public void getEntityinfor(String link) throws IOException {
		List<String> linkSuKien = new ArrayList<>();
		for (int i = 0; i <= 70; i += 5) {
			Connection web = Jsoup.connect(link + "tu-lieu/quan-su?filter_tag[0]=&start=" + i);
			Document doc = web.get();
			Elements dataHeader = doc.getElementsByClass("page-header");
			for (Element f : dataHeader) {
				linkSuKien.add(f.getElementsByTag("a").attr("href"));
			}
		}
		for (int i = 0; i < linkSuKien.size(); i++) {
			getSingleEntityInfor(link + linkSuKien.get(i));
		}
		try (FileWriter file = new FileWriter("VNHistoryData/nguoikesu/sukien.json")) {
			file.write(sukienArray.toJSONString());
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
