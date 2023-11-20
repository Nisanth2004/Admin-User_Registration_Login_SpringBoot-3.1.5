package admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import admin_user.model.User;
import admin_user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=userRepository.findByEmail(username);// check if exists
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		// if exists
		return new  CustomUserDetail(user);
	}

}
