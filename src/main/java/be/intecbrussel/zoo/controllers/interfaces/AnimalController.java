package be.intecbrussel.zoo.controllers.interfaces;

import org.springframework.ui.Model;
import be.intecbrussel.zoo.data.Country;

public interface AnimalController {

    String seeAllAnimalsByCountry(Model model, String countryName);
    String addAnimal(String animalName, String countryName);
    String deleteAnimal(long animalId);
}
