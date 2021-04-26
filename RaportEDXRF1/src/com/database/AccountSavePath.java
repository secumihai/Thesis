package com.database;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccountSavePath {
    @Id
    @GeneratedValue
    private int pathSaveId;
    private String path;
    @OneToOne
    private Account account;

    public AccountSavePath() {
    }

    public AccountSavePath( String path, Account account) {
        this.path = path;
        this.account = account;
    }

    public int getPathSaveId() {
        return pathSaveId;
    }

    public void setPathSaveId(int pathSaveId) {
        this.pathSaveId = pathSaveId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}