package be.intecbrussel.zoo.controllers.implementations;

import be.intecbrussel.zoo.controllers.interfaces.AnimalController;
import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.services.implementations.AnimalServiceImpl;
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

    @Autowired
    public AnimalControllerImpl(AnimalServiceImpl animalService){
        this.animalService = animalService;
    }

    @Override
    @GetMapping("/countries/{countryName}/animals")
    public String seeAllAnimalsByCountry(Model model, @PathVariable String countryName) {
        //TODO check this method
        model.addAttribute("countryName", animalService.getAnimalsByCountry(new Country(countryName)));
        model.addAttribute("animal", new Animal());

        return "countries/{countryName}/animals";
    }

    @Override
    //TODO check if annotation is correct. create method
    @PostMapping("countries/{name}/animals")
    public String addAnimal(String animalName, @PathVariable String countryName) {
        animalService.addAnimal(new Animal(animalName, new Country(countryName)));
        return "redirect:/countries/{name}/animals";
    }

    @Override
    @DeleteMapping("animals/{id}")
    public String deleteAnimal(@PathVariable long animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/countries/{name}/animals";
    }
}
