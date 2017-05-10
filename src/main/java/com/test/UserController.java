package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This is the User Rest Controller that
 * interracts in all ways with the User
 * entity
 * 
 * capabilities
 * 	-get User
 * 	-create User
 * 	-update User
 * 	-delete User
 * 
 * @author Kevin
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	public void configeJackson(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
	    jackson2ObjectMapperBuilder.serializationInclusion(Include.USE_DEFAULTS);
	}
	
	/**
	 * This is the getUser Method that gets a User based on the requested userid
	 * 
	 * Responses
	 * 	-200 Ok with User Entity
	 * 	-204 the requested User has not been created 
	 * @param userid
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getUser")
    public ResponseEntity<?> getUser(@RequestParam String userid) {
		logger.info("getting user {}",userid);
        // hit the database to get the User
		User user = repo.findByuserid(userid);
		if(null == user){
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		logger.info("found user {}",user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		// return user
    }
	
	@RequestMapping(method = RequestMethod.POST, value="/addUser", consumes="application/json")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		logger.info("Creating user: {}",user.getUserid());
		User existingUser = repo.findByuserid(user.getUserid());
		if ( existingUser != null) {
			logger.info("A User with name {} already exist",user.getUserid());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		repo.insert(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}
}
