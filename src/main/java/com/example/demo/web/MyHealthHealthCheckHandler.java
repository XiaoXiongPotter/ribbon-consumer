package com.example.demo.web;
import com.netflix.appinfo.HealthCheckHandler;

import com.netflix.appinfo.InstanceInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.actuate.health.Status;

import org.springframework.stereotype.Component;

@Component
public class MyHealthHealthCheckHandler implements HealthCheckHandler{

	 @Autowired
	    private MyHealthIndicator myHealthIndicator;

	    @Override
	    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
	        Status status = myHealthIndicator.health().getStatus();
	        if (status.equals(Status.UP)){
	            return InstanceInfo.InstanceStatus.UP;
	        } else {
	            return InstanceInfo.InstanceStatus.DOWN;
	        }
	    }
}