package com.example.MedManager.model;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Table
public class Dataset {
    @Column(name = "Пол пациента")
    private String sex;

    @Column(name = "Дата рождения пациента")
    private String birthDay;

    @Column(name = "Id пациента")
    private String idPatient;

    @Column(name = "Код МКБ-10")
    private String codeMkb;

    @Column(name = "Диагноз")
    private String diagnosis;

    @Column(name = "Дата оказания услуги")
    private String dateConsultation;

    @Column(name = "Должность")
    private String office;

    @Column(name = "Назначения")
    private String tests;

    public Dataset(){}

    public Dataset(String sex, String birthDay, String idPatient, String codeMkb, String diagnosis,
                   String dateConsultation, String office, String tests) {
        this.sex = sex;
        this.birthDay = birthDay;
        this.idPatient = idPatient;
        this.codeMkb = codeMkb;
        this.diagnosis = diagnosis;
        this.dateConsultation = dateConsultation;
        this.office = office;
        this.tests = tests;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getCodeMkb() {
        return codeMkb;
    }

    public void setCodeMkb(String codeMkb) {
        this.codeMkb = codeMkb;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(String dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }
}
