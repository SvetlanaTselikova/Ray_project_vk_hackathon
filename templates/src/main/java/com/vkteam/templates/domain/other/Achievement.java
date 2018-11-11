package com.vkteam.templates.domain.other;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "achievement")
@Data
@Builder
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
}
