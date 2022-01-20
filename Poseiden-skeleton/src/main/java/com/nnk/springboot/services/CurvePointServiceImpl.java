package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointServiceImpl implements ICurvePointService{
	private static final Logger logger = LogManager.getLogger("CurvePointServiceImpl");

	/**
	 * Calling operations of the curvePointRepository
	 */
	@Autowired
	private CurvePointRepository curvePointRepository;

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
	@Override
	public CurvePoint addCurvePoint(CurvePoint curvePoint) throws Exception {
		logger.info("adding a new curve point");
		Optional<CurvePoint> curvePointFound = curvePointRepository.findById(curvePoint.getId());
		if (curvePointFound.isPresent()) {
			logger.error("The curve point id : " + curvePoint.getId() + ", you want to add, is already exists!");
			throw new Exception("The curve point id : " + curvePoint.getId() + ", you want to add, is already exists!");
		}
		logger.info("add curve point id : " + curvePoint.getId());
		return curvePointRepository.save(curvePoint);
	}

	/**
	 * Update information of the curvePoint ** This operation allows to check if the
	 * id of the curvePoint we want to update already exists in the database,
	 * 
	 * @param id         : the id of the bid we want to update
	 * @param curvePoint : the curvePoint Object updated
	 * @return curvePoint object updated
	 * @throws Exception
	 */
	@Override
	public CurvePoint updateCurvePoint(Integer id, CurvePoint curvePoint) throws Exception {
		logger.info("updating the curve point");
		Optional<CurvePoint> curvePointFound = curvePointRepository.findById(curvePoint.getId());
		if (curvePointFound.isEmpty()) {
			logger.error("The curve point id : " + id + ", you want to update, does not exist!");
			throw new Exception("The curve point id : " + id + ", you want to update, does not exist!");
		}
		logger.info("update curve point id : " + id);
		curvePointFound.get().setCurveId(
				curvePoint.getCurveId() != null ? curvePoint.getCurveId() : curvePointFound.get().getCurveId());
		curvePointFound.get()
				.setTerm(curvePoint.getTerm() != null ? curvePoint.getTerm() : curvePointFound.get().getTerm());
		curvePointFound.get()
				.setValue(curvePoint.getValue() != null ? curvePoint.getValue() : curvePointFound.get().getValue());

		return curvePointRepository.saveAndFlush(curvePointFound.get());
	}

	/**
	 * get all curvePoints
	 * 
	 * @return list of all CurvePoints existing in the database
	 */
	@Override
	public List<CurvePoint> curvePointList() {
		logger.info("get list of Bids");
		return curvePointRepository.findAll();

	}

	/**
	 * Delete the CurvePoint ** This operation allows to check if the id of te
	 * CurvePoint we want to delete already exist in the database, then allows to
	 * use its id to delete it
	 * 
	 * @param id : id of the CurvePoint we want to delete
	 * @throws Exception
	 */
	@Override
	public void deleteCurvePoint(Integer id) throws Exception {
		logger.info("deleting a CurvePoint");
		Optional<CurvePoint> curvePointFound = curvePointRepository.findById(id);
		if (curvePointFound.isEmpty()) {
			logger.error("The curve point id : " + id + ", you want to delete, does not exist!");
			throw new Exception("The curve point id : " + id + ", you want to delete, does not exist!");
		}

		logger.info("delete the curve point id " + id);
		curvePointRepository.deleteById(id);
	}

}
