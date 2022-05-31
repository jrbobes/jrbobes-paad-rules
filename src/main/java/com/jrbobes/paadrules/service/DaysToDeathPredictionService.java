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
        people.add(new Person("Alex", "bautista", 18));
        people.add(new Person("Juan", "ramírez", 17));

        people.add(new Person("Arturo", "juarez", 15));
        people.add(new Person("Edgar", "sanchez", 18));
        people.add(new Person("Oscar", "perez", 4));
        people.add(new Person("Hugo", "lopez", 10));
        return people;
    }

    public static void main(String[] args) {
        RulesEngine rulesEngine = new DefaultRulesEngine();
        for (Person person : getPeople()) {
            Facts fact = new Facts();
            fact.put("person", person);
            rulesEngine.fire(getRules(), fact);
        }
    }
}
