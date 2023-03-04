package com.realestateapp;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RandomApartmentGeneratorTest {
    @RepeatedTest(10)
    void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {
        // given
        RandomApartmentGenerator generator = new RandomApartmentGenerator();
        Apartment apartment = generator.generate();

        // when
        int apartmentRate = ApartmentRater.rateApartment(apartment);

        // then
        assertNotEquals(-1, apartmentRate);
    }

    @RepeatedTest(10)
    void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {
        // given
        RandomApartmentGenerator generator = new RandomApartmentGenerator(1, new BigDecimal(0));
        Apartment apartment = generator.generate();

        // when
        int apartmentRate = ApartmentRater.rateApartment(apartment);

        // then
        assertNotEquals(-1, apartmentRate);
    }
}
