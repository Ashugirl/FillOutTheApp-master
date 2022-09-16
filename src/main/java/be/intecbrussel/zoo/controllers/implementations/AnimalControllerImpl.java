package be.intecbrussel.zoo.controllers.implementations;

import be.intecbrussel.zoo.controllers.interfaces.AnimalController;
import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.services.implementations.AnimalServiceImpl;
import be.intecbrussel.zoo.services.implementations.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalControllerImpl implements AnimalController {

    private AnimalServiceImpl animalService;
    private CountryServiceImpl countryService;

    @Autowired
    public AnimalControllerImpl(AnimalServiceImpl animalService, CountryServiceImpl countryService){
        this.animalService = animalService;
        this.countryService=countryService;

    }

    @Override
    @GetMapping("/animals/{countryName}")
    public String seeAllAnimalsByCountry(Model model, @PathVariable("countryName") String countryName) {
        //TODO check this method
        Country country = new Country("");
        model.addAttribute("countryName", countryService.getCountryByName(""));
        model.addAttribute("country", countryService.getCountryByName(country.getCountryName()));
        model.addAttribute("animals", animalService.getAnimalsByCountry(country));
        model.addAttribute("animal", new Animal("", countryName));

        return "animals";
    }

    @Override
    //TODO check if annotation is correct. create method
    @PostMapping("/addAnimal/{countryName}")
    public String addAnimal(String animalName, String countryName) {
        //Country country = new Country(countryName);
        //countryService.getCountryByName(country.getCountryName());
        Animal animal = new Animal("", countryName);
        animal.setCountry(new Country(countryName));
        animalService.addAnimal(animal);
        return "animals";
    }

    @Override
    @DeleteMapping("animals/{id}")
    public String deleteAnimal(@PathVariable long animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:{countryName}/animals";
    }
}
