package be.intecbrussel.zoo.services.implementations;

import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.repositories.CountryRepository;
import be.intecbrussel.zoo.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryByName(String countryName) {
        Optional optional = countryRepository.findById(countryName);
        if (optional.isPresent()){
            return (Country)optional.get();
        }
        return null;
    }

    @Override
    public void createCountry(Country country) {
        countryRepository.save(country);
    }
}
