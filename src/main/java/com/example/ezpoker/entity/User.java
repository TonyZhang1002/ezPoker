package com.example.ezpoker.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "_USER")
public class User {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="score")
    private int score;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int givenScore) {
        this.score = givenScore;
    }

    @Override
    public String toString() {
        return "User ID: " + this.id + ", User Name: " + this.name + ", UserScore: " +this.score;
    }
}
