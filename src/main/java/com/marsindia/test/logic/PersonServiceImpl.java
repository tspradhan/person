/**
 * 
 */
package com.marsindia.test.logic;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marsindia.test.exception.PersonResourceNotFoundException;
import com.marsindia.test.model.Person;
import com.marsindia.test.repository.PersonRepository;

/**
 * @author tumbeswar
 *
 */
@Service
public class PersonServiceImpl implements PersonService{
private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person addPerson(Person person) {
		log.info("##PersonServiceImpl >> addPerson() to add person");
		return personRepository.save(person);
	}

	
	@Override
	public Person editPerson(Person person) {
		Optional<Person> personId = this.personRepository.findById(person.getId());

		log.debug("inside ##PersonServiceImpl Going to editPerson()>> FirstName : {} and person LastName : {} with person id :{}", person.getFirstName(),person.getLastName(),person.getId());

		if (personId.isPresent()) {
			Person updatePerson = personId.get();
			updatePerson.setId(person.getId());
			updatePerson.setFirstName(person.getFirstName());
			updatePerson.setLastName(person.getLastName());
			personRepository.save(updatePerson);
			return updatePerson;
		} else {
			throw new PersonResourceNotFoundException("Person Record not found with id : " + person.getId());
		}

	}

	@Override
	public List<Person> getAllPerson() {
		log.info("##PersonServiceImpl >> getAllPerson() to get person");
		return personRepository.findAll();
	}

	@Override
	public int getPersonCount() {
		log.info("##PersonServiceImpl >> getPersonCount() to get person count");
		return personRepository.findAll().size();

	}

	@Override
	public void deletePerson(int personId) throws PersonResourceNotFoundException {
		log.debug("inside ##PersonServiceImpl Going to deletePerson()>> with person id :{}", personId);
		Optional<Person> personDb = this.personRepository.findById(personId);
		if (personDb.isPresent()) {
			this.personRepository.delete(personDb.get());
		} else {
			throw new PersonResourceNotFoundException("Person Record not found with id : " + personId);
		}

	}

}
