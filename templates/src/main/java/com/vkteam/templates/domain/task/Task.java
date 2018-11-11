package com.vkteam.templates.domain.task;

import com.vkteam.templates.domain.user.User;
import com.vkteam.templates.domain.pet.Pet;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int complexity;
    private String title;
    private String description;
    private Date endDate;
    private String location;

    private String type; // user, common
    private String status; // active, completed
    private Date beginDate;

    private boolean urgency;
    private int price;
}
