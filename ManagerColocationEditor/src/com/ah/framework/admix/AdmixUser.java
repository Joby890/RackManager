package com.ah.framework.admix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.ah.framework.Unit;
import com.ah.framework.User;
import com.ah.framework.permission.Action;
import com.ah.framework.permission.ActionList;

public class AdmixUser extends User {

	private Map<Unit, ActionList> actions = new HashMap<Unit, ActionList>();
	private String id;

	@Override
	public void addPermission(Unit u, Action action) {
		if(!actions.containsKey(u)) {
			actions.put(u, new ActionList());
		}
		actions.get(u).add(action);
	}

	@Override
	public void addPermission(Unit u, ActionList list) {
		actions.put(u, list);
		
	}

	@Override
	public void removePermission(Unit u, Action action) {
		actions.get(u).remove(action);
	}

	@Override
	public void removePermission(Unit u) {
		actions.remove(u);
		
	}

    @Override
    public boolean hasPermission(Action action, Unit u) {
         if(!actions.containsKey(u)) {
             return false;
         }
         return actions.get(u).can(action);
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

	@Override
	public void addPermission(Unit u) {
		if(!actions.containsKey(u)) {
			actions.put(u, new ActionList());
		}
		actions.get(u).add(Action.values());
	}

}
