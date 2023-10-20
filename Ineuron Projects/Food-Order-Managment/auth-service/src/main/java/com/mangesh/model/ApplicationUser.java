package com.mangesh.model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Data
@Entity
@Table(name="users")
public class ApplicationUser implements UserDetails{

    
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
	@Column(unique=true)
    private String email;
	private String firstName;
	private String lastName;
    private String password;
    
    @Column(name = "contact_no")
    private Long contactNo;
    
    @Embedded
    private Address address;

    @Transient
    private String roles;
	
    @ElementCollection(fetch = FetchType.EAGER)
	private List<GrantedAuthority> authorities = new ArrayList<>();
	
    public Long getUserId() {
		return this.userId;
	}
	
	public void setId(Long userId) {
		this.userId = userId;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
	public void setUsername(String email) {
		this.email = email;
	}
	
	/* If you want account locking capabilities create variables and ways to set them for the methods below */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
}