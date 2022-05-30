package com.jrbobes.jrbobespaadrules;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/rule")
    public String rule(@RequestParam(name = "id", required = false) Integer id, Model model) {

        List<Rule> rules = new ArrayList<Rule>();
        rules.add(new Rule(1, "Primera"));
        rules.add(new Rule(2, "Segunda"));
        model.addAttribute("rule", rules.get(id));
        return "rule";
    }

}
