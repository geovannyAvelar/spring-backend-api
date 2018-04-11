package br.com.avelar.backend.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avelar.backend.model.Person;
import feign.RequestLine;

@RestController
@RequestMapping("/person")
public interface PersonApi {
	
	@PostMapping @RequestLine("POST /person")
	public void savePerson(@RequestBody Person person);
	
	@GetMapping @RequestLine("GET /person")
	public List<Person> findAll();
	
}
