package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.exception.EntityAlreadyExistException;
import com.nnk.springboot.exception.EntityNotFoundException;

public interface IRatingService {
	/**
	 * Get One Rating object
	 * 
	 * @param id : id of the rating object which we want to get
	 * @return rating object if it exists
	 * @throws EntityNotFoundException
	 */
	Rating getRating(Integer id) throws EntityNotFoundException;

	/**
	 * 
	 * Add a new rating
	 *
	 * @param rating : rating object to add
	 * @return rating object added
	 */
	Rating addNewRating(Rating rating);

	/**
	 * Update information of the rating
	 * 
	 * @param id     : the id of the rating we want to update
	 * @param rating : the rating Object updated
	 * @return rating object updated
	 * @throws EntityAlreadyExistException
	 */
	public Rating updateRating(Integer id, Rating rating) throws EntityNotFoundException;

	/**
	 * get all ratings
	 * 
	 * @return list of all ratings existing in the database
	 */
	List<Rating> ratingList();

	/**
	 * Delete the rating
	 * 
	 * @param id : id of the rating we want to delete
	 * @throws EntityNotFoundException
	 */
	void deleteRating(Integer id) throws EntityNotFoundException;

}
