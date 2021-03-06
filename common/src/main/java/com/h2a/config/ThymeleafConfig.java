/**
 * 
 */
package com.h2a.config;


/**
 * @author 
 *
 */
@Configuration
public class ThymeleafConfig {

	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setOrder(1);
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
	@Bean
	@Autowired
	public SpringTemplateEngine templateEngine(ServletContextTemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}
	
	@Bean
	@Autowired
	public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(templateEngine);
		return thymeleafViewResolver;
	}
}
