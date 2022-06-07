package com.jrbobes.paadrules;

import com.jrbobes.paadrules.domain.Person;
import com.jrbobes.paadrules.rule.AgeOver18Validation;
import com.jrbobes.paadrules.rule.WhiteValidation;
import com.jrbobes.paadrules.service.DaysToDeathPredictionService;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.support.composite.UnitRuleGroup;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class JrbobesPaadRulesApplicationTests {

    final RulesEngine rulesEngine = new DefaultRulesEngine();

    @Test
    void contextLoads() {
        assertNotNull(rulesEngine);
    }

    @Test
    void ageOver18Rule() {
        Facts fact = new Facts();
        fact.put("person", new Person("Menor", "Menor", "White", 14));
        rulesEngine.fire(new Rules(new AgeOver18Validation()), fact);
        System.out.println("End rules engine!");
    }

    @Test
    void ageOver21Rule() {
        Facts fact = new Facts();
        fact.put("person", new Person("Menor", "Menor", "White", 14));

        org.jeasy.rules.api.Rule ageOver21 = new RuleBuilder()
                .name("Over 21")
                .description("If a person is over 21.")
                .when(facts -> Integer.parseInt(facts.get("person.age")) > 21)
                .then(facts -> System.out.println(String.valueOf(facts.get("person.name"))))
                .build();
        rulesEngine.fire(new Rules(ageOver21), fact);
        System.out.println("End rules engine!");
    }

    @Test
    void compositionRule() {
        Facts someFacts = new Facts();
        someFacts.put("person", new Person("Menor", "Menor", "White", 34));

        //Create a composite rule from two primitive rules
        UnitRuleGroup myUnitRuleGroup = new UnitRuleGroup("myUnitRuleGroup", "unit of myRule1 and myRule2");
        myUnitRuleGroup.addRule(new Rules(new AgeOver18Validation()));
        myUnitRuleGroup.addRule(new Rules(new WhiteValidation()));

        Rules rules = new Rules();
        rules.register(myUnitRuleGroup);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, someFacts);
    }
}
