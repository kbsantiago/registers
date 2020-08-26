package br.com.soft.registers.domain.dtos.person;

import br.com.soft.registers.domain.dtos.Message;
import br.com.soft.registers.domain.valueObjects.Cpf;
import br.com.soft.registers.domain.valueObjects.Email;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

public abstract class PersonDto extends RepresentationModel<PersonDto> {

    private String name;
    private char sex;
    private Email email;
    private String birthDate;
    private String birthPlace;
    private String nationality;
    private Cpf document;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Message responseMessage;

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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public Cpf getDocument() {
        return document;
    }

    public void setDocument(Cpf document) {
        this.document = document;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Message getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Message responseMessage) {
        this.responseMessage = responseMessage;
    }

}
