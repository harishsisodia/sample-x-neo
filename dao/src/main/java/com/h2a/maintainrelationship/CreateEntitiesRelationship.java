/**
 * 
 */
package com.h2a.maintainrelationship;


/**
 * @author 
 *
 */
@Component
public class CreateEntitiesRelationship {

	@Autowired
	private Neo4jTemplate neo4jTemplate;
	
	public ActedInRelationship createRelationshipBetweenPersonMovie(Person person, Movie movie, 
			Class<ActedInRelationship> relationshipEntity, String relationshipType){
		ActedInRelationship relationship = neo4jTemplate.createRelationshipBetween(person, movie, relationshipEntity, relationshipType, true);
		neo4jTemplate.save(relationship);
		return relationship;
	}
	
	public FriendsRelationship createRelationshipBetweenPersons(Person person, Person friend, 
			Class<FriendsRelationship> relationshipEntity, String friendshipType) {
		FriendsRelationship relationship = neo4jTemplate.createRelationshipBetween(person, friend, relationshipEntity, friendshipType, true);
		neo4jTemplate.save(relationship);
		return relationship;
	}
}
