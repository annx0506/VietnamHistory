package vnhistory.json.toentity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vnhistory.entity.Dynasty;
import vnhistory.resources.Keyword;
import vnhistory.store.EntityStore;

public class GetDynasty implements GetInforFromJsonFile<Dynasty> {
	private JSONParser parser = new JSONParser();

	@Override
	public Dynasty createEntity(JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject dynObj = (JSONObject) obj.get("Trieu Dai");
		Object tmp;

		tmp = dynObj.get(Keyword.TEN);
		if (tmp == null)
			return null;
		else if (((String) tmp).equals(""))
			return null;
		Dynasty dyn = new Dynasty((String) tmp);

		updateEntity(dyn, obj);

		return dyn;
	}

	@Override
	public void updateEntity(Dynasty entity, JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject dynObj = (JSONObject) obj.get("Trieu Dai");
		Object tmp;

		tmp = dynObj.get(Keyword.THUDO);
		if (tmp != null)
			entity.setThuDo((String) tmp);

		tmp = dynObj.get(Keyword.CHINHPHU);
		if (tmp != null)
			entity.setChinhPhu((String) tmp);

		tmp = dynObj.get(Keyword.VITHE);
		if (tmp != null)
			entity.setViThe((String) tmp);

		tmp = dynObj.get(Keyword.NGONNGU);
		if (tmp != null)
			entity.setNgonNgu((String) tmp);

		tmp = dynObj.get(Keyword.TINHTRANG);
		if (tmp != null)
			entity.setTinhTrang((String) tmp);

		tmp = dynObj.get(Keyword.TONGIAO);
		if (tmp != null)
			entity.setTonGiao((String) tmp);

		tmp = dynObj.get(Keyword.TIENTE);
		if (tmp != null)
			entity.setTienTe((String) tmp);
	}

	@Override
	public void getEntityInfor(EntityStore<Dynasty> store, String file) {
		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader(file)) {
			Object obj = parser.parse(reader);

			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Dynasty dyn = createEntity((JSONObject) array.get(i));
				if (dyn != null)
					if (!store.addEntityToStore(dyn)) {
						Dynasty updatedyn = store.findEntityInStore(dyn.getTen());
						updateEntity(updatedyn, (JSONObject) array.get(i));
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
