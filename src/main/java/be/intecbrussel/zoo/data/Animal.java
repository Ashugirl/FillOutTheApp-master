package be.intecbrussel.zoo.data;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String animalName;
    @ManyToOne
    private Country country;

    public Animal() {

    }

    public Animal(String animalName, String countryName) {
        this.animalName = animalName;
        this.country = new Country(countryName,"");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country=country;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalName='" + animalName + '\'' +
                ", country=" + country +
                '}';
    }
}
