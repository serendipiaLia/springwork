package org.khit.myapp.service;

import org.khit.myapp.dto.UserDTO;
import org.khit.myapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

	private UserRepository userRepository;
	
	public void save(UserDTO userDTO) {
		userRepository.save(userDTO);
	}

	public boolean login(UserDTO userDTO) {
		// �α����� ����� ��ü�� ��ȯ ����
		UserDTO loginUser = userRepository.login(userDTO);
		if(loginUser != null) {
			return true;
		}else {
			return false; 
		}
	}

} // UserService
