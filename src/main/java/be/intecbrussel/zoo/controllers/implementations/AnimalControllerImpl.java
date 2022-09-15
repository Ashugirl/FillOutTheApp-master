package be.intecbrussel.zoo.controllers.implementations;

import be.intecbrussel.zoo.controllers.interfaces.AnimalController;
import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.services.implementations.AnimalServiceImpl;
import be.intecbrussel.zoo.services.implementations.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/{countryName}/animals")
    public String seeAllAnimalsByCountry(Model model, @PathVariable String countryName) {
        //TODO check this method
        Country country = new Country("");
        model.addAttribute("country", countryService.getCountryByName(country.getCountryName()));
        model.addAttribute("animals", animalService.getAnimalsByCountry(country));
        model.addAttribute("animal", new Animal("", country));

        return "animals";
    }

    @Override
    //TODO check if annotation is correct. create method
    @PostMapping("{countryName}/addAnimal")
    public String addAnimal(String animalName, @PathVariable String countryName) {
        animalService.addAnimal(new Animal("", new Country(countryName)));
        return "redirect:/animals";
    }

    @Override
    @DeleteMapping("animals/{id}")
    public String deleteAnimal(@PathVariable long animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:{countryName}/animals";
    }
}
