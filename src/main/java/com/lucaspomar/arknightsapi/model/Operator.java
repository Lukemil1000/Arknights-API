package com.lucaspomar.arknightsapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer stars;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer hp;

    @Column(nullable = false)
    private Integer attack;

    @Column(nullable = false)
    private Integer defense;

    @Column(nullable = false)
    private Integer magicDefense;

    @Column(nullable = false)
    private Integer redeploy;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private Integer block;

    @Column(nullable = false)
    private Double attackTime;

    @Column(nullable = false)
    private String e1Image;

    @Column(nullable = false)
    private String e2Image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subclassId", nullable = false)
    private Subclass subclassId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "affiliationId", nullable = false)
    private Affiliation affiliationId;
}
