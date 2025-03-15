package com.funda.utilities;

import net.datafaker.Faker;

import java.util.Random;

public class DataGenerator {
    private static final Faker FAKER = new Faker();

    public static String getFirstName() {
        return FAKER.name().firstName();
    }

    public static String getLastName() {
        return FAKER.name().lastName();
    }

    public static String getPhoneNumber() {
        return FAKER.phoneNumber().phoneNumber();
    }

    public static String getRandomText() {
        return FAKER.lorem().characters();
    }

    public static String getEmail() {
        return new StringBuilder()
                .append(getFirstName())
                .append(".")
                .append(getLastName())
                .append("@")
                .append("gmail.com").toString();
    }

    public static String getRandomDutchCity() {
        int index = new Random().nextInt(DutchCity.values().length);
        return DutchCity.values()[index].getName();
    }
}
