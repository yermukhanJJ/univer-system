package com.example.myuniver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prof;

    private int count_;

    private String group_;

    @JsonBackReference
    @OneToMany(mappedBy = "group")
    private List<Students> students;

    public Groups(String prof, int count_, String group_) {
        this.prof = prof;
        this.count_ = count_;
        this.group_ = group_;
    }
}
