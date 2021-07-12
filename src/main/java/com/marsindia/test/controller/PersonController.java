/**
 * 
 */
package com.marsindia.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marsindia.test.logic.PersonService;
import com.marsindia.test.model.Person;

/**
 * @author tumbeswar
 *
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonService personService;

	/**
	 * 
	 * @return to get the all person
	 */
	@GetMapping("/allPerson")
	public Iterable<Person> getAllPerson() {
		log.info("##PersonController >> getAllPerson() to get the all Person");
		return personService.getAllPerson();

	}

	/**
	 * @return count the total person
	 */
	@GetMapping("/getPersonCount")
	public int getPersonCount() {
		log.info("##PersonController >> getPersonCount() to get No of Person count");
		return personService.getPersonCount();
	}

	/**
	 * @param personObj to add the person
	 * @return person object
	 */
	@PostMapping("/addPerson")
	public Person addPerson(@RequestBody Person personObj) {
		log.info("##PersonController >> addPerson() to add Person");
		return personService.addPerson(personObj);

	}

	/**
	 * @param id     - to get the person using person id
	 * @param person
	 * @return person
	 */
	@PutMapping("/edit/{id}")
	public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
		log.info("##PersonController >> updatePerson() to edit Person");
		person.setId(id);
		return personService.editPerson(person);

	}

	/**
	 * @param id - delete the person using person id
	 * @return the status
	 */
	@DeleteMapping("/delete/{id}")
	public HttpStatus deletePerson(@PathVariable int id) {
		log.info("##PersonController >> deletePerson() to delete a Person with id");
		personService.deletePerson(id);
		return HttpStatus.OK;

	}

}
