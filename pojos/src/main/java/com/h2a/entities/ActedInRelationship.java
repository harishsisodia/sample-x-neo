/**
 * 
 */
package com.h2a.entities;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;


/**
 * @author Harmeet Singh(Taara)
 *
 */
@RelationshipEntity(type = RelationshipTypes.ACTED_IN)
public class ActedInRelationship extends BaseEntity {

	@StartNode
	@Getter @Setter
	private Person person;
	@EndNode
	@Getter @Setter
	private Movie movie;
	@Getter @Setter
	private String roles;
}
