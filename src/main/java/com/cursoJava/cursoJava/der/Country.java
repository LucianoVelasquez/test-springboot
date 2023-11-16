package com.cursoJava.cursoJava.der;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Country {
    Common name;
    List<String> tld;
    List<String> capital;
    String region;
    String subregion;
    Double area;
    Integer population;
    List<String> continents;
    Flags flags;
}
