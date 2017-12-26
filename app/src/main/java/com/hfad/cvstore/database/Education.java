package com.hfad.cvstore.database;

/**
 * Created by rakib on 12/26/17.
 */

public class Education {

    private int id;
    private String degree;
    private String institutionName;
    private String cgpa;
    private String year;

    public Education(int id, String degree, String institutionName, String cgpa, String year) {
        this.id = id;
        this.degree = degree;
        this.institutionName = institutionName;
        this.cgpa = cgpa;
        this.year = year;
    }

    public Education(String degree, String institutionName, String cgpa, String year) {
        this.degree = degree;
        this.institutionName = institutionName;
        this.cgpa = cgpa;
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
