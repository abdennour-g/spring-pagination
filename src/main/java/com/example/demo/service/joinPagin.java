package com.example.demo.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonRepository;
import com.example.demo.ent.Person;
@RestController
@CrossOrigin("*")
public class joinPagin {
	@Autowired
	private PersonRepository perserv;	
	@GetMapping("/pers")	
	public Page<Person>  pers(
			@RequestParam(value="page" ,required=false) Integer page,
			@RequestParam(value="size" ,required=false)Integer size,
			@RequestParam(value="key" ,required=false)String key
			){
		//Sort sort=Sort.by(Sort.Direction.ASC, "seatNumber");
				Sort sort=Sort.by(new String[] { "name","email"});				
		Pageable  pageable = PageRequest.of(page == null?0:page, size==null?5:size,sort);//,Sort.by("name"));
		return key==null?  perserv.descPers(pageable):perserv.myFind(pageable,key);
		
		//http://localhost:5500/pers?page=1&size=10
		//http://localhost:5500/pers
		}
	@GetMapping("/pers/{id}")
	public Person   pers( @PathVariable Long id){
		return perserv.findById(id).get();
		//http://localhost:5500/persp/1
	}
	
	@GetMapping("/fullpers")
	public Map<String, List<Person>> fullPers(@RequestParam(value="key" ,required=false)String key){
		return new HashMap<String, List<Person>>(){{
			put("content",key==null?perserv.fullPers():perserv.fullPers(key));
		}};
	}
}
