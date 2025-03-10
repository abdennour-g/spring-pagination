package org.ma.springpagination.controller;

import org.ma.springpagination.entitie.Person;
import org.ma.springpagination.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@GetMapping("/pers")
	public Page<Person> getPersons(@RequestParam(value="page" ,required=false) Integer page, @RequestParam(value="size" ,required=false)Integer size, @RequestParam(value="key" ,required=false)String key){
		//Sort sort=Sort.by(Sort.Direction.ASC, "seatNumber");
				Sort sort=Sort.by(new String[] { "name","email"});
		Pageable pageable = PageRequest.of(page == null?0:page, size==null?5:size,sort);//,Sort.by("name"));
		return key==null?  personRepository.descPersons(pageable):personRepository.myFind(pageable,key);

		//http://localhost:5500/pers?page=1&size=10
		//http://localhost:5500/pers
		}
	@GetMapping("/pers/{id}")
	public Person   getPersons( @PathVariable Long id){
		return personRepository.findById(id).get();
		//http://localhost:5500/persp/1
	}

	@GetMapping("/fullpers")
	public Map<String, List<Person>> fullPersons(@RequestParam(value="key" ,required=false)String key){
		return new HashMap<>(){{
			put("content",key==null?personRepository.fullPersons():personRepository.fullPersons(key));
		}};
	}
}