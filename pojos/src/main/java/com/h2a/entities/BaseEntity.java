/**
 * 
 */
package com.h2a.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.neo4j.annotation.GraphId;

/**
 * @author 
 *
 */
@EqualsAndHashCode
@ToString(includeFieldNames=true)
public abstract class BaseEntity {

	@GraphId
	@Getter @Setter
	private Long graphId;
}
