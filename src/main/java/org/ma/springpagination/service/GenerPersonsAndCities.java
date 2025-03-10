package org.ma.springpagination.service;

import org.ma.springpagination.entitie.City;
import org.ma.springpagination.entitie.Person;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//@AllArgsConstructor
public class GenerPersonsAndCities {
    private File fileCity;
    private File fileName;
    private File fileEmail;

    private Scanner scannerCity;
    private Scanner scannerName;
    private Scanner scannerEmail;

    public GenerPersonsAndCities() throws FileNotFoundException {
        fileCity = ResourceUtils.getFile("classpath:cities.csv");
        fileName = ResourceUtils.getFile("classpath:names.csv");
        fileEmail = ResourceUtils.getFile("classpath:emails.csv");
        scannerCity = new Scanner(fileCity);
        scannerName = new Scanner(fileName);
        scannerEmail = new Scanner(fileEmail);
    }

    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        while (scannerCity.hasNext()) cities.add(new City(null, scannerCity.nextLine()));
        return cities;
    }

    private int genererRandom(int min, int max) {
        Random random = new Random();
        int nb;
        nb = min + random.nextInt(max + 1 - min);
        return nb;
    }

    public List<Person> getPersons(int max) {
        List<Person> persons = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        while (scannerName.hasNext()) names.add(scannerName.nextLine());
        while (scannerEmail.hasNext()) emails.add(scannerEmail.nextLine());
        for (int i = 1; i < max; i++) {
            int c = genererRandom(1, 7);
            String name = names.get(genererRandom(0, names.size() - 1));
            String email = emails.get(genererRandom(0, emails.size() - 1));
            persons.add(new Person(null, name + i, name + i + "@" + email, (long) c));
        }
        scannerCity.close();
        scannerName.close();
        scannerEmail.close();
        return persons;
    }
}
