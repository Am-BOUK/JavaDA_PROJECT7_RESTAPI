package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.exception.EntityNotFoundException;

public interface IBidListService {
	/**
	 * Get One bid object
	 * 
	 * @param user : user object whose we want to get
	 * @return person object if it exists
	 * @throws EntityNotFoundException
	 */

	public BidList getBid(Integer id) throws EntityNotFoundException;

	/**
	 * 
	 * Add a new bid
	 *
	 * @param bid : BidList object to add
	 * @return
	 */
	BidList addNewBid(BidList bid);

	/**
	 * Update information of the bid
	 * 
	 * @param id  : the id of the bid we want to update
	 * @param bid : the Bid Object updated
	 * @return BidList object updated
	 * @throws EntityNotFoundException
	 */
	BidList updateBide(Integer id, BidList bid) throws EntityNotFoundException;

	/**
	 * get all Bids
	 * 
	 * @return list of all bids existing in the database
	 */
	List<BidList> bidList();

	/**
	 * Delete the bid
	 * 
	 * @param id : id of the bid we want to delete
	 * @throws EntityNotFoundException
	 */
	void deleteBid(Integer id) throws EntityNotFoundException;

}
