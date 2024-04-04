package com.remotehiring.Services;

import java.util.List;
import com.remotehiring.entities.Users;
import com.remotehiring.Repositories.UsersRepository;
import com.remotehiring.exceptions.UserNotFoundException; // Import the custom exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;

	public List<Users> listAll() {
		return repo.findAll();
	}

	public void save(Users users) {
		repo.save(users);
	}

	public Users get(String email) {
		return repo.findById(email)
				.orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
	}

	public void delete(String email) {
		if (!repo.existsById(email)) {
			throw new UserNotFoundException("User not found with email: " + email);
		}
		repo.deleteById(email);
	}

	public boolean checkuser(String email) {
		return repo.existsById(email);
	}

	public boolean checklogin(String emailid, String pass) {
		if (checkuser(emailid)) {
			Users users = get(emailid);
			return users.getPassword().equals(pass);
		}
		return false;
	}
}

