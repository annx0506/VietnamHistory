package vnhistory.json.toentity;

import org.json.simple.JSONObject;

import vnhistory.entity.Base;
import vnhistory.store.EntityStore;

public interface GetInforFromJsonFile<T extends Base> {
	T createEntity(JSONObject obj);

	void updateEntity(T entity, JSONObject obj);

	void getEntityInfor(EntityStore<T> store, String file);
}
