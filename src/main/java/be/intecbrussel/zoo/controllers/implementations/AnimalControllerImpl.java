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
        Country country = countryService.getCountryByName(countryName);
        model.addAttribute("countryName", countryName);
        model.addAttribute("animals", animalService.getAnimalsByCountry(country));
        model.addAttribute("animal", new Animal("", country));
        return "animals";
    }

    @Override
    @PostMapping("/addAnimal/{countryName}")
    public String addAnimal(String animalName, @PathVariable String countryName) {
        Country country = countryService.getCountryByName(countryName);
        Animal animal = new Animal(animalName, country);
        animalService.addAnimal(animal);
        return "redirect:/animals/{countryName}";
    }

    @Override
    @GetMapping ("/deleteAnimal/{id}")
    public String deleteAnimal(@PathVariable long id) {
        Animal animal = animalService.getAnimalByID(id);
        animalService.deleteAnimal(animal.getId());
        return "redirect:/countries";
    }
}
