package com.ah.framework;

import com.ah.framework.permission.Action;
import com.ah.framework.permission.ActionList;

public abstract class User {
	
	
	
	
    public abstract void addPermission(String item, Action action);
    public abstract void addPermission(String item, ActionList list);
    public abstract void removePermission(String item, Action action);
    public abstract void removePermission(String item);
    public abstract boolean hasPermission(Action action, String item);
    public abstract int getRackSize();
	
	public abstract String getName();
	
	
	
}
