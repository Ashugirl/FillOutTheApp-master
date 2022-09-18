package be.intecbrussel.zoo.services.implementations;

import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.repositories.AnimalRepository;
import be.intecbrussel.zoo.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal getAnimalByID(long id) {
        Optional optional = animalRepository.findById(id);
        if(optional.isPresent()) {
            return (Animal)optional.get();
        }
        return null ;
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
        animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(long id) {
        animalRepository.deleteById(id);
    }
}
