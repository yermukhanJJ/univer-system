package com.example.myuniver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String name;

    private String fatherland;

    private String username;

    private int course;

    private String telephone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bd;

    private Long group_id;

    public Students(String surname, String name, String fatherland, String username, int course, String telephone, Date bd) {
        this.surname = surname;
        this.name = name;
        this.fatherland = fatherland;
        this.username = username;
        this.course = course;
        this.telephone = telephone;
        this.bd = bd;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "students",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Estimate> estimateList;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id",insertable = false,updatable = false,referencedColumnName = "id")
    private Groups group;
}
