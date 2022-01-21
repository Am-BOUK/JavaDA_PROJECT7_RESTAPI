package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.exception.EntityAlreadyExistException;
import com.nnk.springboot.exception.EntityNotFoundException;

/**
 * implementation of user business processing
 * 
 */
public interface IUserService {
	/**
	 * Get One user object
	 * 
	 * @param id : id of the user object whose we want to get
	 * @return user object if it exists
	 * @throws EntityNotFoundException
	 */
	User getUser(Integer id) throws EntityNotFoundException;

	/**
	 * 
	 * Add a new user
	 * 
	 * @param user : user object to add
	 * @return user object added
	 * @throws EntityNotFoundException
	 */
	User addNewUser(User user) throws EntityAlreadyExistException;

	/**
	 * Update information of the user
	 * 
	 * @param user : the user Object updated
	 * @return user object updated
	 * @throws Exception
	 */
	User updateUser(Integer id, User user) throws EntityNotFoundException;

	/**
	 * get all users
	 * 
	 * @return list of all users existing in the database
	 */
	List<User> usersList();

	/**
	 * Delete the user
	 * 
	 * @param id : id of the user we want to delete
	 * @throws EntityNotFoundException
	 */
	void deleteUser(Integer id) throws EntityNotFoundException;

}
