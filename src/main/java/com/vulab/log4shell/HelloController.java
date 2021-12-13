package com.vulab.log4shell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

@Controller
public class HelloController {

    private static final Logger logger = LogManager.getLogger("LoginForm");

    @GetMapping(value = "/")
	public String hello() {
        return "index";
    }

    @PostMapping("/")
    public ModelAndView doLogin(@RequestBody String email) {
        try {
            logger.info("Failed login attempt " + URLDecoder.decode(email, "UTF-8"));
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView aView = new ModelAndView();
        aView.setViewName("index");
        aView.addObject("loginResult", "Login failed. Your attempt was logged.");
        return aView;
    }

}
