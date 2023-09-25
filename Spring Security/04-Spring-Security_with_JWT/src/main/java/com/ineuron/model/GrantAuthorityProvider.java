package com.ineuron.model;

import org.springframework.security.core.GrantedAuthority;

public class GrantAuthorityProvider implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private  String role;
	
	public GrantAuthorityProvider(String roles) {
		this.role = roles;
	}
	
	

	@Override
	public String getAuthority() {
		return role;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof GrantAuthorityProvider) {
			return role.equals(((GrantAuthorityProvider) obj).role);
		}

		return false;
	}

	public int hashCode() {
		return this.role.hashCode();
	}

	public String toString() {
		return this.role;
	}


}
