package br.com.soft.registers.domain;

import br.com.soft.registers.domain.valueObjects.Email;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Person")
public class Person extends BaseEntity{

    @Column(name = "Name")
    private String name;
    @Column(name = "Sex")
    private char sex;
    @Column(name = "Email")
    private String email;
    @Column(name = "Birthdate")
    private LocalDate birthDate;
    @Column(name = "Birthplace")
    private String birthPlace;
    @Column(name = "Nationality")
    private String nationality;
    @Column(name = "Document")
    private String document;
    @OneToOne
    @JoinColumn(name = "id")
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
