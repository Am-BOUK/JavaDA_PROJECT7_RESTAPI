package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.User;

public interface IUserService {

	/**
	 * 
	 * Add a new user ** This operation allows to check if the id of the user we
	 * want to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param user : user object to add
	 * @return user object added
	 * @throws Exception
	 */
	User addNewUser(User user) throws Exception;

	/**
	 * Update information of the user ** This operation allows to check if the id of
	 * the user we want to update already exists in the database,
	 * 
	 * @param user : the user Object updated
	 * @return user object updated
	 * @throws Exception
	 */
	User updateUser(Integer id, User user) throws Exception;

	/**
	 * get all users
	 * 
	 * @return list of all users existing in the database
	 */
	List<User> usersList();

	/**
	 * Delete the user ** This operation allows to check if the id of te user we
	 * want to delete already exist in the database, then allows to use its id to
	 * delete it
	 * 
	 * @param id : id of the user we want to delete
	 * @throws Exception
	 */
	void deleteUser(Integer id) throws Exception;

}
