package com.jrbobes.paadrules.rule;

import com.jrbobes.paadrules.domain.Person;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.logging.Level;
import java.util.logging.Logger;

@Rule(name = "whiteValidation", description = "Validates that the person is white")
    public class WhiteValidation {

        private static Logger log = Logger.getLogger(WhiteValidation.class.getName());

        @Condition
        public boolean isWhite(@Fact("person") Person person) {
            return ("White".equals(person.getRace()));
        }

        @Action
        public void allowAccess(@Fact("person") Person person) {
            log.log(Level.INFO, String.format("is WHITE %s", person));
        }
    }
