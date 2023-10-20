package com.mangesh.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.mangesh.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApplicationUserDTO {
	
	private Long userId;
    private String email;
	private String firstName;
	private String lastName;
    private Long contactNo;
    private Address address;
    private String roles;
    private String password;
    private List<GrantedAuthority> authorities;
    
    


}
