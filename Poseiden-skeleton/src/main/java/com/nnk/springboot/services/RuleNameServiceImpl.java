package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameServiceImpl implements IRuleNameService {

	private static final Logger logger = LogManager.getLogger("RuleNameServiceImpl");

	/**
	 * Calling operations of the bidListRepository
	 */
	@Autowired
	private RuleNameRepository ruleNameRepository;

	/**
	 * 
	 * Add a new RuleName ** This operation allows to check if the id of the
	 * RuleName we want to add already exists in the database, then allows to add it
	 * 
	 *
	 * @param ruleName : RuleName object to add
	 * @return RuleName object added
	 * @throws Exception
	 */
	@Override
	public RuleName addNewRuleName(RuleName ruleName) throws Exception {
		logger.info("adding new RuleName");
		Optional<RuleName> ruleNameFound = ruleNameRepository.findById(ruleName.getId());
		if (ruleNameFound.isPresent()) {
			logger.error("The ruleName id : " + ruleName.getId() + ", you want to add, is already exists!");
			throw new Exception("The ruleName id : " + ruleName.getId() + ", is already exists!");
		}

		logger.info("add ruleName id : " + ruleName.getId());
		return ruleNameRepository.save(ruleName);
	}

	/**
	 * Update information of the ruleName ** This operation allows to check if the
	 * id of the ruleName we want to update already exists in the database,
	 * 
	 * @param id       : the id of the ruleName we want to update
	 * @param ruleName : the ruleName Object updated
	 * @return ruleName object updated
	 * @throws Exception
	 */
	@Override
	public RuleName updateRuleName(Integer id, RuleName ruleName) throws Exception {
		logger.info("updating a RuleName");
		Optional<RuleName> ruleNameFound = ruleNameRepository.findById(ruleName.getId());
		if (ruleNameFound.isEmpty()) {
			logger.error("The ruleName id : " + id + ", you want to update, does not exist!");
			throw new Exception("The ruleName id : " + id + ", is already exists!");
		}
		logger.info("update ruleName id : " + id);
		ruleNameFound.get().setName(ruleName.getName() != null ? ruleName.getName() : ruleNameFound.get().getName());
		ruleNameFound.get().setDescription(
				ruleName.getDescription() != null ? ruleName.getDescription() : ruleNameFound.get().getDescription());
		ruleNameFound.get().setJson(ruleName.getJson() != null ? ruleName.getJson() : ruleNameFound.get().getJson());
		ruleNameFound.get()
				.setSqlPart(ruleName.getSqlPart() != null ? ruleName.getSqlPart() : ruleNameFound.get().getSqlPart());
		ruleNameFound.get()
				.setSqlStr(ruleName.getSqlStr() != null ? ruleName.getSqlStr() : ruleNameFound.get().getSqlStr());
		ruleNameFound.get().setTemplate(
				ruleName.getTemplate() != null ? ruleName.getTemplate() : ruleNameFound.get().getTemplate());
		return ruleNameRepository.saveAndFlush(ruleNameFound.get());

	}

	/**
	 * get all ruleNames
	 * 
	 * @return list of all ruleNames existing in the database
	 */
	@Override
	public List<RuleName> ruleNameList() {
		logger.info("get list of RuleNames");
		return ruleNameRepository.findAll();

	}

	/**
	 * Delete the ruleName ** This operation allows to check if the id of te
	 * ruleName we want to delete already exist in the database, then allows to use
	 * its id to delete it
	 * 
	 * @param id : id of the ruleName we want to delete
	 * @throws Exception
	 */
	@Override
	public void deleteRuleName(Integer id) throws Exception {
		logger.info("deleting a RuleName");
		Optional<RuleName> ruleNameFound = ruleNameRepository.findById(id);
		if (ruleNameFound.isEmpty()) {
			logger.error("The ruleName id : " + id + ", you want to delete, does not exist!");
			throw new Exception("The ruleName id : " + id + ", you want to delete, does not exist!");
		}

		logger.info("delete the ruleName id " + id);
		ruleNameRepository.deleteById(id);

	}
}
