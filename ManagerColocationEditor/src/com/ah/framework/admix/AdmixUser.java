package com.ah.framework.admix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.ah.framework.User;
import com.ah.framework.permission.Action;
import com.ah.framework.permission.ActionList;

public class AdmixUser extends User {

	private Map<String, ActionList> actions = new HashMap<String, ActionList>();
	private String id;

	@Override
	public void addPermission(String item, Action action) {
		if(!actions.containsKey(item)) {
			actions.put(item, new ActionList());
		}
		actions.get(item).add(action);
	}

	@Override
	public void addPermission(String item, ActionList list) {
		actions.put(item, list);
		
	}

	@Override
	public void removePermission(String item, Action action) {
		actions.get(item).remove(action);
	}

	@Override
	public void removePermission(String item) {
		actions.remove(item);
		
	}

    @Override
    public boolean hasPermission(Action action, String item) {
         if(!actions.containsKey(item)) {
             return false;
         }
         return actions.get(item).can(action);
    }

	@Override
	public String getName() {
		return "joby890";
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int getRackSize() {
		return new Random().nextInt(47);
	}

}
