package org.ma.springpagination.service;

import org.ma.springpagination.entitie.City;
import org.ma.springpagination.entitie.Person;
import org.ma.springpagination.repository.CityRepository;
import org.ma.springpagination.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Service;

@Service
public class AtFirst implements CommandLineRunner {
    private GenerPersonsAndCities personsAndCities;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CityRepository cityRepository;
    private final int MAX = 20;

    @Override
    public void run(String... args) throws Exception {
        personsAndCities = new GenerPersonsAndCities();
        restConfiguration.exposeIdsFor(Person.class);
        restConfiguration.exposeIdsFor(City.class);
        cityRepository.saveAll(personsAndCities.getCities());
        personRepository.saveAll(personsAndCities.getPersons(MAX));
        System.out.println("done !");
    }
}
