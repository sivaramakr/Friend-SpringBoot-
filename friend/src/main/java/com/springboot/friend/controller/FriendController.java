package com.springboot.friend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.friend.model.Friend;
import com.springboot.friend.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	FriendService service;

	@GetMapping("/friends")
	public Iterable<Friend> findFriends() {

		return service.findAll();
	}

	@PostMapping("/friend")
	public Friend save(@RequestBody Friend friend) {

		return service.save(friend);

	}

	@DeleteMapping("/friend/{id}")
	public Friend deleteById(@PathVariable int id) {

		service.deleteById(id);

		return null;
	}

	@GetMapping("/friend/{id}")
	public Optional<Friend> findById(@PathVariable int id) {

		return service.findById(id);

	}

	@GetMapping("/friend/search")
	public Iterable<Friend> findByQuery(@RequestParam(value = "first", required = false) String firstName,
			@RequestParam(value = "last", required = false) String lasstname) {
		if (firstName != null && lasstname != null)
			return service.findByFirstNameAndLasstName(firstName, lasstname);

		else if (firstName != null)
			return service.findByFirstName(firstName);

		else if (lasstname != null)
			return service.findByLasstName(lasstname);

		else
			return service.findAll();

	}

}
