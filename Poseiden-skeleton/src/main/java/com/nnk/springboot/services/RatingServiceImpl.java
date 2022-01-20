package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements IRatingService {

	private static final Logger logger = LogManager.getLogger("RatingServiceImpl");

	/**
	 * Calling operations of the bidListRepository
	 */
	@Autowired
	private RatingRepository ratingRepository;

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
	@Override
	public Rating addNewRating(Rating rating) throws Exception {
		logger.info("adding new rating");
		Optional<Rating> ratingFound = ratingRepository.findById(rating.getId());
		if (ratingFound.isPresent()) {
			logger.error("The rating id : " + rating.getId() + ", you want to add, is already exists!");
			throw new Exception("The rating id : " + rating.getId() + ", is already exists!");
		}

		logger.info("add rating id : " + rating.getId());
		return ratingRepository.save(rating);
	}

	/**
	 * Update information of the rating ** This operation allows to check if the id
	 * of the rating we want to update already exists in the database,
	 * 
	 * @param id     : the id of the rating we want to update
	 * @param rating : the rating Object updated
	 * @return rating object updated
	 * @throws Exception
	 */
	@Override
	public Rating updateBide(Integer id, Rating rating) throws Exception {
		logger.info("updating a Rating");
		Optional<Rating> ratingFound = ratingRepository.findById(rating.getId());
		if (ratingFound.isEmpty()) {
			logger.error("The rating id : " + id + ", you want to update, does not exist!");
			throw new Exception("The rating id : " + id + ", is already exists!");
		}
		logger.info("update rating id : " + id);
		ratingFound.get().setFitchRating(
				rating.getFitchRating() != null ? rating.getFitchRating() : ratingFound.get().getFitchRating());
		ratingFound.get().setMoodysRating(
				rating.getMoodysRating() != null ? rating.getMoodysRating() : ratingFound.get().getMoodysRating());
		ratingFound.get().setSandPRating(
				rating.getSandPRating() != null ? rating.getSandPRating() : ratingFound.get().getSandPRating());
		ratingFound.get().setOrderNumber(
				rating.getOrderNumber() != null ? rating.getOrderNumber() : ratingFound.get().getOrderNumber());
		return ratingRepository.saveAndFlush(ratingFound.get());

	}

	/**
	 * get all ratings
	 * 
	 * @return list of all ratings existing in the database
	 */
	@Override
	public List<Rating> ratingList() {
		logger.info("get list of Bids");
		return ratingRepository.findAll();

	}

	/**
	 * Delete the rating ** This operation allows to check if the id of the rating
	 * we want to delete already exist in the database, then allows to use its id to
	 * delete it
	 * 
	 * @param id : id of the rating we want to delete
	 * @throws Exception
	 */
	@Override
	public void deleteRating(Integer id) throws Exception {
		logger.info("deleting a rating");
		Optional<Rating> ratingFound = ratingRepository.findById(id);
		if (ratingFound.isEmpty()) {
			logger.error("The rating id : " + id + ", you want to delete, does not exist!");
			throw new Exception("The rating id : " + id + ", you want to delete, does not exist!");
		}

		logger.info("delete the rating id " + id);
		ratingRepository.deleteById(id);

	}

}
