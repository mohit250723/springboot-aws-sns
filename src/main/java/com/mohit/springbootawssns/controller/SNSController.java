package com.mohit.springbootawssns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;

@RestController
@RequestMapping("/sns")
public class SNSController {
	
	@Autowired
	private AmazonSNSClient snsClient;
	
	@GetMapping("/subscribe/{email}")
	public String addSubscriptionToSNSTopic(@PathVariable String email) {
		snsClient.subscribe("ARN_SNS", "email", email);
		return "Subscription added for email::"+email;
	}
	
	@GetMapping("/publish")
	public String publishMessage() {
		snsClient.publish("ARN_SNS", defaultMessageFromSNS(), "Hey Man From AWS-Spring boot");
		return "Message Published to the subscribed items";
		}

	private String defaultMessageFromSNS() {
		
		return  "Hey Man, \n"
				+ "This is the message sent from Spring boot local microservice. \n"
				+ "You are getting this Message because your email is subscribed with My SNS Topic.. \n"
				+"Thanks, \n"
				+"Mohit";
	}

}
