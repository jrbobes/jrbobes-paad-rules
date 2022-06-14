package com.jrbobes.paadrules.rule;

import com.jrbobes.paadrules.domain.Person;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.logging.Level;
import java.util.logging.Logger;

@Rule(name = "ageOver23Validation", description = "Validates that the person is older than 23 years")
public class AgeOver23Validation {

    final private static Logger log = Logger.getLogger(AgeOver23Validation.class.getName());

    @Condition
    public boolean isOlderThan23(@Fact("person") Person person) {
        return (person.getAge() >= 23);
    }

    @Action
    public void allowAccess(@Fact("person") Person person) {
        log.log(Level.INFO, String.format("Allow access to the person %s", person));
        person.setAdult(true);
    }
}
