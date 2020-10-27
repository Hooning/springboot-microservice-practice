package com.hooning.practicespringboot.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class FilteringService {
    public FilterProvider createSimpleBeanPropertyFilter(String filterId, Set<String> includeFields) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(includeFields);
        return new SimpleFilterProvider().addFilter(filterId, filter);
    }
}
