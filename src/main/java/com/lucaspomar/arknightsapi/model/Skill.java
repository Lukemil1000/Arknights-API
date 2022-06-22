package com.lucaspomar.arknightsapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Integer spCost;

    @Column(nullable = false)
    private Integer initialSp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chargeTypeId", nullable = false)
    private ChargeType chargeTypeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SkillActivationId", nullable = false)
    private ChargeType SkillActivationId;
}
