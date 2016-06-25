package com.trial.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trial.entities.Cache;
import com.trial.home.service.AppService;

/**
 * @author Shivananda Bhat
 *
 */
@RestController
public class HelloController {
	
	private final AppService appService;
	
	@Autowired
	public HelloController(AppService appService) {
		this.appService = appService;
	}
	
	@RequestMapping("/testCassandra")
	public Cache testRedis() {
		return appService.processRequest();
	}
}
