package com.hooning.practicespringboot.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class FilteringController {
    @Autowired
    private FilteringService filteringService;

    // field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filteringService.createSimpleBeanPropertyFilter("SomeBeanFilter", new HashSet<>(Arrays.asList("field1", "field2"))));

        return mapping;
    }

    // filed2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBeans() {
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value21", "value22", "value23"));
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        mapping.setFilters(filteringService.createSimpleBeanPropertyFilter("SomeBeanFilter", new HashSet<>(Arrays.asList("field2", "field3"))));

        return mapping;
    }
}
