package com.yash.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	/* simples option of versioning services is by mapping different URI */
	@GetMapping(value = "v1/pserson")
	public PersonV1 personV1() {
		return new PersonV1("Yash Raorane");
	}

	@GetMapping(value = "v2/pserson")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Yash", " Raorane"));
	}

	/* versioning using request parameters */
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Yash Raorane");
	}


	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Yash", " Raorane"));
	}

	/* versioning using header parameters */
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Yash Raorane");
	}

	// @GetMapping("v2/person")
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Yash", " Raorane"));
	}

	/*versioning using produces also called content negotiation or Accept header */
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Yash Raorane");
	}

	// @GetMapping("v2/person")
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Yash", " Raorane"));
	}
}
