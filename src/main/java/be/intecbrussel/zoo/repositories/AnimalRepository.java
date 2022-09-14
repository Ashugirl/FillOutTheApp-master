package be.intecbrussel.zoo.repositories;

import be.intecbrussel.zoo.data.Animal;
import be.intecbrussel.zoo.data.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    public List<Animal> findAllByCountry(Country country);

}
