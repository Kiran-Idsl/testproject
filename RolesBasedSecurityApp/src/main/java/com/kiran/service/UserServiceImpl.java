package com.kiran.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kiran.entity.User;
import com.kiran.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public int saveuser(User user) {
		// password should encode before saved into db
		String password = user.getPassword();
		// password is encoded by using bcrypt password encode class 
		String encpwd = encoder.encode(password);
		// setting the encoded password to user password
		user.setPassword(encpwd);
		// save the user into db
		user = repo.save(user);
		// get the id of the saved user
		return user.getId();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("auto called");
		//getting entity object by giving email 
		Optional<User> opt= repo.findByEmail(username);
		org.springframework.security.core.userdetails.User springUser=null;
		if(opt.isEmpty()) {
			throw new UsernameNotFoundException("User with Email "+username+" Not found");
		}
		else {
			User user = opt.get();
			//getting all roles
			List<String> roles = user.getRoles();
			Set<GrantedAuthority> ga = new HashSet();
			
			for(String role: roles) {
				// adding roles into simplegrantedauthority
				ga.add(new SimpleGrantedAuthority(role));
			}
			springUser = new org.springframework.security.core.userdetails.User(username, user.getPassword(), ga);
		}
		return springUser;
	}

}
