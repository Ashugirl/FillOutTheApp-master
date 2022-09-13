package be.intecbrussel.zoo.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    private String countryName;
    private String continent;
    
    public Country() {
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country(String countryName, String continent) {
        this.countryName = countryName;
        this.continent = continent;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
