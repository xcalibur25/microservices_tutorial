package com.yash.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean someBean() {
		return new SomeBean("value1", "value2", "value3");
	}

	@GetMapping("/filtering-list")
	public List<SomeBean> listOfSomeBeans() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value12", "value22", "value32"));
	}

	// dynamic filtering for field1,field 2
	@GetMapping("/filteringsomebean")
	public MappingJacksonValue someSampleBean() {
		SomeSampleBean someSampleBeanVar = new SomeSampleBean("value1", "value2", "value3");
		// filter all the other fields except field1 and field2
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someSampleBeanVar);
		mapping.setFilters(filters);
		return mapping;
	}

	// dynamic filtering for field2,field3
	@GetMapping("/filteringsomebean-list")
	public MappingJacksonValue listOfSomeSampleBeans() {

		List<SomeSampleBean> list = Arrays.asList(new SomeSampleBean("value1", "value2", "value3"),
				new SomeSampleBean("value12", "value22", "value32"));
		// filter all the other fields except field1 and field2
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}

}
