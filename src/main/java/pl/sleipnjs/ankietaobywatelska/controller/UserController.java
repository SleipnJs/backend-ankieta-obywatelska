package pl.sleipnjs.ankietaobywatelska.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.sleipnjs.ankietaobywatelska.model.User;
import pl.sleipnjs.ankietaobywatelska.repository.RoleRepository;
import pl.sleipnjs.ankietaobywatelska.repository.UsersRepository;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = usersRepository.findById(id);

		if (userData.isPresent() && id == user.getId()) {
			User _user = userData.get();
			_user.setEmail(user.getEmail());
			_user.setUsername(user.getUsername());

			return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/userPassword/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> updateUserPassword(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = usersRepository.findById(id);
		if (userData.isPresent() && id == user.getId()) {
			User _user = userData.get();
			_user.setPassword(encoder.encode(user.getPassword()));

			return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
