package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.CurvePoint;

public interface ICurvePointService {

	/**
	 * 
	 * Add a new curvePoint ** This operation allows to check if the id of the
	 * curvePoint we want to add already exists in the database, then allows to add
	 * it
	 * 
	 *
	 * @param curvePoint : curvePoint object to add
	 * @return curvePoint object added
	 * @throws Exception
	 */
	CurvePoint addCurvePoint(CurvePoint curvePoint) throws Exception;

	/**
	 * Update information of the curvePoint ** This operation allows to check if the
	 * id of the curvePoint we want to update already exists in the database,
	 * 
	 * @param id         : the id of the bid we want to update
	 * @param curvePoint : the curvePoint Object updated
	 * @return curvePoint object updated
	 * @throws Exception
	 */
	CurvePoint updateCurvePoint(Integer id, CurvePoint curvePoint) throws Exception;

	/**
	 * get all curvePoints
	 * 
	 * @return list of all CurvePoints existing in the database
	 */
	List<CurvePoint> curvePointList();

	/**
	 * Delete the CurvePoint ** This operation allows to check if the id of te
	 * CurvePoint we want to delete already exist in the database, then allows to
	 * use its id to delete it
	 * 
	 * @param id : id of the CurvePoint we want to delete
	 * @throws Exception
	 */
	void deleteCurvePoint(Integer id) throws Exception;

}
