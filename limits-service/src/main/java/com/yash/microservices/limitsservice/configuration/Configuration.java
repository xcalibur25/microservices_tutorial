package com.yash.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*Field configuration in com.yash.microservices.limitsservice.controller.
 * LimitController required a bean of type 'com.yash.microservices.limitsservice.configuration.Configuration' 
 * that could not be found.
 * Put @Component annotation
*/
@Component
@ConfigurationProperties("limits-service") // values are mapped from properties files
public class Configuration {
	private int minimum;
	private int maximum;

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
