package vnhistory.store;

import java.util.ArrayList;
import java.util.List;

import vnhistory.entity.Base;

public class EntityStore<T extends Base> {
	private List<T> entityList = new ArrayList<>();
	
	public List<T> getEntityList(){
		return entityList;
	}

	public T findEntityInStore(String name) {
		// TODO Auto-generated method stub
		for (T i : entityList)
			if (i.getTen().contains(name) || name.contains(i.getTen()))
				return i;
		return null;
	}

	public boolean addEntityToStore(T entity) {
		// TODO Auto-generated method stub
		if (findEntityInStore(entity.getTen()) == null) {
			entityList.add(entity);
			System.out.println("Add to store successfully");
			return true;
		}
		System.out.println("Add failed: " + entity.getTen());
		return false;
	}

	public void showAllEntity() {
		for (T i : entityList)
			System.out.println(i.toString());
	}
	
}
