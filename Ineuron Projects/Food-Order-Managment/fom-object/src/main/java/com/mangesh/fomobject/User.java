package com.mangesh.fomobject;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table(name="users")
public class User{

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@NonNull
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
    
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}