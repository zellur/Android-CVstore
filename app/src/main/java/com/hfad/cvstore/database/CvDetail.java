package com.hfad.cvstore.database;

/**
 * Created by rakib on 12/26/17.
 */

public class CvDetail {

    private int id;
    private String title;
    private String cVholder;


    public CvDetail(int id, String title, String cVholder) {
        this.id = id;
        this.title = title;
        this.cVholder = cVholder;
    }

    public CvDetail(String title, String cVholder) {
        this.title = title;
        this.cVholder = cVholder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getcVholder() {
        return cVholder;
    }

    public void setcVholder(String cVholder) {
        this.cVholder = cVholder;
    }
}
