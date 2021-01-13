package com.lawencon.springboot.security;

import java.io.IOException;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.springboot.model.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		super.setFilterProcessesUrl("/api/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response) throws AuthenticationException {
		
		Users user = new Users();
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPwd()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
		String secretKey = "JDJhJDEwJFNQSXhydGhIeS56RmdiaWlJRmVlWnVvSHVqai50WVJqV1RHWGhnUzI3eS5xSjdLa1p6enNp";
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
		
		String token = Jwts.builder()
				.signWith(key)
				.setSubject(authResult.getName())
				.setExpiration(new Date(new Date().getTime() + 50000))
				.compact();
				
		response.setContentType("application/json");
		response.getWriter().append("{\"token\" : \""+token+"\"}");
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	}
	
}
