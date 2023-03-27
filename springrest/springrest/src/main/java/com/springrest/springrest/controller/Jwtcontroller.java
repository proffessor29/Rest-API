package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Userdetails.CustomUserDetails;
import com.springrest.springrest.helper.JwtUtil;
import com.springrest.springrest.model.JwtRequest;
import com.springrest.springrest.model.JwtResponse;

@RestController
public class Jwtcontroller {
    
    @Autowired
    private AuthenticationManager authenticationManager ;

    @Autowired
    private CustomUserDetails customUserDetails ;

    @Autowired
    private JwtUtil jwtUtil ;
    

    @RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (DisabledException e) {
			e.printStackTrace();
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		UserDetails userDetails = this.customUserDetails.loadUserByUsername(jwtRequest.getUsername()) ;

		String token =  this.jwtUtil.generateToken(userDetails) ;


		return ResponseEntity.ok(new JwtResponse(token)) ;



	}
}

