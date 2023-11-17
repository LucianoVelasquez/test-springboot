package com.cursoJava.cursoJava.services;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cursoJava.cursoJava.der.CountriesData;
import com.cursoJava.cursoJava.models.Countries;
import com.cursoJava.cursoJava.repository.CountryRepository;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository dbcontext;

    public Countries getCountry(String tld){
        return dbcontext.findBytld(tld);
    }

    public List<Countries> getCountries(String name){
        return dbcontext.findByNameIgnoreCaseStartingWith(name);
    }

    public Countries getCountryById(Long id){
        return dbcontext.findByid(id);
    }

    public void save(Countries countries){
        dbcontext.save(countries);
    }

    public List<Countries> cargarDatos() {
        Gson gson = new Gson();
        List<Countries> list = new ArrayList<>();

        try {

            FileReader file = new FileReader("src\\main\\db.json");

            CountriesData datosCountries = gson.fromJson(file, CountriesData.class);

            for (Integer i = 0; i < datosCountries.getCountries().size(); i++) {
                Countries newCountry = new Countries();

                newCountry.setArea(datosCountries.getCountries().get(i).getArea());

                newCountry.setCapital(datosCountries.getCountries().get(i).getCapital() == null ? null
                        : datosCountries.getCountries().get(i).getCapital().get(0));

                newCountry.setContinents(datosCountries.getCountries().get(i).getContinents() == null ? null
                        : datosCountries.getCountries().get(i).getContinents().get(0));

                newCountry.setFlags(datosCountries.getCountries().get(i).getFlags().getPng());
                newCountry.setName(datosCountries.getCountries().get(i).getName().getCommon());
                newCountry.setPopulation(datosCountries.getCountries().get(i).getPopulation());
                newCountry.setRegion(datosCountries.getCountries().get(i).getRegion());
                newCountry.setSubregion(datosCountries.getCountries().get(i).getSubregion());

                newCountry.setTld(datosCountries.getCountries().get(i).getTld() == null ? null
                        : datosCountries.getCountries().get(i).getTld().get(0));

                if(dbcontext.findByname(newCountry.getName()) == null){
                    dbcontext.save(newCountry);
                    list.add(newCountry);
                }    
                
            }
            
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
