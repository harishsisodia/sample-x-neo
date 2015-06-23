/**
 * 
 */
package com.h2a.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.harmeetsingh13.config.ApplicationContextConfig;
import com.harmeetsingh13.config.Neo4jConfig;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[]{Neo4jConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
	return new Class<?>[]{ApplicationContextConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
	return new String[]{"/"};
	}
}
