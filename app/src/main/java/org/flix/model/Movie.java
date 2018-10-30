package org.flix.model;

public class Movie {
    private String id;
    private String poster;

    public Movie(String id, String poster) {
        this.id = id;
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
