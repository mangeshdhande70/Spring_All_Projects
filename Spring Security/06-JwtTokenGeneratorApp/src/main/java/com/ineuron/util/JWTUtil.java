package com.ineuron.util;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
	
	public static String generateToken(String id,String subject,String secretekey) {
		
		 Map<String, Object> claims = new HashMap<>();
	     claims.put("Name", "Mangesh Dhande");
	     claims.put("age", 24);
	     return createToken(id,subject,secretekey,claims);
		
	}
		
	public static String createToken(String id,String subject,String secretekey,Map<String, Object> claims) {
		return Jwts
			.builder()
			.setId(id)
			.setSubject(subject)
			.setIssuer("PWSKILLS")
			.setClaims(claims)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
			.signWith(SignatureAlgorithm.HS256,Base64.getEncoder().encode(secretekey.getBytes()))
			.compact();
			
	}
	
	public static Claims getClaims(String secretKey, String token) {	
		
		return Jwts.parser()
				    .setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
				    .parseClaimsJws(token)
				    .getBody();
		
	}
	
	public static boolean isValidToken(String secretKey,String token) {
		Date tokenExpDate = getClaims(secretKey, token).getExpiration();
		Date date = new Date();
		System.out.println("Date => "+date );
		return date.before(tokenExpDate);
		
	}
}
