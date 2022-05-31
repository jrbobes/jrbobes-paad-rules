package com.jrbobes.paadrules.controller;

import com.jrbobes.paadrules.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class RulesController {

    @RequestMapping("/rules")
    public String rules(Model model) {

        List<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "Primera"));
        rules.add(new Rule(2, "Segunda"));
        model.addAttribute("rules", rules);
        return "rulesList";
    }

    @GetMapping("/rules/{ruleId}")
    public String rule(@PathVariable Integer ruleId, Model model) {

        List<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "Primera"));
        rules.add(new Rule(2, "Segunda"));
        model.addAttribute("rule", rules.get(ruleId-1));
        return "rule";
    }

}
