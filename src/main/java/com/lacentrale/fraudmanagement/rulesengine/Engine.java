package com.lacentrale.fraudmanagement.rulesengine;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Response;
import com.lacentrale.fraudmanagement.services.JsonIO;

import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    public Engine run(JsonIO jsonIO, List<Rule<Advertisement>> rules) {
        Advertisement advertisement = jsonIO.readJsonFile();
        List<Rule<Advertisement>> brokenRules = rules.stream().filter(rule -> ! rule.evaluate().test(advertisement)).collect(Collectors.toList());
        Response response = new Response(advertisement.getReference(), ! brokenRules.isEmpty(),
                brokenRules.stream().map(Rule::getName).collect(Collectors.toList()));
        System.out.println(jsonIO.writeResponse(response));
        return this;
    }
}
