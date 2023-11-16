package com.cursoJava.cursoJava.der;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class CountriesData {
    List<Country> countries; 
}
