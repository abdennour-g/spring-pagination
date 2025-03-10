package org.ma.springpagination.repository;

import org.ma.springpagination.entitie.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface PersonRepository extends JpaRepository<Person,Long> {
    public String sql_srch="select p from Person p where p.name like %?1% or p.email like %?1% or p.city.design like %?1% order by p.idPers desc";
	public String sql_desc="select p from Person p order by p.idPers desc";
	@Query(sql_desc)
	public Page<Person> descPersons(Pageable pageable);
	@Query(sql_srch)
	public  List<Person> fullPersons(String key);
	@Query(sql_desc)
	public List<Person> fullPersons();
	@Query(sql_srch)
	public Page<Person> myFind(Pageable pageable,String key);
}
