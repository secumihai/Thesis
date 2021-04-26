package com.database;

import javax.persistence.*;

@Entity
public class EdxrfDB {
    @Id @GeneratedValue
    private int edxrfId;
    private String fileName;
    private String path;
    @ManyToOne
    @JoinColumn(name="userName")
    private Account account;

    public  EdxrfDB(){

    }
    public EdxrfDB( String fileName, String path, Account account) {
        this.path = path;
        this.fileName = fileName;
        this.account = account;
    }

    public int getEdxrfId() {
        return edxrfId;
    }

    public void setEdxrfId(int edxrfId) {
        this.edxrfId = edxrfId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
