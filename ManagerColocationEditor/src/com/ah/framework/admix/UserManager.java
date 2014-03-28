package com.ah.framework.admix;

import java.util.ArrayList;
import java.util.List;

import com.ah.framework.User;


public class UserManager implements  com.ah.framework.UserManager {
	
	private List<User> users = new ArrayList<User>();

	@Override
	public User addUser(User user) {
		if(hasUser(user.getName())) {
			return getUser(user.getName());
		}
		users.add(user);
		return user;
	}

	@Override
	public User removeUser(User user) {
		users.remove(user);
		return user;
	}

	@Override
	public boolean hasUser(String name) {
		for(User user : users) {
			if(user.equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUser(String name) {
		for(User user : users) {
			if(user.equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User[] getCurrentUsers() {
		return users.toArray(new User[users.size()]);
	}

	@Override
	public User newUser(String id) {
		AdmixUser am = new AdmixUser();
		am.setId(id);
		return addUser(am);

	}

	@Override
	public User getUserById(String id) {
		for(User u : users) {
			if(((AdmixUser) u).getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

}
