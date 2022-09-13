package be.intecbrussel.zoo.services.interfaces;

import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;

import java.util.List;

public interface AnimalService {

    Animal getAnimalByID(long id);
    List<Animal> getAnimalsByCountry(Country country);
    void addAnimal (Animal animal);
    void deleteAnimal(long id);


}
