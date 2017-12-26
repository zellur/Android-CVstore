package com.hfad.cvstore.database;

/**
 * Created by rakib on 12/26/17.
 */

public class Project {

    private int id;
    private String projectName;
    private String projectDescription;
    private String projectLink;

    public Project(int id, String projectName, String projectDescription, String projectLink) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectLink = projectLink;
    }

    public Project(String projectName, String projectDescription, String projectLink) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectLink = projectLink;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
