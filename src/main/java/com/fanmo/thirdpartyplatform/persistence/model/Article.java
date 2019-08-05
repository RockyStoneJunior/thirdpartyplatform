package com.fanmo.thirdpartyplatform.persistence.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "article")
public class Article {

    public Article(){};

    public Article(Map param){
        this.bUsername = (String)param.get("b_username");
        this.title = (String)param.get("title");
        this.author = (String)param.get("author");
        this.thumbMediaImg = (String)param.get("thumb_media_img");
        this.digest = (String)param.get("digest");
        this.content = (String)param.get("content");
        this.groupid = (String)param.get("groupid");
        this.selectcolor = (String)param.get("selectcolor");
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "b_username")
    private String bUsername;

    private String title;

    private String author;

    @Column(name = "thumb_media_img")
    private String thumbMediaImg;

    private String digest;

    private String content;

    private String groupid;

    private String selectcolor;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getbUsername() {
        return bUsername;
    }

    public void setbUsername(String bUsername) {
        this.bUsername = bUsername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbMediaImg() {
        return thumbMediaImg;
    }

    public void setThumbMediaImg(String thumbMediaImg) {
        this.thumbMediaImg = thumbMediaImg;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getSelectcolor() {
        return selectcolor;
    }

    public void setSelectcolor(String selectcolor) {
        this.selectcolor = selectcolor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
