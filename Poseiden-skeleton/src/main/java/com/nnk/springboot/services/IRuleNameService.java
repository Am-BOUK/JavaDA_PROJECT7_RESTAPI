package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.exception.EntityNotFoundException;

public interface IRuleNameService {

	/**
	 * Get One RuleName object
	 * 
	 * @param id : id of the RuleName object whose we want to get
	 * @return RuleName object if it exists
	 * @throws EntityNotFoundException
	 */
	RuleName getRuleName(Integer id) throws EntityNotFoundException;

	/**
	 * 
	 * Add a new RuleName
	 *
	 * @param ruleName : RuleName object to add
	 * @return RuleName object added
	 */
	RuleName addNewRuleName(RuleName ruleName);

	/**
	 * Update information of the ruleName
	 * 
	 * @param id       : the id of the ruleName we want to update
	 * @param ruleName : the ruleName Object updated
	 * @return ruleName object updated
	 * @throws EntityNotFoundException
	 */
	RuleName updateRuleName(Integer id, RuleName ruleName) throws EntityNotFoundException;

	/**
	 * get all ruleNames
	 * 
	 * @return list of all ruleNames existing in the database
	 */
	List<RuleName> ruleNameList();

	/**
	 * Delete the ruleName
	 * 
	 * @param id : id of the ruleName we want to delete
	 * @throws EntityNotFoundException
	 */
	void deleteRuleName(Integer id) throws EntityNotFoundException;

}
