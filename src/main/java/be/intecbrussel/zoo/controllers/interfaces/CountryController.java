package be.intecbrussel.zoo.controllers.interfaces;

import org.springframework.ui.Model;
import be.intecbrussel.zoo.data.Country;

public interface CountryController {

    String showAllCountries(Model model);
    String createCountry (Country country);
}
