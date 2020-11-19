package com.example.app.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class JournalEntity {
    private String id = "";
    private String publication_date = "";
    private String article_type = "";
    @ColumnInfo(name ="abstract")
    private String abstract__ = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getAbstract__() {
        return abstract__;
    }

    public void setAbstract__(String abstract__) {
        this.abstract__ = abstract__;
    }

}
