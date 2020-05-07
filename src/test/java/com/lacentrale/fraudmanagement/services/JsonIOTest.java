package com.lacentrale.fraudmanagement.services;

import com.lacentrale.fraudmanagement.model.Advertisement;
import com.lacentrale.fraudmanagement.model.Contacts;
import com.lacentrale.fraudmanagement.model.Phone1;
import com.lacentrale.fraudmanagement.model.Vehicle;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class JsonIOTest {

    JsonIO jsonIO = new JsonIO();

    @Test
    public void should_parse_file_and_return_advertisement_with_all_information() {
        Phone1 phone1 = new Phone1("0607080901");
        Contacts contacts = new Contacts("Christophe", "Dupont", "testdepot@yopmail.fr", phone1);
        Vehicle vehicle = new Vehicle("CR-V", "AA123AA", "SUV_4X4_CROSSOVER", "HONDA", "IV (2) 1.6 I-DTEC 160 4WD EXCLUSIVE NAVI AT", "100000");
        Advertisement advertisement = new Advertisement(Optional.of(contacts), "2020-01-09T09:02:22.610Z", 19000, new String[]{"STRENGTHS", "BOOST_VO"}, "B300053623", Optional.of(vehicle));
        assertEquals(advertisement, jsonIO.readJsonFile());
    }
}
