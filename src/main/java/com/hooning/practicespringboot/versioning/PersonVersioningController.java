package com.hooning.practicespringboot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    // URI versioning
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob James");
    }

    // [GET] http://localhost:8080/person/param?version=1
    @GetMapping(value="/person/param", params = "version=1")
    public PersonV1 getParamV1() {
        return new PersonV1("Bob James");
    }

    // add X-API-VERSION header with value 1
    @GetMapping(value="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getHeaderV1() {
        return new PersonV1("Bob James");
    }

    // add Accept header with application/vnd.company.app-v1+json
    // it calls Content Negotiation or MIME type or Accept Header versioning)
    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
    public PersonV1 getProducesV1() {
        return new PersonV1("Bob James");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Michael", "Jordan"));
    }

    @GetMapping(value="/person/param", params = "version=2")
    public PersonV2      getParamV2() {
        return new PersonV2(new Name("Michael", "Jordan"));
    }

    @GetMapping(value="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getHeaderV2() {
        return new PersonV2(new Name("Michael", "Jordan"));
    }

    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
    public PersonV2 getProducesV2() {
        return new PersonV2(new Name("Michael", "Jordan"));
    }
}

