/**
 * 
 */
package com.marsindia.test.logic;

import java.util.List;

import com.marsindia.test.model.Person;

/**
 * @author tumbeswar
 *
 */
public interface PersonService {
	
	Person addPerson(Person person);

	Person editPerson(Person person);

	List<Person> getAllPerson();

	void deletePerson(int personId);

	int getPersonCount();

}
