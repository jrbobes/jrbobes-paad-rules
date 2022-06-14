package com.jrbobes.paadrules.rule;

import com.jrbobes.paadrules.domain.Person;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.logging.Level;
import java.util.logging.Logger;

@Rule(name = "ageOver18Validation", description = "Validates that the person is older than 18 years")
    public class AgeOver18Validation {

        private static Logger log = Logger.getLogger(AgeOver18Validation.class.getName());

        @Condition
        public boolean isGreaterThan18(@Fact("person") Person person) {
            return (person.getAge() >= 18);
        }

        @Action
        public void allowAccess(@Fact("person") Person person) {
            log.log(Level.INFO, String.format("Allow access (>18) to the person %s", person));
            person.setAdult(true);
        }
    }
