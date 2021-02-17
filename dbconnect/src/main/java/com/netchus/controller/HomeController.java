package com.netchus.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netchus.domain.Criteria;
import com.netchus.service.SensorService;
import com.netchus.util.PageMaker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private SensorService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@GetMapping(value = "/sensor")
	public String sensor(@ModelAttribute Criteria cri, Model model) {
		PageMaker pm = new PageMaker(cri);
		service.setTotalCount(pm);
		// amount 가 10이고 pageNum 이 1일때를 고려해보면
		model.addAttribute("sensorList",service.getListWithPaging(pm.getPageNum(), pm.getAmount()));
		return "sensor";
	}
}