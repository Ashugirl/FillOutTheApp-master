package be.intecbrussel.zoo.data;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private long id;
    private String animalName;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Country country;

    public Animal() {

    }

    public Animal(String animalName, Country country) {
        this.animalName = animalName;
        this.country = country;
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
