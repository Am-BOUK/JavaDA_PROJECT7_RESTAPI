package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListServiceImpl implements IBidListService {

	private static final Logger logger = LogManager.getLogger("BidListServiceImpl");

	/**
	 * Calling operations of the bidListRepository
	 */
	@Autowired
	private BidListRepository bidListRepository;

	/**
	 * 
	 * Add a new bid ** This operation allows to check if the id of the bide we want
	 * to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param bid : BidList object to add
	 * @return BidList object added
	 * @throws Exception
	 */
	@Override
	public BidList addNewBid(BidList bid) throws Exception {
		logger.info("adding new Bid");
		Optional<BidList> bidFound = bidListRepository.findById(bid.getBidListId());
		if (bidFound.isPresent()) {
			logger.error("The dib id : " + bid.getBidListId() + ", you want to add, is already exists!");
			throw new Exception("The dib id : " + bid.getBidListId() + ", is already exists!");
		}

		logger.info("add bid id : " + bid.getBidListId());
		return bidListRepository.save(bid);
	}

	/**
	 * Update information of the bid ** This operation allows to check if the id of
	 * the bid we want to update already exists in the database,
	 * 
	 * @param id  : the id of the bid we want to update
	 * @param bid : the Bid Object updated
	 * @return BidList object updated
	 * @throws Exception
	 */
	@Override
	public BidList updateBide(Integer id, BidList bid) throws Exception {
		logger.info("updating a Bid");
		Optional<BidList> bidFound = bidListRepository.findById(id);
		if (bidFound == null) {
			logger.error("The dib id : " + bid.getBidListId() + ", you want to update, does not exist!");
			throw new Exception("The dib id : " + bid.getBidListId() + ", is already exists!");
		}
		logger.info("update bid id : " + id);
		bidFound.get().setAccount(bid.getAccount() != null ? bid.getAccount() : bidFound.get().getAccount());
		bidFound.get().setType(bid.getType() != null ? bid.getType() : bidFound.get().getType());
		bidFound.get()
				.setBidQuantity(bid.getBidQuantity() != null ? bid.getBidQuantity() : bidFound.get().getBidQuantity());
		return bidListRepository.saveAndFlush(bidFound.get());

	}

	/**
	 * get all Bids
	 * 
	 * @return list of all bids existing in the database
	 */
	@Override
	public List<BidList> bidList() {
		logger.info("get list of Bids");
		return bidListRepository.findAll();

	}

	/**
	 * Delete the bid ** This operation allows to check if the id of te bid we want
	 * to delete already exist in the database, then allows to use its id to delete
	 * it
	 * 
	 * @param id : id of the bid we want to delete
	 * @throws Exception
	 */
	@Override
	public void deleteBid(Integer id) throws Exception {
		logger.info("deleting a Bid");
		Optional<BidList> bidFound = bidListRepository.findById(id);
		if (bidFound.isEmpty()) {
			logger.error("The dib id : " + id + ", you want to delete, does not exist!");
			throw new Exception("The dib id : " + id + ", you want to delete, does not exist!");
		}

		logger.info("delete the Bid id " + id);
		bidListRepository.deleteById(id);

	}

}
