package com.ah.framework;


public interface UserManager {
	
	public User addUser(User user);
	
	public User removeUser(User user);
	
	public boolean hasUser(String name);
	
	public User getUser(String name);
	
	public User[] getCurrentUsers();
	
	public User newUser(String id);
	
	public User getUserById(String id);
	
	

}
