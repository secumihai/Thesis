package com.database;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageAccountSavePath {
    private static SessionFactory factory;

    public ManageAccountSavePath() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addNewAccountSavePath(String path, Account account){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            AccountSavePath accountSavePath = new AccountSavePath(path, account);
            session.save(accountSavePath);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /* Method to  READ all the files by filepath and account*/
    public List<AccountSavePath> listOfPath(String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <AccountSavePath> files=null;
        int size=0;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From AccountSavePath where account=?");
            query.setString(0, account);
            query.setMaxResults(1);
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

    /* Method to UPDATE photoPath, sampleNumber and description for an image */
    public void updatePath(int pathSaveId, String path){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            AccountSavePath accout = (AccountSavePath) session.get(AccountSavePath.class, pathSaveId);
            accout.setPath(path);
            session.update(accout);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an files from the records */
    public void deleteFiles(int pathSaveId){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            AccountSavePath savePath = (AccountSavePath) session.get(AccountSavePath.class, pathSaveId);
            session.delete(savePath);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}
