package com.lucaspomar.arknightsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subclass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String trait;

    @Column(nullable = false)
    private String icon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId", nullable = false)
    private Class classId;

    @OneToMany(mappedBy = "subclassId", cascade = CascadeType.ALL)
    private List<Operator> operators;
}
