package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserRestController {

	@Autowired
	private IUserService userService;
	public UserRestController()
	{
		System.out.println("in constructor" + getClass().getName());
	}
	
	//add REst Api endpoint : for getting all users
	@GetMapping
	public List<User> fetchAllUsers()
	{
		System.out.println("in fetch all users");
		return userService.getAllUsers();
	}
	
	//add RestAPI endpoint for adding new user
//	@PostMapping
//    public User addNewUserDetails(@RequestBody User transientUser)
//    {   
//		System.out.println("in add user" + transientUser);
//		
//		return userService.addUser(transientUser);
//    }
	
	@PostMapping
    public ResponseEntity<?> addNewUserDetails(@RequestBody User transientUser)
    {   
		System.out.println("in add user" + transientUser);
		
		try {
		return new ResponseEntity<>(userService.addUser(transientUser),HttpStatus.CREATED);
		} catch(RuntimeException e)
		{
			System.out.println("err in add" + e);
			return new ResponseEntity<>(new ErrorResponse("adding User failed",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	//add Rest API to delete user details by id
	@DeleteMapping("/{userId}")
	public ResponseEntity<ResponseDTO> deleteUserDetails(@PathVariable int userId)
	{
		System.out.println("in delete user details" + userId);
		//invoke service layer method for deleting user details
		//return new ResponseEntity<>(new ResponseDTO(userService.deleteUser(userId)),HttpStatus.OK);
		return ResponseEntity.ok(new ResponseDTO(userService.deleteUser(userId)));
	}
	
	//add Rest API to get user details by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id)
	{
		System.out.println("in get user details" + id);
		//invoke service method to get details
		try {
			
			return ResponseEntity.ok(userService.getDetails(id));
			} catch(RuntimeException e)
			{
				System.out.println("err in get" + e);
				return new ResponseEntity<>(new ErrorResponse("Fetching USer details failed ",e.getMessage()),HttpStatus.BAD_REQUEST);
			}
	}
    //add REST API to update existing user details
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@RequestBody User detachedUser,@PathVariable int id)
	{
		System.out.println("in update user");
		try {
		User existingUser = userService.getDetails(id);
		return ResponseEntity.ok(userService.updateDetails(detachedUser));
		}
		catch(RuntimeException e)
		{
			System.out.println("err in get" + e);
			return new ResponseEntity<>(new ErrorResponse("updating USer details failed ",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
	}
    
}