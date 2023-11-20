package admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User save(UserDto userDto) {
		User user=new User(userDto.getEmail(),passwordEncoder.encode(userDto.getPassword()),userDto.getRole(),userDto.getFullname());
		return userRepository.save(user);
	}

	


	

}
