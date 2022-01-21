package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.exception.EntityAlreadyExistException;
import com.nnk.springboot.exception.EntityNotFoundException;

public interface ICurvePointService {
	/**
	 * Get One user Curve point
	 * 
	 * @param curveId : curveId of the curvePoint object whose we want to get
	 * @return curvePoint object if it exists
	 * @throws EntityNotFoundException
	 */
	public CurvePoint getCurvePoint(Integer id) throws EntityNotFoundException;

	/**
	 * 
	 * Add a new curvePoint
	 *
	 * @param curvePoint : curvePoint object to add
	 * @return curvePoint object added
	 * @throws EntityAlreadyExistException
	 */
	public CurvePoint addCurvePoint(CurvePoint curvePoint) throws EntityAlreadyExistException;

	/**
	 * Update information of the curvePoint
	 * 
	 * @param id         : the id of the bid we want to update
	 * @param curvePoint : the curvePoint Object updated
	 * @return curvePoint object updated
	 * @throws EntityNotFoundException
	 */
	CurvePoint updateCurvePoint(Integer id, CurvePoint curvePoint) throws EntityNotFoundException;

	/**
	 * get all curvePoints
	 * 
	 * @return list of all CurvePoints existing in the database
	 */
	List<CurvePoint> curvePointList();

	/**
	 * Delete the CurvePoint
	 * 
	 * @param id : id of the CurvePoint we want to delete
	 * @throws EntityNotFoundException
	 */
	void deleteCurvePoint(Integer id) throws EntityNotFoundException;

}
