package vnhistory.json.toentity;

import org.json.simple.JSONObject;

import vnhistory.entity.Figure;
import vnhistory.store.EntityStore;

public abstract class GetFigure implements GetInforFromJsonFile<Figure>{

	@Override
	public Figure createEntity(JSONObject obj) {
		return null;
	}

	@Override
	public void updateEntity(Figure entity, JSONObject obj) {
		
	}

	@Override
	public void getEntityInfor(EntityStore<Figure> store, String file) {
		// TODO Auto-generated method stub
		
	}

}
