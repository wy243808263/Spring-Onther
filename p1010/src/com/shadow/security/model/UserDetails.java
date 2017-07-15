package com.shadow.security.model;

import java.util.Collection;

/**
 * 扩展spring security的org.springframework.security.core.userdetails.UserDetails
 * @author shadow
 * 
 */
public interface UserDetails extends
		org.springframework.security.core.userdetails.UserDetails {

	@SuppressWarnings("unchecked")
	public abstract Collection getResources();
}
