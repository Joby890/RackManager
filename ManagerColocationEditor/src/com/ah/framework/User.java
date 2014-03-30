package com.ah.framework;

import com.ah.framework.permission.Action;
import com.ah.framework.permission.ActionList;

public abstract class User {
	
	
	
	
    public abstract void addPermission(Unit u, Action action);
    public abstract void addPermission(Unit u);
    public abstract void addPermission(Unit u, ActionList list);
    public abstract void removePermission(Unit u, Action action);
    public abstract void removePermission(Unit u);
    public abstract boolean hasPermission(Action action, Unit u);
    public abstract int getRackSize();
	
	public abstract String getName();
	
	
	
}
