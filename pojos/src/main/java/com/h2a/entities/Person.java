package com.h2a.entities;

import java.util.HashSet;
import java.util.Set;


/**
 * @author 
 *
 */
@NodeEntity
@ToString(callSuper=true, exclude={"movies", "friends"})
@EqualsAndHashCode(callSuper = true, exclude = {"name", "movies", "friends"})
public class Person extends BaseEntity{

	@Getter @Setter
	@Indexed(unique = true)
	private Long id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	@RelatedToVia(type = RelationshipTypes.ACTED_IN, direction = Direction.OUTGOING, elementClass = ActedInRelationship.class)
	private Set<ActedInRelationship> movies = new HashSet<ActedInRelationship>();
	@Getter @Setter
	@RelatedToVia(direction = Direction.BOTH)
	private Set<FriendsRelationship> friends;
	
	public ActedInRelationship actedIn(Movie movie, String roleName) {
		ActedInRelationship relationship = new ActedInRelationship();
		relationship.setMovie(movie);
		relationship.setPerson(this);
		relationship.setRoles(roleName);
		this.movies.add(relationship);
		return relationship;
	}
}
