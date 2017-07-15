package com.cangyue.kyle.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cangyue.kyle.Service.Service;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport{

	@Autowired
	private Service service;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4108915843413766146L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String test(){
		service.test();
		System.out.println(" ‰≥ˆ≤‚ ‘:"+name);
		return "test";
	}
	
}
