package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeServiceImpl implements ITradeService {
	private static final Logger logger = LogManager.getLogger("TradeServiceImpl");

	/**
	 * Calling operations of the TradeRepository
	 */
	@Autowired
	private TradeRepository tradeRepository;

	/**
	 * 
	 * Add a new Trade ** This operation allows to check if the id of the Trade we
	 * want to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param Trade : Trade object to add
	 * @return Trade object added
	 * @throws Exception
	 */
	@Override
	public Trade addNewTrade(Trade trade) throws Exception {
		logger.info("adding new Trade");
		Optional<Trade> tradeFound = tradeRepository.findById(trade.getTradeId());
		if (tradeFound.isPresent()) {
			logger.error("The trade id : " + trade.getTradeId() + ", you want to add, is already exists!");
			throw new Exception("The trade id : " + trade.getTradeId() + ", is already exists!");
		}

		logger.info("add Trade id : " + trade.getTradeId());
		return tradeRepository.save(trade);
	}

	/**
	 * Update information of the Trade ** This operation allows to check if the id
	 * of the Trade we want to update already exists in the database,
	 * 
	 * @param id    : the id of the Trade we want to update
	 * @param Trade : the Trade Object updated
	 * @return Trade object updated
	 * @throws Exception
	 */
	@Override
	public Trade updateTradee(Integer id, Trade trade) throws Exception {
		logger.info("updating a Trade");
		Optional<Trade> tradeFound = tradeRepository.findById(id);
		if (tradeFound.isEmpty()) {
			logger.error("The trade id : " + trade.getTradeId() + ", you want to update, does not exist!");
			throw new Exception("The trade id : " + trade.getTradeId() + ", is already exists!");
		}

		logger.info("update Trade id : " + id);
		tradeFound.get().setAccount(trade.getAccount() != null ? trade.getAccount() : tradeFound.get().getAccount());
		tradeFound.get().setType(trade.getType() != null ? trade.getType() : tradeFound.get().getType());
		tradeFound.get()
				.setBenchmark(trade.getBenchmark() != null ? trade.getBenchmark() : tradeFound.get().getBenchmark());
		tradeFound.get().setBook(trade.getBook() != null ? trade.getBook() : tradeFound.get().getBook());
		tradeFound.get()
				.setBuyPrice(trade.getBuyPrice() != null ? trade.getBuyPrice() : tradeFound.get().getBuyPrice());
		tradeFound.get().setBuyQuantity(
				trade.getBuyQuantity() != null ? trade.getBuyQuantity() : tradeFound.get().getBuyQuantity());
		tradeFound.get().setCreationDate(
				trade.getCreationDate() != null ? trade.getCreationDate() : tradeFound.get().getCreationDate());
		tradeFound.get().setCreationName(
				trade.getCreationName() != null ? trade.getCreationName() : tradeFound.get().getCreationName());
		tradeFound.get()
				.setDealName(trade.getDealName() != null ? trade.getDealName() : tradeFound.get().getDealName());
		tradeFound.get()
				.setDealType(trade.getDealType() != null ? trade.getDealType() : tradeFound.get().getDealType());
		tradeFound.get().setRevisionDate(
				trade.getRevisionDate() != null ? trade.getRevisionDate() : tradeFound.get().getRevisionDate());
		tradeFound.get().setRevisionName(
				trade.getRevisionName() != null ? trade.getRevisionName() : tradeFound.get().getRevisionName());
		tradeFound.get()
				.setSecurity(trade.getSecurity() != null ? trade.getSecurity() : tradeFound.get().getSecurity());
		tradeFound.get()
				.setSellPrice(trade.getSellPrice() != null ? trade.getSellPrice() : tradeFound.get().getSellPrice());
		tradeFound.get().setSellQuantity(
				trade.getSellQuantity() != null ? trade.getSellQuantity() : tradeFound.get().getSellQuantity());
		tradeFound.get().setSide(trade.getSide() != null ? trade.getSide() : tradeFound.get().getSide());
		tradeFound.get().setSourceListId(
				trade.getSourceListId() != null ? trade.getSourceListId() : tradeFound.get().getSourceListId());
		tradeFound.get().setStatus(trade.getStatus() != null ? trade.getStatus() : tradeFound.get().getStatus());
		tradeFound.get()
				.setTradeDate(trade.getTradeDate() != null ? trade.getTradeDate() : tradeFound.get().getTradeDate());
		tradeFound.get().setTrader(trade.getTrader() != null ? trade.getTrader() : tradeFound.get().getTrader());

		return tradeRepository.saveAndFlush(tradeFound.get());

	}

	/**
	 * get all Trades
	 * 
	 * @return list of all Trades existing in the database
	 */
	@Override
	public List<Trade> tradesList() {
		logger.info("get list of Trades");
		return tradeRepository.findAll();

	}

	/**
	 * Delete the Trade ** This operation allows to check if the id of the Trade we
	 * want to delete already exist in the database, then allows to use its id to
	 * delete it
	 * 
	 * @param id : id of the Trade we want to delete
	 * @throws Exception
	 */
	@Override
	public void deleteTrade(Integer id) throws Exception {
		logger.info("deleting a Trade");
		Optional<Trade> tradeFound = tradeRepository.findById(id);
		if (tradeFound.isEmpty()) {
			logger.error("The trade id : " + id + ", you want to delete, does not exist!");
			throw new Exception("The trade id : " + id + ", you want to delete, does not exist!");
		}

		logger.info("delete the Trade id " + id);
		tradeRepository.deleteById(id);

	}
}
