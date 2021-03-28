package pl.sleipnjs.ankietaobywatelska.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sleipnjs.ankietaobywatelska.model.Form;
import pl.sleipnjs.ankietaobywatelska.model.FormResponse;
import pl.sleipnjs.ankietaobywatelska.repository.FormRepository;
import pl.sleipnjs.ankietaobywatelska.repository.FormResponseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/data")
public class FormResponseController {

  @Autowired
  FormResponseRepository formResponseRepository;

  @Autowired
	FormRepository formRepository;

  @GetMapping("/formsResponse")
  public ResponseEntity<Map<String, Map<String, Integer>>> getFormResponses(@RequestParam(required = true) long id) {
    Map<String, Map<String, Integer>> result = new HashMap<>();

    List<FormResponse> responses = formResponseRepository.findByFormId(id);
    for( FormResponse response : responses ) {
      if(result.containsKey(response.getFormKey())) {
        if(result.get(response.getFormKey()).containsKey(response.getResponse())) {
          result.get(response.getFormKey()).put(response.getResponse(), result.get(response.getFormKey()).get(response.getResponse())+1);
        } else {
          result.get(response.getFormKey()).put(response.getResponse(), 1);
        }
      } else {
        result.put(response.getFormKey(), new HashMap<>());
      }
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping("/formsResponse")
  public ResponseEntity<String> setForm(@RequestParam(required = true) long formId, @RequestBody Map<String, Object> responses) {
    try {
      Optional<Form> _formData = formRepository.findById(formId);
      if (_formData.isPresent()) {
        Form _form = _formData.get();
        for (Map.Entry<String, Object> entry : responses.entrySet()) {
          System.out.println(entry.getKey() + ":" + entry.getValue());
          FormResponse formResponse = formResponseRepository.save(new FormResponse(0, _form, entry.getKey(), entry.getValue().toString()));
        }
        _form.setResponseCounter(_form.getResponseCounter() + 1);
        Form savedForm = formRepository.save(_form);
      }
      return new ResponseEntity<>("OK", HttpStatus.CREATED);
    } catch (Exception e) {
        System.out.println(e.toString());
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }
}
