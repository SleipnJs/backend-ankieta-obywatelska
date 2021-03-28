package pl.sleipnjs.ankietaobywatelska.controller;

import pl.sleipnjs.ankietaobywatelska.model.Role;
import pl.sleipnjs.ankietaobywatelska.model.User;
import pl.sleipnjs.ankietaobywatelska.repository.RoleRepository;
import pl.sleipnjs.ankietaobywatelska.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class UsersController {

	@Autowired
    UsersRepository usersRepository;

	@Autowired
    RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
		try {
			List<User> users = new ArrayList<>();

			if (name == null)
				users.addAll(usersRepository.findAll());
			else
				users.addAll(usersRepository.findByUsernameContaining(name));

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		Optional<User> userData = usersRepository.findById(id);

		return userData.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = usersRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setEmail(user.getEmail());
			_user.setUsername(user.getUsername());
			_user.setRoles(user.getRoles());

			return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/usersPassword/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> updateUserPassword(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = usersRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setPassword(encoder.encode(user.getPassword()));

			return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			usersRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/users/roles")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Role>> getRoles() {
		try {
			List<Role> roles = roleRepository.findAll();
			return new ResponseEntity<>(roles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
