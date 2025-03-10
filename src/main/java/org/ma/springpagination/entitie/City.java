package org.ma.springpagination.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private Long idCity;
    @Column(length = 20)
    private String design;
//    @OneToMany(mappedBy="city",fetch = FetchType.LAZY)
//	List<Person> pers;
}
