package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.Trade;

public interface ITradeService {

	/**
	 * 
	 * Add a new Trade ** This operation allows to check if the id of the Trade we want
	 * to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param Trade : Trade object to add
	 * @return Trade object added
	 * @throws Exception
	 */
	Trade addNewTrade(Trade trade) throws Exception;

	/**
	 * Update information of the Trade ** This operation allows to check if the id
	 * of the Trade we want to update already exists in the database,
	 * 
	 * @param id    : the id of the Trade we want to update
	 * @param Trade : the Trade Object updated
	 * @return Trade object updated
	 * @throws Exception
	 */
	Trade updateTradee(Integer id, Trade trade) throws Exception;

	/**
	 * get all Trades
	 * 
	 * @return list of all Trades existing in the database
	 */
	List<Trade> tradesList();

	/**
	 * Delete the Trade ** This operation allows to check if the id of the Trade we
	 * want to delete already exist in the database, then allows to use its id to
	 * delete it
	 * 
	 * @param id : id of the Trade we want to delete
	 * @throws Exception
	 */
	void deleteTrade(Integer id) throws Exception;

}
