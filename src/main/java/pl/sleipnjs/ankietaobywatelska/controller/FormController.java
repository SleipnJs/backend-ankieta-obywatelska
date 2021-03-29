package pl.sleipnjs.ankietaobywatelska.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sleipnjs.ankietaobywatelska.model.Form;
import pl.sleipnjs.ankietaobywatelska.model.FormStage;
import pl.sleipnjs.ankietaobywatelska.repository.FormRepository;
import pl.sleipnjs.ankietaobywatelska.repository.FormStageRepository;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/data")
public class FormController {

  @Autowired
  FormStageRepository formStageRepository;

  @Autowired
  FormRepository formRepository;

  @GetMapping("/forms")
  public ResponseEntity<FormStage> getForm(@RequestParam(required = true) long id, @RequestParam(required = true) int stage) {
    FormStage formStage = formStageRepository.findByFormId(id, stage);
    return new ResponseEntity<>(formStage, HttpStatus.OK);
  }

  @GetMapping("/formsMostLiked")
  public ResponseEntity<Iterable<Form>> getMostLiked(@RequestParam(required = true) int amount) {
    Iterable<Form> mostLiked = formRepository.fintMostLiked(amount);
    return new ResponseEntity<>(mostLiked, HttpStatus.OK);
  }

  @PostMapping("/forms")
  public ResponseEntity<String> setForm(@RequestBody Map<String, Object> responseHolder) {
    Map<String, Object> formStage = (Map<String, Object>) responseHolder.get("responses");
    String imageHref = (String) responseHolder.get("imageHref");
  	Form form = formRepository.save(new Form(0, (String) formStage.get("form_title"), (String) formStage.get("form_description"), imageHref, 0, "", "","28.03.2020"));

		JSONObject obj = new JSONObject();
  	try {
			obj = new JSONObject(formStage.get("form_content").toString());
		} catch(Exception e) {
  		System.out.println(e.toString());
		}
  	FormStage _formStage = new FormStage(0, 1, obj.toString(), form);
    try {
    	formStageRepository.save(_formStage);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/forms")
  public ResponseEntity<FormStage> updateForm(@RequestBody FormStage _formStage) {
    try {
      FormStage formStage = formStageRepository.save(_formStage);
      return new ResponseEntity<>(formStage, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }
}
