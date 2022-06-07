package com.jrbobes.paadrules.service;

import com.jrbobes.paadrules.Rule;
import com.jrbobes.paadrules.domain.Person;
import com.jrbobes.paadrules.rule.AgeOver18Validation;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaysToDeathPredictionService {

    public static Rules getRules() {
        Rules rules = new Rules();
        rules.register(new AgeOver18Validation());
        return rules;
    }

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList();
        people.add(new Person("Alex", "bautista", "White",18));
        people.add(new Person("Juan", "ramírez", "Black", 27));
        people.add(new Person("Arturo", "juarez", "White", 15));
        people.add(new Person("Edgar", "sanchez", "White", 18));
        people.add(new Person("Oscar", "perez", "Black", 4));
        people.add(new Person("Hugo", "lopez", "White", 10));
        return people;
    }

    public static void main(String[] args) {
        RulesEngine rulesEngine = new DefaultRulesEngine();
        for (Person person : DaysToDeathPredictionService.getPeople()) {
            Facts fact = new Facts();
            fact.put("person", person);
            rulesEngine.fire(getRules(), fact);
        }
        System.out.println("End rules engine!");
    }
}
