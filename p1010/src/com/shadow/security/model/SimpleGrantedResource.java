package com.shadow.security.model;

import org.springframework.util.Assert;

/**
 * 安全资源实现体
 * 
 * @author shadow
 *
 */
public final class SimpleGrantedResource implements GrantedResource {

	public SimpleGrantedResource(String resource) {
		Assert.hasText(resource,
				"A granted resource textual representation is required");
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof SimpleGrantedResource)
			return resource.equals(((SimpleGrantedResource) obj).resource);
		else
			return false;
	}

	public int hashCode() {
		return resource.hashCode();
	}

	public String toString() {
		return resource;
	}

	private static final long serialVersionUID = 310L;
	private final String resource;
}