package com.vkteam.templates.domain.user;

import com.vkteam.templates.domain.other.Achievement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String role = "USER";
    private int balance = 0;
    private String name;
    private String surname;
    private String password;
    private String phoneNumber;
    private String city;
    private int rate;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_achievement",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "achievement_id") }
    )
    private Set<Achievement> achievements;
}
