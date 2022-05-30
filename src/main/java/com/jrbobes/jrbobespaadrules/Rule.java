package com.jrbobes.jrbobespaadrules;

import org.springframework.context.annotation.Bean;

public class Rule {

    Integer id;
    String name;

    public Rule(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}