package com.funda.enums;

import lombok.Getter;

@Getter
public enum DutchCity {
  AMSTERDAM("Amsterdam"),
  ROTTERDAM("Rotterdam"),
  DEN_HAAG("Den Haag"),
  UTRECHT("Utrecht"),
  EINDHOVEN("Eindhoven"),
  GRONINGEN("Groningen"),
  TILBURG("Tilburg"),
  ALMERE("Almere"),
  BREDA("Breda"),
  NIJMEGEN("Nijmegen");

  private final String name;

  DutchCity(String cityCode) {
    this.name = cityCode;
  }
}
