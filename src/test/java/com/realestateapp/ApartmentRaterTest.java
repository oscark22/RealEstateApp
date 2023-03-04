package com.realestateapp;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {

    @ParameterizedTest
    @ValueSource(doubles = {300, 400, 500, 600})
    void should_ReturnCorrectRating_When_CorrectApartment(double area) {
        // given
        BigDecimal price = new BigDecimal(4000);
        Apartment apartment = new Apartment(area, price);

        // when
        int apartmentRate = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(0, apartmentRate);
    }

    @Test
    void should_ReturnErrorValue_When_IncorrectApartment() {
        // given
        double area = 0.0;
        BigDecimal price = new BigDecimal(4000);
        Apartment apartment = new Apartment(area, price);

        // when
        int apartmentRate = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(-1, apartmentRate);
    }

    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList() {
        // given
        ArrayList<Apartment> apartments = new ArrayList();
        apartments.add(new Apartment(500, new BigDecimal(500)));
        apartments.add(new Apartment(1000, new BigDecimal(500)));
        apartments.add(new Apartment(500, new BigDecimal(1000)));

        // when
        double average = ApartmentRater.calculateAverageRating(apartments);

        // then
        assertEquals(0, average);
    }

    @Test
    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList() {
        // given
        ArrayList<Apartment> apartments = new ArrayList<>();

        // when
        Executable executable = () -> ApartmentRater.calculateAverageRating(apartments);

        // then
        assertThrowsExactly(RuntimeException.class, executable);
    }
}
