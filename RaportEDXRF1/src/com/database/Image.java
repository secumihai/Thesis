package com.database;


import javax.persistence.*;



@Entity
public class Image {
    @Id @GeneratedValue
    private int photoId;
    private String photoPath;
    private String sampleNumber;
    private String description;
    @ManyToOne
    @JoinColumn(name="userName")
    private Account account;

    public Image() {
    }

    public Image(String photoPath,  String sampleNumber, String description, Account account) {
        this.photoPath = photoPath;
        this.sampleNumber = sampleNumber;
        this.description = description;
        this.account = account;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }


    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
