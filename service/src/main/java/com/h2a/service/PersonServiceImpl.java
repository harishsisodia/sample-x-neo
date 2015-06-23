/**
 * 
 */
package com.h2a.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 *
 */
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private RepositoryPerson repositoryPerson;
	@Autowired
	private Neo4jTemplate template;
	@Autowired
	private GraphDatabase graphDatabase;
	@Autowired
	private CreateEntitiesRelationship maintainRelationship;
	
	@Override
	public Person save(Person entity) {
		return repositoryPerson.save(entity);
	}

	@Override
	public Person findPersonByProperty(String property, Object value) {
		return repositoryPerson.findBySchemaPropertyValue(property, value);
	}

	/** In the embedded base neo4j database the findAll() method throw an exception:
	 * java.lang.NullPointerException
		at org.neo4j.kernel.TopLevelTransaction.markAsRollbackOnly(TopLevelTransaction.java:93)
		at org.neo4j.kernel.TopLevelTransaction.failure(TopLevelTransaction.java:86)
	 * Because of some transaction behaviour. When apply the @Transaction annotation on the service layer 
	 * still creating the same issue. 
	 * So we need to manage transaction manually as below. If we use external database, i am not sure, this exception
	 * is fixed, but first try to use @Transactional annotation
	 */
	@Override
	public List<Person> getAllPersons() {
		List<Person> personsList = new ArrayList<>();
		try(Transaction transaction = graphDatabase.beginTx()){
			Result<Person> persons = repositoryPerson.findAll();
			personsList = Lists.newArrayList(persons.iterator());
			transaction.success();
		}
		return personsList;
	}

	@Override
	public FriendsRelationship makeFriends(Person person, Person friend, String friendshipType) {
		FriendsRelationship relationship = null;
		try(Transaction transaction = graphDatabase.beginTx()){
			relationship = maintainRelationship.createRelationshipBetweenPersons(person, friend, FriendsRelationship.class, friendshipType);
			transaction.success();
		}
		return relationship;
	}

	@Override
	public void removePerson(Person person) {
		try(Transaction transaction = graphDatabase.beginTx()){
			repositoryPerson.delete(person);
			transaction.success();
		}
	}

	@Override
	public Person updatePerson(Person person) {
		Person returnValue = null;
		try(Transaction transaction = graphDatabase.beginTx()){
			returnValue = repositoryPerson.save(person);
			transaction.success();
		}
		return returnValue;
	}
}
