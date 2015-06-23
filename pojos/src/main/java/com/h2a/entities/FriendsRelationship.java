/**
 * 
 */
package com.h2a.entities;



/**
 * @author 
 *
 */
@RelationshipEntity(type=RelationshipTypes.FRIEND)
public class FriendsRelationship extends BaseEntity{

	@Fetch @StartNode
	@Getter @Setter
	private Person person;
	@Fetch @EndNode
	@Getter @Setter
	private Person friend;
	@Getter @Setter
	private String friendsType;
}
