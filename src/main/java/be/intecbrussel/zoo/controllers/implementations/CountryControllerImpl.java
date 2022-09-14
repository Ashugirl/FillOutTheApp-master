package be.intecbrussel.zoo.controllers.implementations;

import be.intecbrussel.zoo.controllers.interfaces.CountryController;
import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.services.implementations.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "countries/addCountry";
    }

    @Override
    @PostMapping("/addCountry")
    public String createCountry(@ModelAttribute("countryName") Country country) {
        countryService.createCountry(country);
       // country.setCountryName("");
        return "redirect:/countries";
    }
}
