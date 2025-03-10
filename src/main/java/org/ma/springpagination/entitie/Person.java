package org.ma.springpagination.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pers")
    private Long idPers;
    @Column(length = 20)
    private String name;
    @Column(length = 40)
    private String email;
    @Column(name = "id_city")
    private Long idCity;
    @ManyToOne
    @JoinColumn(name = "id_city", nullable = false, insertable = false, updatable = false)
    private City city;

    public Person(Long idPers, String name, String email, Long idCity) {
        this.idPers = idPers;
        this.name = name;
        this.email = email;
        this.idCity = idCity;
    }
}
