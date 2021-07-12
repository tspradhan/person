/**
 * 
 */
package com.marsindia.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marsindia.test.model.Person;

/**
 * @author tumbeswar
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
