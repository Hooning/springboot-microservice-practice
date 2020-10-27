package com.hooning.practicespringboot.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// static filtering
//@JsonIgnoreProperties(value = {"field2", "field3"})
public class SomeBean {
    private String field1;
    private String field2;

    @JsonIgnore
    private String field3;

    public SomeBean(String value1, String value2, String value3) {
        this.field1 = value1;
        this.field2 = value2;
        this.field3 = value3;
    }
}
