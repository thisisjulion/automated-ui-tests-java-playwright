package com.funda.utils;

import com.funda.enums.DutchCity;
import java.util.Random;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;

@AllArgsConstructor
public class DataGenerator {
  private final Faker faker;

  public DataGenerator() {
    this.faker = new Faker();
  }

  public String getFirstName() {
    return faker.name().firstName();
  }

  public String getLastName() {
    return faker.name().lastName();
  }

  public String getPhoneNumber() {
    return faker.phoneNumber().phoneNumber();
  }

  public String getRandomText() {
    return faker.lorem().characters();
  }

  public String getEmail() {
    return faker.internet().emailAddress();
  }

  public String getRandomDutchCity() {
    int index = new Random().nextInt(DutchCity.values().length);
    return DutchCity.values()[index].getName();
  }
}
