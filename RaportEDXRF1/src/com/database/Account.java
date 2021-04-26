package com.database;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Account {
    @Id
    private String userName;
    private String name;
    private String password;
    private String sec_Q;
    private String answer;
    private boolean accept;
    @OneToMany(mappedBy = "account")
    private Collection<Image> listImage = new ArrayList<>();
    @OneToMany(mappedBy = "account")
    private Collection<Image> listEDXRF = new ArrayList<>();


    public Account() {
    }

    public Account(String userName, String name, String password, String sec_Q, String answer, boolean accept) {
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.sec_Q = sec_Q;
        this.answer = answer;
        this.accept = accept;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSec_Q() {
        return sec_Q;
    }

    public void setSec_Q(String sec_Q) {
        this.sec_Q = sec_Q;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public Collection<Image> getListImage() {
        return listImage;
    }

    public void setListImage(Collection<Image> listImage) {
        this.listImage = listImage;
    }

    public Collection<Image> getListEDXRF() {
        return listEDXRF;
    }

    public void setListEDXRF(Collection<Image> listEDXRF) {
        this.listEDXRF = listEDXRF;
    }
}
