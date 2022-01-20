package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Rating;

public interface IRatingService {

	/**
	 * 
	 * Add a new rating ** This operation allows to check if the id of the rating we
	 * want to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param rating : rating object to add
	 * @return rating object added
	 * @throws Exception
	 */
	Rating addNewRating(Rating rating) throws Exception;

	/**
	 * Update information of the rating ** This operation allows to check if the id
	 * of the rating we want to update already exists in the database,
	 * 
	 * @param id     : the id of the rating we want to update
	 * @param rating : the rating Object updated
	 * @return rating object updated
	 * @throws Exception
	 */
	Rating updateBide(Integer id, Rating rating) throws Exception;

	/**
	 * get all ratings
	 * 
	 * @return list of all ratings existing in the database
	 */
	List<Rating> ratingList();

	/**
	 * Delete the rating ** This operation allows to check if the id of the rating
	 * we want to delete already exist in the database, then allows to use its id to
	 * delete it
	 * 
	 * @param id : id of the rating we want to delete
	 * @throws Exception
	 */
	void deleteRating(Integer id) throws Exception;

}
