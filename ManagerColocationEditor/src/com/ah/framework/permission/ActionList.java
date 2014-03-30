package com.ah.framework.permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionList {
	
	private List<Action> actions = new ArrayList<Action>();
	
	public boolean can(Action action) {
		return actions.contains(action);
	}
	
	public void add(Action action) {
		if(!actions.contains(action)) {
			actions.add(action);
		}

	}
	
	public void remove(Action action) {
		actions.remove(action);
	}
	
	public void add(Action[] actions) {
		this.actions.addAll(Arrays.asList(actions));
	}

}
