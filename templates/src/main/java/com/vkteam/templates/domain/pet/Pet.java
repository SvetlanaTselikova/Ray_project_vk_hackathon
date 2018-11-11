package com.vkteam.templates.domain.pet;

import com.vkteam.templates.domain.shelter.Shelter;
import com.vkteam.templates.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String img;
    private String name;
    private String type;
    private String age;
    private String sex;
    private String description;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner = null;

    private int foodLvl = 0;
    private int healthLvl = 0;
    private int fillerLvl = 0;
    private int funLvl = 0;
    private int walksLvl = 0;
}
