package be.intecbrussel.zoo.services.implementations;

import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.repositories.AnimalRepository;
import be.intecbrussel.zoo.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;
    private CountryServiceImpl countryService;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, CountryServiceImpl countryService){
        this.animalRepository = animalRepository;
        this.countryService = countryService;
    }

    @Override
    public Animal getAnimalByID(long id) {
        Optional optional = animalRepository.findById(id);
        if(optional.isPresent()) {
            return (Animal)optional.get();
        }
        return null;
    }

    @Override
    public List<Animal> getAnimalsByCountry(Country country) {
        List<Animal> animals = new ArrayList<>();
        animalRepository.findAllByCountry(country)
                .forEach(animals::add);
        return animals;
    }

    @Override
    public void addAnimal(Animal animal) {
        Country country = new Country();
        countryService.getCountryByName(country.getCountryName());
        animal.setCountry(country);
       // animal = new Animal("", countryService.getCountryByName("")) ;
        animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(long id) {
        animalRepository.deleteById(id);
    }
}
