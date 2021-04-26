package com.database;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ManageAccount {
    private static SessionFactory factory;

    public ManageAccount() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    /* Method to CREATE an user in the database */
    public void addNewUser (String userName, String name, String password, String sec_Q, String answer,boolean accept){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            Account account = new Account(userName, name, password, sec_Q, answer, accept);
            session.save(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to  READ all the users by username */
    public List<Account> listUsers(String username){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Account> users=null;
        int size=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Account where userName=?");
            query.setString(0, username);
            query.setMaxResults(1);
            users = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /* Method to  READ all the users */
    public List<Account> listUsers(){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Account> users=null;
        int size=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Account");
            users = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /* Method to  READ all the ansers by question */
    public List<Account> listAnswers(String username, String answer){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Account> users=null;
        int size=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Account where userName=? and answer=?");
            query.setString(0, username);
            query.setString(1, answer);
            query.setMaxResults(1);
            users = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /* Method to logIn */
    public List<Account> enterList(String username, String password){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Account> users=null;
        int size=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Account where userName=? and password=?");
            query.setString(0, username);
            query.setString(1, password);
            query.setMaxResults(1);
            users = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /* Method to UPDATE user status  */
    public void updateUserStatus(String userName, boolean accept ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Account account = (Account) session.get(Account.class, userName);
            account.setAccept(accept);
            session.update(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an user from the records */
    public void deleteUser(String userName){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Account account = (Account) session.get(Account.class, userName);
            session.delete(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}