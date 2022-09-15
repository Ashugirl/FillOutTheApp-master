package be.intecbrussel.zoo.controllers.implementations;

import be.intecbrussel.zoo.controllers.interfaces.CountryController;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.services.implementations.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryControllerImpl implements CountryController {

    private CountryServiceImpl countryService;

    @Autowired
    public CountryControllerImpl(CountryServiceImpl countryService){
        this.countryService = countryService;
    }

    @Override
    @GetMapping("/countries")
    public String showAllCountries(Model model) {
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("country", new Country(""));
        return "countries";
    }


    @Override
    @PostMapping("/addCountry")
    public String createCountry(Country country) {
        countryService.createCountry(country);
        return "redirect:/countries";
    }
}
