package com.database;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import java.util.Date;
import java.util.List;

public class ManageDataEntryDB {
    private static SessionFactory factory;

    public ManageDataEntryDB() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    /* Method to CREATE an DataEntryDB File in the database */

    public void addNewFile(int reportNumber, Date reportDate, String clientName, String clientAdrress, String sampleCode, String sealNumber, Date getSample, Date itialDate, Date finalDate, String documents, String conclusion, String inspectorName, String degree, String speciality, int ageOfWork, Account account) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            DataEntryDB daataEntryDB = new DataEntryDB(reportNumber, reportDate, clientName, clientAdrress,  sampleCode, sealNumber, getSample, itialDate, finalDate, documents, conclusion, inspectorName, degree, speciality, ageOfWork, account);
            session.save(daataEntryDB);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to  READ all the files for exactly account */
    public List<DataEntryDB> listOfFiles(String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <DataEntryDB> data=null;
        int size=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From DataEntryDB where account=?");
            query.setString(0, account);
            data = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return data;
    }

    /* Method to UPDATE data in DaataEntry */
    public void updateData(int dataEntryId, int reportNumber, Date reportDate, String clientName, String clientAdrress, String sampleCode, String sealNumber, Date getSample, Date itialDate, Date finalDate, String documents, String conclusion, String inspectorName, String degree, String speciality, int ageOfWork){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            DataEntryDB data = (DataEntryDB) session.get(DataEntryDB.class, dataEntryId);
            data.setReportNumber(reportNumber);
            data.setReportDate(reportDate);
            data.setClientName(clientName);
            data.setClientAdrress(clientAdrress);
            data.setSampleCode(sampleCode);
            data.setSealNumber(sealNumber);
            data.setGetSample(getSample);
            data.setItialDate(itialDate);
            data.setFinalDate(finalDate);
            data.setDocuments(documents);
            data.setConclusion(conclusion);
            data.setInspectorName(inspectorName);
            data.setDegree(degree);
            data.setSpeciality(speciality);
            data.setAgeOfWork(ageOfWork);
            session.update(data);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE all data from the records */
    public void deleteData(int dataEntryId){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            DataEntryDB dataEntryDB = (DataEntryDB) session.get(DataEntryDB.class, dataEntryId);
            session.delete(dataEntryDB);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
