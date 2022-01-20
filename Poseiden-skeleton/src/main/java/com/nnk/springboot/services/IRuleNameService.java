package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.RuleName;

public interface IRuleNameService {

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
	RuleName addNewRuleName(RuleName ruleName) throws Exception;

	/**
	 * Update information of the ruleName ** This operation allows to check if the
	 * id of the ruleName we want to update already exists in the database,
	 * 
	 * @param id       : the id of the ruleName we want to update
	 * @param ruleName : the ruleName Object updated
	 * @return ruleName object updated
	 * @throws Exception
	 */
	RuleName updateRuleName(Integer id, RuleName ruleName) throws Exception;

	/**
	 * get all ruleNames
	 * 
	 * @return list of all ruleNames existing in the database
	 */
	List<RuleName> ruleNameList();

	/**
	 * Delete the ruleName ** This operation allows to check if the id of te ruleName we want
	 * to delete already exist in the database, then allows to use its id to delete
	 * it
	 * 
	 * @param id : id of the ruleName we want to delete
	 * @throws Exception
	 */
	void deleteRuleName(Integer id) throws Exception;

}
