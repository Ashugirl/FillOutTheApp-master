package be.intecbrussel.zoo.controllers.implementations;

import be.intecbrussel.zoo.controllers.interfaces.AnimalController;
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
    @GetMapping("/animals/{country}")
    public String seeAllAnimalsByCountry(Model model, @PathVariable String countryName) {
        //TODO check this method
        model.addAttribute("animals", animalService.getAnimalsByCountry(new Country(countryName)));
        return "animals";
    }

    @Override
    //TODO check if annotation is correct. create method
    @PostMapping("/addAnimal")
    public String addAnimal(String animalName, String countryName) {

        return null;
    }

    @Override
    @DeleteMapping("animals/{id}")
    public String deleteAnimal(@PathVariable long animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/animals";
    }
}
