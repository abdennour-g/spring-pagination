package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.CityRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.ent.City;
import com.example.demo.ent.Person;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PaginationApplication implements CommandLineRunner{
	@Autowired
    private RepositoryRestConfiguration conf;
	@Autowired
	private PersonRepository daopers;
	@Autowired
	private CityRepository daocity;
	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		conf.exposeIdsFor( Person.class );
		conf.exposeIdsFor( City.class );
		/*************************************************************************************************/
		initFromTests(300);
	}
	public void initFromTests(int max) {
		List<City> citys=Arrays.asList(new City(null,"oujda"),new City(null,"berkane"),
				new City(null,"ahfir"),new City(null,"rabat"),new City(null,"casa"),new City(null,"marakesh"),new City(null,"tanger"));
		int l=daopers.findAll().size();
		 if(l==0) {
			 citys.forEach(
					 city->{
						 daocity.save(city); 
						 System.out.println("SAVE CITY : "+city+".........");
					 } 
					 );
			 for(int i=1;i<max;i++) {
				 int c=i%5==0?5:(i%11==0?4:(i%13==0?7:(i%17==0?2:(i%19==0?3:(i%23==0?6:1)))));
				 String name=i%3==0?"ahmed":(i%5==0?"rachid":(i%7==0?"hassan":(i%11==0?"omar":"mohamed")));
				 String email=i%7==0?"outlook.live.com":(i%11==0?"yahoo.fr":(i%17==0?"yahoo.com":"gmail.com"));
				 Person person=new Person(null, name+i, name+i+"@"+email, (long) c);
				 daopers.save(person);
				 System.out.println("SAVE PERSON : "+person+".........");
			 }
		 }
	}
}
