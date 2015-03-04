package com.aloknath.restraurant_app.Objects;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class RowItem {
    private String title;
    private String albums;

    public RowItem(String title, String albums) {
        this.title = title;
        this.albums = albums;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }
}
