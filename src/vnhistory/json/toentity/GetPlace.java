package vnhistory.json.toentity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vnhistory.entity.Place;
import vnhistory.resources.Keyword;
import vnhistory.store.EntityStore;

public class GetPlace implements GetInforFromJsonFile<Place> {
	private JSONParser parser = new JSONParser();

	@Override
	public Place createEntity(JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject placeObj = (JSONObject) obj.get("Dia diem");
		Object tmp;

		tmp = placeObj.get(Keyword.TEN);
		if (tmp == null)
			return null;
		else if (((String) tmp).equals(""))
			return null;
		Place place = new Place((String) tmp);

		updateEntity(place, obj);
		return place;
	}

	@Override
	public void updateEntity(Place entity, JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject placeObj = (JSONObject) obj.get("Dia diem");
		Object tmp;

		tmp = placeObj.get(Keyword.DIACHI);
		if (tmp != null)
			entity.setDiaChi((String) tmp);

		tmp = placeObj.get(Keyword.THANHLAP);
		if (tmp != null)
			entity.setThanhLap((String) tmp);

		tmp = placeObj.get(Keyword.NGUOISANGLAP);
		if (tmp != null)
			entity.setNguoiLap((String) tmp);

		tmp = placeObj.get(Keyword.CONGTRANG);
		if (tmp != null)
			entity.setCongTrang((String) tmp);

		tmp = placeObj.get(Keyword.LEHOI);
		if (tmp != null)
			entity.setLeHoi((String) tmp);
	}

	@Override
	public void getEntityInfor(EntityStore<Place> store, String file) {
		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader(file)) {
			Object obj = parser.parse(reader);

			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Place place = createEntity((JSONObject) array.get(i));
				if (place != null)
					if (!store.addEntityToStore(place)) {
						Place updatePlace = store.findEntityInStore(place.getTen());
						updateEntity(updatePlace, (JSONObject) array.get(i));
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
