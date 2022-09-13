package be.intecbrussel.zoo.services.interfaces;

import be.intecbrussel.zoo.data.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();
    Country getCountryByName(String countryName);
    void createCountry(Country country);
}
