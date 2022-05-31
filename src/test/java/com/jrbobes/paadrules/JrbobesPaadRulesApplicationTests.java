package com.jrbobes.paadrules;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class JrbobesPaadRulesApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void whenRuleOK() {
        String primera = "Primera";

        Rule rule = new Rule(1, primera);
        String ruleName = rule.getName();

        assertNotNull(ruleName);
        assertEquals(ruleName, primera);
    }
}
