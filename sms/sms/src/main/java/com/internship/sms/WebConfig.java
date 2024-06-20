/**
 * 
 */
package com.internship.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${staff.file.path.mapping}")
	private String staffFileMapping;

	@Value("${staff.file.path.configPath}")
	private String staffActualFileConfigPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(staffFileMapping).addResourceLocations(staffActualFileConfigPath)
				.setCachePeriod(3600);
	}

}
