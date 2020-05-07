package com.lacentrale.fraudmanagement.configuration;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.rulesengine.*;
import com.lacentrale.fraudmanagement.services.BlacklistService;
import com.lacentrale.fraudmanagement.services.JsonIO;
import com.lacentrale.fraudmanagement.services.QuotationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    public QuotationService quotationService() {
        return new QuotationService();
    }

    @Bean
    public BlacklistService blacklistService() {
        return new BlacklistService();
    }

    @Bean
    public Rule<Advertisement> firstNameRule() {
        return new FirstNameRule("rule::firstname::length");
    }

    @Bean
    public Rule<Advertisement> lastNameRule() {
        return new LastNameRule("rule::lastname::length");
    }

    @Bean
    public Rule<Advertisement> alphaRateRule() {
        return new AlphaRateRule("rule:✉:alpha_rate");
    }

    @Bean
    public Rule<Advertisement> numberRateRule() {
        return new NumberRateRule("rule:✉:number_rate");
    }

    @Bean
    public Rule<Advertisement> quotationRateRule() {
        return new QuotationRateRule("rule::price::quotation_rate", quotationService());
    }

    @Bean
    public Rule<Advertisement> registerNumberRule() {
        return new RegisterNumberRule("rule::registernumber::blacklist", blacklistService());
    }

    @Bean
    public Engine engine(JsonIO jsonIO) {
        return new Engine().run(jsonIO, Arrays.asList(firstNameRule(), lastNameRule(), alphaRateRule(), numberRateRule(), quotationRateRule(), registerNumberRule()));
    }
}
