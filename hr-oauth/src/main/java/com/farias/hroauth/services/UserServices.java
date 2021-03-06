package com.farias.hroauth.services;

import com.farias.hroauth.entities.User;
import com.farias.hroauth.feignclients.UserFeignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.email(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new UsernameNotFoundException("Email not found");
        }
        log.info("Email found: " + user.getEmail());
        return user;
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByEmail(username);
	}
}
