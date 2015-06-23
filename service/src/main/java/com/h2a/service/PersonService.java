/**
 * 
 */
package com.h2a.service;

import java.util.List;

import com.harmeetsingh13.entities.Person;
import com.harmeetsingh13.entities.relationship.FriendsRelationship;

/**
 * @author 
 *
 */
public interface PersonService{
	
	public Person save(Person person);
	public Person findPersonByProperty(String property, Object value);
	public List<Person> getAllPersons();
	public FriendsRelationship makeFriends(Person person, Person friend, String friendshipType);
	public void removePerson(Person person);
	public Person updatePerson(Person person);
}
