package com.greatlearning.CustomerRelationshipManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
@RequestMapping ("/")
public String classtest (){
	return "simple";
}
}
