/**
 * 
 */
package com.h2a.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Harish Sisodia
 *
 */
@Configuration
@EnableWebMvc
@Import(value={ThymeleafConfig.class})
@ComponentScan(value={"com.h2a.controller", "com.h2a.service.impl"})
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{

}
