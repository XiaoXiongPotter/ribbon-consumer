package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	 @Autowired
	 MyHealthIndicator myHealthChecker;
	
	@GetMapping("/ribbon-consumer")
	public String hello(){
		return restTemplate.getForEntity("http://eureka-client/hello", String.class).getBody();
	}
	
	 
	    @RequestMapping("/up")
	    public String up(@RequestParam("up") Boolean up) {
	        myHealthChecker.setUp(up);
	 
	        return up.toString();
	    }

}
