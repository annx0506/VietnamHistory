package vnhistory.json.toentity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vnhistory.entity.Figure;
import vnhistory.entity.King;
import vnhistory.resources.Keyword;
import vnhistory.store.EntityStore;

public class GetKing extends GetFigure {
	private JSONParser parser = new JSONParser();

	@Override
	public Figure createEntity(JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject kingObj = (JSONObject) obj.get("Vua");
		Object tmp;

		tmp = kingObj.get(Keyword.TEN);
		if (tmp == null)
			return null;
		else if (((String) tmp).equals(""))
			return null;
		King king = new King((String) tmp);

		updateEntity(king, obj);

		return king;
	}

	@Override
	public void getEntityInfor(EntityStore<Figure> store, String file) {
		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader(file)) {
			Object obj = parser.parse(reader);

			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Figure king = createEntity((JSONObject) array.get(i));
				if (king != null)
					if (!store.addEntityToStore(king)) {
						Figure updateKing = store.findEntityInStore(king.getTen());
						if (updateKing instanceof King)
							updateEntity(updateKing, (JSONObject) array.get(i));
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

	@Override
	public void updateEntity(Figure figure, JSONObject obj) {
		// TODO Auto-generated method stub
		JSONObject kingObj = (JSONObject) obj.get("Vua");
		Object tmp;
		King king = (King) figure;

		tmp = kingObj.get(Keyword.TRIEUDAI);
		if (tmp != null)
			king.setTrieuDai((String) tmp);

		tmp = kingObj.get(Keyword.SINH);
		if (tmp != null)
			king.setNgaySinh((String) tmp);

		tmp = kingObj.get(Keyword.MAT);
		if (tmp != null)
			king.setNgayMat((String) tmp);

		tmp = kingObj.get(Keyword.CHA);
		if (tmp != null)
			king.setCha((String) tmp);

		tmp = kingObj.get(Keyword.ME);
		if (tmp != null)
			king.setMe((String) tmp);

		tmp = kingObj.get(Keyword.KENHIEM);
		if (tmp != null)
			king.setKeNhiem((String) tmp);

		tmp = kingObj.get(Keyword.TIENNHIEM);
		if (tmp != null)
			king.setTienNhiem((String) tmp);

		tmp = kingObj.get(Keyword.THOIGIANTRIVI);
		if (tmp != null)
			king.setThoiGianTriVi((String) tmp);

		tmp = kingObj.get(Keyword.NOIANTANG);
		if (tmp != null)
			king.setNoiAnNghi((String) tmp);
	}

}
