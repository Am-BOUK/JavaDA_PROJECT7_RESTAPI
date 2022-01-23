package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.exception.EntityAlreadyExistException;
import com.nnk.springboot.exception.EntityNotFoundException;

public interface ITradeService {
	/**
	 * Get One trade object ** This operation allows to check if the id of the trade
	 * we want to get his information already exist in the database, then allows to
	 * use its id to get him
	 * 
	 * @param id : id of the trade object which we want to get
	 * @return trade object if it exists
	 * @throws EntityNotFoundException
	 */
	Trade getTrade(Integer id) throws EntityNotFoundException;

	/**
	 * 
	 * Add a new Trade ** This operation allows to check if the id of the Trade we
	 * want to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param Trade : Trade object to add
	 * @return Trade object added
	 */
	Trade addNewTrade(Trade trade);

	/**
	 * Update information of the Trade ** This operation allows to check if the id
	 * of the Trade we want to update already exists in the database,
	 * 
	 * @param id    : the id of the Trade we want to update
	 * @param Trade : the Trade Object updated
	 * @return Trade object updated
	 * @throws EntityNotFoundException
	 */
	Trade updateTradee(Integer id, Trade trade) throws EntityNotFoundException;

	/**
	 * get all Trades
	 * 
	 * @return list of all Trades existing in the database
	 */
	List<Trade> tradesList();

	/**
	 * Delete the Trade ** This operation allows to check if the id of the Trade we
	 * want to delete already exist in@Override the database, then allows to use its
	 * id to delete it
	 * 
	 * @param id : id of the Trade we want to delete
	 * @throws EntityNotFoundException
	 */
	void deleteTrade(Integer id) throws EntityNotFoundException;
}
