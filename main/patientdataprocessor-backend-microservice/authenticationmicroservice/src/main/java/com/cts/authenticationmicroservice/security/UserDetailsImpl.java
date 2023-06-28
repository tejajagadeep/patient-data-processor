package com.cts.authenticationmicroservice.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;
import com.cts.authenticationmicroservice.model.UserRole;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);

	private UserRole user;
//	private Role user;

	public UserDetailsImpl(UserRole user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		log.info("inside getAuthorities GrantedAuthority Collection of UserDetailsImpl");

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.user.getRole().toUpperCase()));

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {

		log.info("inside getPassword of UserDetailsImpl " + this.user.getPassword());
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {

		log.info("inside getUsername of UserDetailsImpl " + this.user.getUserName());
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {

		log.info("inside isAccountNonExpired of UserDetailsImpl");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		log.info("inside isAccountNonLocked of UserDetailsImpl");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		log.info("inside isCredentialsNonExpired of UserDetailsImpl");
		return true;
	}

	@Override
	public boolean isEnabled() {

		log.info("inside isEnabled of UserDetailsImpl");
		return true;
	}

	public UserRole getUserDetails() {

		log.info("inside getUserDetails of UserDetailsImpl");
		return user;
	}
}