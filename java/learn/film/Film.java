package hnp.project.demoactivemq.test.film;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Film {
    private String filmName;
    private Date filmDateStart;
    private int filmChapter;
    private String filmType;

    public Film(String filmType, Date filmDateStart, String filmName, int filmChapter) {
        this.filmName = filmName;
        this.filmDateStart = filmDateStart;
        this.filmChapter = filmChapter;
        this.filmType = filmType;
    }

    public String display(){
        return filmType + " " + convertToString(filmDateStart) +" "+ filmName + " "  + " " + filmChapter;
    }

    private String convertToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getFilmDateStart() {
        return filmDateStart;
    }

    public void setFilmDateStart(Date filmDateStart) {
        this.filmDateStart = filmDateStart;
    }

    public int getFilmChapter() {
        return filmChapter;
    }

    public void setFilmChapter(int filmChapter) {
        this.filmChapter = filmChapter;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }
}
