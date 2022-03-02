package com.women.empowerment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.women.empowerment.services.LikeServiceImpl;


@RestController
public class LikeRestController {
	
	private final LikeServiceImpl ls;
	
	@Autowired
	public LikeRestController(LikeServiceImpl ls) {
		this.ls=ls;
		
	}

}
