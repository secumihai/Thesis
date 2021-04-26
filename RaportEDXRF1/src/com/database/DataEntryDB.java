package com.database;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;


@Entity
public class DataEntryDB {
    @Id
    @GeneratedValue
    private int dataEntryId;
    private int reportNumber;
    private Date reportDate;
    private String clientName;
    private String clientAdrress;
    private String sampleCode;
    private String sealNumber;
    private Date getSample;
    private Date itialDate;
    private Date finalDate;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String documents;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String conclusion;
    private String inspectorName;
    private String degree;
    private String speciality;
    private int ageOfWork;
    @OneToOne
    private Account account;

    public DataEntryDB(int reportNumber, Date reportDate, String clientName, String clientAdrress, String sampleCode, String sealNumber, Date getSample, Date itialDate, Date finalDate, String documents, String conclusion, String inspectorName, String degree, String speciality, int ageOfWork, Account account) {
        this.reportNumber = reportNumber;
        this.reportDate = reportDate;
        this.clientName = clientName;
        this.clientAdrress = clientAdrress;
        this.sampleCode = sampleCode;
        this.sealNumber = sealNumber;
        this.getSample = getSample;
        this.itialDate = itialDate;
        this.finalDate = finalDate;
        this.documents = documents;
        this.conclusion = conclusion;
        this.inspectorName = inspectorName;
        this.degree = degree;
        this.speciality = speciality;
        this.ageOfWork = ageOfWork;
        this.account = account;
    }

    public DataEntryDB() {
    }

    public int getDataEntryId() {
        return dataEntryId;
    }

    public void setDataEntryId(int dataEntryId) {
        this.dataEntryId = dataEntryId;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAdrress() {
        return clientAdrress;
    }

    public void setClientAdrress(String clientAdrress) {
        this.clientAdrress = clientAdrress;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getSealNumber() {
        return sealNumber;
    }

    public void setSealNumber(String sealNumber) {
        this.sealNumber = sealNumber;
    }

    public Date getGetSample() {
        return getSample;
    }

    public void setGetSample(Date getSample) {
        this.getSample = getSample;
    }

    public Date getItialDate() {
        return itialDate;
    }

    public void setItialDate(Date itialDate) {
        this.itialDate = itialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getAgeOfWork() {
        return ageOfWork;
    }

    public void setAgeOfWork(int ageOfWork) {
        this.ageOfWork = ageOfWork;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

