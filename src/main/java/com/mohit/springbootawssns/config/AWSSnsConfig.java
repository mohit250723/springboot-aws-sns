package com.mohit.springbootawssns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AWSSnsConfig {
	
	@Bean
	public AmazonSNSClient snsClient() {
		return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion("SPECIFY_REGION").
				withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("ACCESS_KEY", "SECRET_ACCESS_KEY"))).build();
	}

}
