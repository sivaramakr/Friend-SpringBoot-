package com.springboot.friend.service;

import org.springframework.data.repository.CrudRepository;

import com.springboot.friend.model.Friend;

public interface FriendService extends CrudRepository<Friend, Integer>  {
	
	//name must match repository and pojo fields
	
	
	
public	Iterable<Friend> findByFirstNameAndLasstName(String fname,String lname);
public	Iterable<Friend> findByFirstName(String fname);
public	Iterable<Friend> findByLasstName(String lname);
}


