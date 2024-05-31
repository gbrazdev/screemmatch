package com.gbrazdev.screemmatch.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {

    private Integer season;
    private String title;
    private Integer numberEpisode;
    private Double rating;
    private LocalDate dateLaunch;

    public Episode(Integer numberSeason, EpisodeModel episodeMoel) {
        this.season = numberSeason;
        this.title= episodeMoel.title();
        this.numberEpisode = episodeMoel.episode();

        try {
            this.rating = Double.valueOf(episodeMoel.rating());
        } catch (NumberFormatException ex) {
            this.rating= 0.0;
        }

        try {
            this.dateLaunch = LocalDate.parse(episodeMoel.released());
        } catch (DateTimeParseException ex) {
            this.dateLaunch = null;
        }
    }



    public LocalDate getDateLaunch() {
        return dateLaunch;
    }

    public void setDateLaunch(LocalDate dateLaunch) {
        this.dateLaunch = dateLaunch;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(Integer numberEpisode) {
        this.numberEpisode = numberEpisode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", numberEpisode=" + numberEpisode +
                ", rating=" + rating +
                ", dateLaunch=" + dateLaunch +
                '}';
    }


}
