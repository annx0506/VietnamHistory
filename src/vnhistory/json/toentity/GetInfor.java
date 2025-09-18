package vnhistory.json.toentity;

import vnhistory.VNHistory;
import vnhistory.entity.Dynasty;
import vnhistory.entity.Event;
import vnhistory.entity.Festival;
import vnhistory.entity.Figure;
import vnhistory.entity.Place;

public class GetInfor {
	private static final String wikiDS = "VNHistoryData/wiki";
	private static final String nksDS = "VNHistoryData/nguoikesu";
	private static final String vsDS = "VNHistoryData/vansu";
	
	GetInforFromJsonFile<Figure> getKing = new GetKing();
	GetInforFromJsonFile<Figure> getHero = new GetHero();
	GetInforFromJsonFile<Dynasty> getDyn = new GetDynasty();
	GetInforFromJsonFile<Festival> getFes = new GetFestival();
	GetInforFromJsonFile<Place> getPlace = new GetPlace();
	GetInforFromJsonFile<Event> getEvent = new GetEvent();
	

	public void getFromWiki() {
		getKing.getEntityInfor(VNHistory.figurestore, wikiDS + "/vua.json");
		getDyn.getEntityInfor(VNHistory.dynstore, wikiDS + "/trieudai.json");
		getFes.getEntityInfor(VNHistory.festivalstore, wikiDS + "/lehoi.json");
	}

	public void getFromNguoikesu() {
		getPlace.getEntityInfor(VNHistory.placestore, nksDS + "/diadiem.json");
		getEvent.getEntityInfor(VNHistory.eventstore, nksDS + "/sukien.json");
	}
	public void getFromVansu() {
		getHero.getEntityInfor(VNHistory.figurestore, vsDS + "/nhanvat.json");
	}
}
