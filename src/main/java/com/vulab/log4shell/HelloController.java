package com.vulab.log4shell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String doLogin(@RequestBody String email, @RequestBody String password) {
        try {
            logger.info("Failed login attempt " + URLDecoder.decode(email, "UTF-8"));
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "index";
    }

}
