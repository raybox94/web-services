package com.example.demo.user;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	static {
		
		users.add(new User(1,"Ray",new Date()));
		users.add(new User(2,"Box",new Date()));
		users.add(new User(3,"Rayaan",new Date()));
	}
	
	public List<User> findAll(){
		return users;
		
	}
	
	public User save(User user){
		users.add(user);

		return user;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator(); 
		
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	
}
