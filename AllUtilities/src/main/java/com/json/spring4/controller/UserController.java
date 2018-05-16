package com.json.spring4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.json.spring4.pojo.Name;
import com.json.spring4.pojo.User;
import com.json.spring4.service.Profile;
import com.json.spring4.service.UserService;
@RestController
@RequestMapping("/app")
public class UserController {
	//Updae
	@Autowired
	private UserService userService;
	@JsonView(Profile.PublicView.class)
	@RequestMapping(value= "/publicprofile", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllPublicProfile() {
		List<User> users = userService.getAllUsers();
		return users;
	}	
	@JsonView(Profile.FriendsView.class)
	@RequestMapping(value= "/friendsprofile", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllFriendsProfile() {
		List<User> users = userService.getAllUsers();
		return users;
	}	
	@JsonView(Profile.FamilyView.class)
	@RequestMapping(value= "/familyprofile", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllFamilyProfile() {
		List<User> users = userService.getAllUsers();
		return users;
	}		
	@RequestMapping(value= "/completeprofile/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getCompleteProfileById(@PathVariable(value = "userId") String userId) {
		User user = userService.getUserById(userId);
		return user;
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Name name) {
		StringBuffer output = new StringBuffer();
		if (name.getFirstName() != null) {
			output.append(" ").append(name.getFirstName());
		}
		if (name.getMiddleName() != null) {
			output.append(" ").append(name.getMiddleName());
		}
		if (name.getLastName() != null) {
			output.append(" ").append(name.getLastName());
		}		
		return new ResponseEntity<String>(output.toString(), HttpStatus.CREATED);
	} 
} 
