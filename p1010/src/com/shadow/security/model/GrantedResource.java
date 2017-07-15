package com.shadow.security.model;

import java.io.Serializable;

/**
 * 安全资源
 * 
 * @author shadow
 * 
 */
public interface GrantedResource extends Serializable {

	public abstract String getResource();
}
