package vnhistory.json.toentity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vnhistory.entity.Festival;
import vnhistory.resources.Keyword;
import vnhistory.store.EntityStore;

public class GetFestival implements GetInforFromJsonFile<Festival> {
	private JSONParser parser = new JSONParser();

	@Override
	public Festival createEntity(JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject fesObj = (JSONObject) obj.get("Le Hoi");
		Object tmp;

		tmp = fesObj.get(Keyword.TEN);
		if (tmp == null)
			return null;
		else if (((String) tmp).equals(""))
			return null;
		Festival fes = new Festival((String) tmp);

		updateEntity(fes, obj);

		return fes;
	}

	@Override
	public void updateEntity(Festival entity, JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject fesObj = (JSONObject) obj.get("Le Hoi");
		Object tmp;

		tmp = fesObj.get(Keyword.DIADIEMTOCHUC);
		if (tmp != null)
			entity.setDiaDiem((String) tmp);

		tmp = fesObj.get(Keyword.BATDAU);
		if (tmp != null)
			entity.setBatDau((String) tmp);

		tmp = fesObj.get(Keyword.NHANVAT);
		if (tmp != null)
			entity.setNhanVat((String) tmp);

		tmp = fesObj.get(Keyword.LANDAU);
		if (tmp != null)
			entity.setLanDau((String) tmp);
	}

	@Override
	public void getEntityInfor(EntityStore<Festival> store, String file) {
		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader(file)) {
			Object obj = parser.parse(reader);

			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Festival fes = createEntity((JSONObject) array.get(i));
				if (fes != null)
					if (!store.addEntityToStore(fes)) {
						Festival updateFes = store.findEntityInStore(fes.getTen());
						updateEntity(updateFes, (JSONObject) array.get(i));
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
