package pl.sleipnjs.ankietaobywatelska.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sleipnjs.ankietaobywatelska.model.FormStage;
import pl.sleipnjs.ankietaobywatelska.repository.FormRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/data")
public class FormResponseController {

	@Autowired
	FormRepository formRepository;

	@GetMapping("/forms")
	public ResponseEntity<FormStage> getForm(@RequestParam(required = true) long id, @RequestParam(required = true) int stage) {
		FormStage formStage = formRepository.findByFormId(id, stage);
		return new ResponseEntity<>(formStage, HttpStatus.OK);
	}

	@PostMapping("/forms")
	public ResponseEntity<FormStage> setForm(@RequestBody FormStage _formStage) {
		try {
			FormStage formStage = formRepository.save(_formStage);
			return new ResponseEntity<>(formStage, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/forms")
	public ResponseEntity<FormStage> updateForm(@RequestBody FormStage _formStage) {
		try {
			FormStage formStage = formRepository.save(_formStage);
			return new ResponseEntity<>(formStage, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
