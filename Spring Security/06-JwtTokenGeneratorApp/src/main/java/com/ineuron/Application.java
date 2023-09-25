package com.ineuron;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ineuron.util.JWTUtil;

import io.jsonwebtoken.Claims;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		
        final String secretKey = "12345678";
        String subject = "md7@gmail.com";
        
		String token = JWTUtil.generateToken("TRA_SCTN", subject, secretKey);

		System.out.println(token);
		
		
		Claims claims = JWTUtil.getClaims(secretKey, token);
		System.out.println("Id is ==> "+claims.getId());
		System.out.println("Subject ===> "+claims.getSubject());
		System.out.println("Issuer ===> "+claims.getIssuer() );
		System.out.println("Issue Date ===> "+claims.getIssuedAt());
		System.out.println("Expiration Date ==> "+claims.getExpiration());
		String name = (String) claims.get("Name");
		System.out.println("Name ==> "+name);
		int age = (int) claims.get("age");
		System.out.println("AGE ==> "+age);
		
	
		
		
		System.out.println("is token Valid => "+JWTUtil.isValidToken(secretKey, token));
		
		
		
	}

}
