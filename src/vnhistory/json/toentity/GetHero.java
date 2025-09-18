package vnhistory.json.toentity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vnhistory.entity.Figure;
import vnhistory.entity.Hero;
import vnhistory.resources.Keyword;
import vnhistory.store.EntityStore;

public class GetHero extends GetFigure {
	private JSONParser parser = new JSONParser();
	@Override
	public Figure createEntity(JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject kingObj = (JSONObject) obj.get("Nhan vat");
		Object tmp;

		tmp = kingObj.get(Keyword.TEN);
		if (tmp == null)
			return null;
		else if (((String) tmp).equals(""))
			return null;
		Hero hero = new Hero((String) tmp);

		updateEntity(hero, obj);

		return hero;
	}

	@Override
	public void updateEntity(Figure entity, JSONObject obj) {
		JSONObject heroObj = (JSONObject) obj.get("Nhan vat");
		Object tmp;
		Hero hero = (Hero) entity;
		
		tmp = heroObj.get(Keyword.SINH);
		if(tmp!=null) hero.setNgaySinh((String) tmp);
		
		tmp = heroObj.get(Keyword.TRIEUDAI);
		if(tmp!=null) hero.setTrieuDai((String) tmp);
		
		tmp = heroObj.get(Keyword.TENKHAC);
		if(tmp!=null) hero.setTenKhac((String) tmp);
		
		tmp = heroObj.get(Keyword.TINHTHANH);
		if(tmp!=null) hero.setTinhThanh((String) tmp);
	}

	@Override
	public void getEntityInfor(EntityStore<Figure> store, String file) {
		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader(file)) {
			Object obj = parser.parse(reader);

			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Figure hero = createEntity((JSONObject) array.get(i));
				if (hero != null)
					if (!store.addEntityToStore(hero)) {
						Figure updateHero = store.findEntityInStore(hero.getTen());
						if (updateHero instanceof Hero)
							updateEntity(hero, (JSONObject) array.get(i));
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
