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

public class HeroVansuCrawler implements Crawler {
	String tenKhac = "Tên khác";
	String tinhThanh = "Tỉnh thành";
	String thoiKi = "Thời kì";
	String namSinh = "Năm sinh";

	JSONArray nhanvatArray = new JSONArray();

	@Override
	public void getSingleEntityInfor(String link) throws IOException {
		// TODO Auto-generated method stub
		JSONObject nhanvatDetails = new JSONObject();
		Connection web = Jsoup.connect(link);
		Document doc = web.get();
		nhanvatDetails.put("Ten", doc.getElementsByClass("active section").text());
		// System.out.println(doc.getElementsByClass("active section").text());
		Elements trElements = doc.select("tr");
		for (Element infoElement : trElements.select("td")) {
			// System.out.println(infoElement.text());
			if (infoElement.text().equals(tenKhac)) {
				nhanvatDetails.put(Keyword.TENKHAC, infoElement.nextElementSibling().text());
			} else if (infoElement.text().equals(tinhThanh)) {
				nhanvatDetails.put(Keyword.TINHTHANH, infoElement.nextElementSibling().text());
				// System.out.println(infoElement.nextElementSibling().text());
			} else if (infoElement.text().equals(thoiKi)) {
				nhanvatDetails.put(Keyword.TRIEUDAI, infoElement.nextElementSibling().text());
			} else if (infoElement.text().equals(namSinh)) {
				nhanvatDetails.put(Keyword.SINH, infoElement.nextElementSibling().text());
			}
		}
		JSONObject nhanvatObject = new JSONObject();
		nhanvatObject.put("Nhan vat", nhanvatDetails);
		nhanvatArray.add(nhanvatObject);
	}

	@Override
	public void getEntityinfor(String link) throws IOException {
		// TODO Auto-generated method stub
		Connection web = Jsoup.connect(link + "/viet-nam/viet-nam-nhan-vat");
		Document doc = web.get();
		List<String> linkspage = new ArrayList<>();
		List<String> linksnhanvat = new ArrayList<>();
		linkspage.add(link + "/viet-nam/viet-nam-nhan-vat");

		Elements pages = doc.getElementsByClass("right chevron icon");
		// System.out.println(pages.isEmpty());
		while (pages.isEmpty() == false) {
			pages = doc.getElementsByClass("right chevron icon");
			if (pages.isEmpty() == true)
				break;
			// System.out.println(pages.isEmpty());
			Element page = pages.get(0);

			linkspage.add(page.parent().attr("href"));
			web = Jsoup.connect(page.parent().attr("href"));
			doc = web.get();
		}
		for (String i : linkspage) {
			web = Jsoup.connect(i);
			doc = web.get();
			Elements nhanvat = doc.select("tr").select("td").select("a");
			int m = 0;
			for (Element k : nhanvat) {
				if (m % 2 == 0) {
					linksnhanvat.add(k.attr("href"));
					m += 1;
				} else {
					m += 1;
					continue;
				}
			}
		}
		for (String i : linksnhanvat) {
			getSingleEntityInfor(link + i);
		}
		try (FileWriter file = new FileWriter("VNHistoryData/vansu/nhanvat.json")) {
			file.write(nhanvatArray.toJSONString());
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
