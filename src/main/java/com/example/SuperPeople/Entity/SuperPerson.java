package com.example.SuperPeople.Entity;

import com.example.SuperPeople.Enums.Aliance;
import com.example.SuperPeople.Enums.Gender;
import com.example.SuperPeople.Enums.Universe;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Document
public class SuperPerson {

    @Id
    private String id;

//    @Indexed(unique = true)
    private String name;
    private BigInteger powerLevel;
    private List<String> superPower;
    private Universe universe;
    private Aliance aliance;
    private Gender gender;
    private double height;
    private double weight;

    public SuperPerson(String name, BigInteger powerLevel, List<String> superPower, Universe universe, Aliance aliance, Gender gender, double height, double weight) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.superPower = superPower;
        this.universe = universe;
        this.aliance = aliance;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(BigInteger powerLevel) {
        this.powerLevel = powerLevel;
    }

    public List<String> getSuperPower() {
        return superPower;
    }

    public void setSuperPower(List<String> superPower) {
        this.superPower = superPower;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public Aliance getAliance() {
        return aliance;
    }

    public void setAliance(Aliance aliance) {
        this.aliance = aliance;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "SuperPerson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                ", superPower=" + superPower +
                ", universe=" + universe +
                ", aliance=" + aliance +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
