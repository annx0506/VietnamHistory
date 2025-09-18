package vnhistory.json.toentity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vnhistory.entity.Event;
import vnhistory.resources.Keyword;
import vnhistory.store.EntityStore;

public class GetEvent implements GetInforFromJsonFile<Event> {
	private JSONParser parser = new JSONParser();

	@Override
	public Event createEntity(JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject EventObj = (JSONObject) obj.get("Su kien");
		Object tmp;

		tmp = EventObj.get(Keyword.TEN);
		if (tmp == null)
			return null;
		else if (((String) tmp).equals(""))
			return null;
		Event event = new Event((String) tmp);

		updateEntity(event, obj);
		return event;
	}

	@Override
	public void updateEntity(Event entity, JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject eventObj = (JSONObject) obj.get("Su kien");
		Object tmp;

		tmp = eventObj.get(Keyword.THOIGIAN);
		if (tmp != null)
			entity.setThoiGian((String) tmp);

		tmp = eventObj.get(Keyword.DIADIEM);
		if (tmp != null)
			entity.setDiaDiem((String) tmp);

		tmp = eventObj.get(Keyword.THAMCHIEN);
		if (tmp != null)
			entity.setThamChien((String) tmp);

		tmp = eventObj.get(Keyword.NGUYENNHAN);
		if (tmp != null)
			entity.setNguyenNhan((String) tmp);

		tmp = eventObj.get(Keyword.CHIHUY);
		if (tmp != null)
			entity.setChiHuy((String) tmp);

		tmp = eventObj.get(Keyword.TONTHAT);
		if (tmp != null)
			entity.setTonThat((String) tmp);

		tmp = eventObj.get(Keyword.KETQUA);
		if (tmp != null)
			entity.setKetQua((String) tmp);
		
		tmp = eventObj.get(Keyword.LUCLUONG);
		if(tmp!=null)
			entity.setLucLuong((String)tmp);
	}

	@Override
	public void getEntityInfor(EntityStore<Event> store, String file) {
		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader(file)) {
			Object obj = parser.parse(reader);

			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Event event = createEntity((JSONObject) array.get(i));
				if (event != null)
					if (!store.addEntityToStore(event)) {
						Event updateEvent = store.findEntityInStore(event.getTen());
						updateEntity(updateEvent, (JSONObject) array.get(i));
					}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
