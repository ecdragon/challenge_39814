package com.ecdragon.challenge_39814.features.home_page;

import java.lang.invoke.MethodHandles;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomePageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@RequestMapping(value = {"/home", "/*", "/index.html", "/health"})
	@ResponseBody
	public Object home(
			HttpSession httpSession
			) {
		String okResponse = "Challenge39814 is OK";
		logger.info(okResponse);
		return okResponse;
	}
}
