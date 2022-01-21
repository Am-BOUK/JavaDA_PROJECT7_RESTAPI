package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.exception.EntityAlreadyExistException;
import com.nnk.springboot.exception.EntityNotFoundException;
import com.nnk.springboot.services.ICurvePointService;

/**
 * Implementing the management of interactions between the application
 * curvePoint and the application.
 *
 */
@Controller
public class CurveController {
	private static final Logger logger = LogManager.getLogger("CurveController");
	/**
	 * Inject Curve Point service
	 */
	@Autowired
	private ICurvePointService curveService;

	/**
	 * Read-Get list of all Curve Point
	 * 
	 * @param model : Model defines a holder for all Curve Point list attributes and
	 *              is primarily designed for adding attributes to the model
	 * @return a list of all Curve Point page web
	 */
	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		logger.info("Get list of all Curve Point to show to the view");
		model.addAttribute("curves", curveService.curvePointList());
		return "curvePoint/list";
	}

	/**
	 * show Add curvePoint Page ** this method allows to show a form which we fill
	 * the curvePoint information
	 * 
	 * @param curvePoint
	 * @return Add user Page
	 */
	@GetMapping("/curvePoint/add")
	public String addBidForm(CurvePoint curvePoint) {
		logger.info("Show Add curvePoint Page");
		return "curvePoint/add";
	}

	/**
	 * validate curvePoint added ** this method allows to save a curvePoint
	 * information which we have fill in the form
	 * 
	 * @param model      : Model defines a holder for curvePoint attributes and is
	 *                   primarily designed for adding attributes to the model
	 * @param curvePoint : curvePoint object filling in the form
	 * @param result     : BindingResult holds the result of a validation and
	 *                   binding and contains errors that may have occurred.
	 * @return a list of curvePoints page web
	 * @throws EntityAlreadyExistException
	 */
	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model)
			throws EntityAlreadyExistException {
		// TODO: check data valid and save to db, after saving return Curve list
		logger.info("Validate curvePoint Add");
		if (!result.hasErrors()) {
			logger.info("Get all curve point List");
			curveService.addCurvePoint(curvePoint);
			model.addAttribute("curves", curveService.curvePointList());
			return "redirect:/curvePoint/list";
		}
		return "curvePoint/add";
	}

	/**
	 * show update curvePoint Form ** this method allows to show a form which we
	 * fill the curvePoint information to update
	 * 
	 * @param id    : id of the user object to update
	 * @param model : Model defines a holder for user attributes and is primarily
	 *              designed for adding attributes to the model
	 * @return update user Page
	 * @throws EntityNotFoundException
	 */
	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws EntityNotFoundException {
		// TODO: get CurvePoint by Id and to model then show to the form
		logger.info("Show Update Form");
		CurvePoint curvePoint = curveService.getCurvePoint(id);
		model.addAttribute("curvePoint", curvePoint);
		return "curvePoint/update";
	}

	/**
	 * update curvePoint ** this method allows to save a curvePoint information
	 * updated which we have fill in the form
	 * 
	 * @param id         : id of the curvePoint object to update
	 * @param curvePoint : curvePoint object updated in the form
	 * @param result     : BindingResult holds the result of a validation and
	 *                   binding and contains errors that may have occurred.
	 * @param model      : Model defines a holder for curvePoints list attributes
	 *                   and is primarily designed for adding attributes to the
	 *                   model
	 * @return a list of all curvePoint page web
	 * @throws EntityNotFoundException
	 */
	@PostMapping("/curvePoint/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result,
			Model model) throws EntityNotFoundException {
		// TODO: check required fields, if valid call service to update Curve and return
		// Curve list
		logger.info("Validate Update curvePoint");
		if (result.hasErrors()) {
			return "curvePoint/update";
		}
		logger.info("Get all curve point List");
		curveService.updateCurvePoint(id, curvePoint);
		model.addAttribute("curves", curveService.curvePointList());
		return "redirect:/curvePoint/list";
	}

	/**
	 * Delete-Remove a curvePoint ** this method allows to delete the curvePoint
	 * object
	 * 
	 * @param id    : id of the curvePoint object to delete
	 * @param model : Model defines a holder for curvePoints list attributes and is
	 *              primarily designed for adding attributes to the model
	 * @return a list curvePoints page web
	 * @throws EntityNotFoundException
	 */
	@GetMapping("/curvePoint/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) throws EntityNotFoundException {
		logger.info("Delete curvePoint");
		curveService.deleteCurvePoint(id);
		logger.info("Get all curve point List");
		model.addAttribute("curves", curveService.curvePointList());
		return "redirect:/curvePoint/list";
	}
}
