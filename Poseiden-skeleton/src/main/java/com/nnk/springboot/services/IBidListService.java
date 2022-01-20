package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.BidList;

public interface IBidListService {

	/**
	 * 
	 * Add a new bid ** This operation allows to check if the id of the bide we want
	 * to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param bid : BidList object to add
	 * @return
	 * @throws Exception
	 */
	BidList addNewBid(BidList bid) throws Exception;

	/**
	 * Update information of the bid ** This operation allows to check if the id of
	 * the bid we want to update already exists in the database,
	 * 
	 * @param id  : the id of the bid we want to update
	 * @param bid : the Bid Object updated
	 * @return BidList object updated
	 * @throws Exception
	 */
	BidList updateBide(Integer id, BidList bid) throws Exception;

	/**
	 * get all Bids
	 * 
	 * @return list of all bids existing in the database
	 */
	List<BidList> bidList();

	/**
	 * Delete the bid ** This operation allows to check if the id of te bid we want
	 * to delete already exist in the database, then allows to use its id to delete
	 * it
	 * 
	 * @param id : id of the bid we want to delete
	 * @throws Exception
	 */
	void deleteBid(Integer id) throws Exception;

}
