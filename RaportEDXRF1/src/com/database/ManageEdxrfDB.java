package com.database;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageEdxrfDB {
    private static SessionFactory factory;

    public ManageEdxrfDB() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /* Method to CREATE an EDXRF File in the database */

    public void addNewFile(String path, String fileName, Account account){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            EdxrfDB edxrfDB = new EdxrfDB(path, fileName, account);
            edxrfDB.setAccount(account);
            session.save(edxrfDB);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to  READ all the files by fileName and account */
    public List<EdxrfDB> listFiles(String fileName, String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <EdxrfDB> files=null;
        int size=0;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From EdxrfDB where fileName=? and account=?");
            query.setString(0, fileName);
            query.setString(1, account);
            files = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return files;
    }

    /* Method to  READ all the files */
    public List<EdxrfDB> listOfFiles(String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <EdxrfDB> edxrfDBS=null;
        int size=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From EdxrfDB where account=?");
            query.setString(0, account);
            edxrfDBS = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return edxrfDBS;
    }

    /* Method to DELETE an files from the records */
    public void deleteFiles(int edxrfId){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            EdxrfDB edxrfDB = (EdxrfDB) session.get(EdxrfDB.class, edxrfId);
            session.delete(edxrfDB);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
