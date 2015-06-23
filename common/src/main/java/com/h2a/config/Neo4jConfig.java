/**
 * 
 */
package com.h2a.config;

import javax.annotation.Resource;

import org.omg.CORBA.Environment;

/**
 * @author 
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.h2a.entities", "com.h2a.maintainrelationship"})
@PropertySource(value="classpath:properties/db.properties")
@EnableNeo4jRepositories(basePackages = "com.h2a.repository")
public class Neo4jConfig extends Neo4jAspectConfiguration{

	@Resource
	private Environment env; 
	
	public Neo4jConfig() {
		setBasePackage("com.h2a.entities");
	}
	
	@Bean(name="graphDatabaseService")
	public GraphDatabaseService getGraphDatabaseService(){
		GraphDatabaseFactory databaseService = new GraphDatabaseFactory();
		return databaseService.newEmbeddedDatabase(env.getProperty("db.store.directory"));
	}
	
	private JtaTransactionManagerFactoryBean neo4jTransactionManagerFactoryBean() throws Exception {
		JtaTransactionManagerFactoryBean factoryBean = 
				new JtaTransactionManagerFactoryBean(getGraphDatabaseService());
		return factoryBean;
	}
	
	@Override
	@Bean(name= {"transactionManager"})
	public PlatformTransactionManager neo4jTransactionManager() throws Exception {
		ChainedTransactionManager transactionManager = new ChainedTransactionManager(neo4jTransactionManagerFactoryBean().getObject());
		return transactionManager;
	}
}
