package com.rest.webservices.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("/v1")
public PersonV1 personv1(){
	return new PersonV1("Bob Charlie");

	
}

@GetMapping("/v2")
public PersonV2 personv2(){
	return new PersonV2(new Name("Bob","Charlie"));

	
}
@GetMapping(value="/v/param",params="version=1")
public PersonV1 paramv1(){
return new PersonV1("Bob Charlie");


}

@GetMapping(value="/v/param",params="version=2")
public PersonV2 paramv2(){
return new PersonV2(new Name("Bob","Charlie"));

}
@GetMapping(value="/v/headers",headers="h_version=1")
public PersonV1 headv1(){
return new PersonV1("Bob Charlie");


}

@GetMapping(value="/v/headers",headers="h_version=2")
public PersonV2 headv2(){
return new PersonV2(new Name("Bob","Charlie"));

}
@GetMapping(value="/v/prod",produces="application/vnd.company.app-v1+json")
public PersonV1 prodv1(){
return new PersonV1("Bob Charlie");


}

@GetMapping(value="/v/prod",produces="application/vnd.company.app-v2+json")
public PersonV2 prodv2(){
return new PersonV2(new Name("Bob","Charlie"));

}
}
