package com.github.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.dto.UserDataDTO;
import com.github.dto.UserResponseDTO;
import com.github.model.User;
import com.github.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	
	@PostMapping("/signup")
	public String signup(@RequestBody UserDataDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

	@DeleteMapping(value = "/{username}")
	public String delete(@PathVariable String username) {
		userService.delete(username);
		return username;
	}

	@GetMapping(value = "/{username}")
	public UserResponseDTO search(@PathVariable String username) {
		return modelMapper.map(userService.search(username), UserResponseDTO.class);
	}
}
