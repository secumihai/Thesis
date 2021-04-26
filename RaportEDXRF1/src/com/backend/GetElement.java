package com.backend;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GetElement {
    // map where will be stored all the elements name and element symbol for example: Hidrogen H
    private Map<String,String> mapOfSymbolAndElements = new HashMap<>();


    public Map<String,String> getMapOfSymbolAndElements() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.beginTransaction();
            List periodicTableList = session.createQuery("FROM PeriodicTable").list();
            for (Iterator iterator = periodicTableList.iterator(); iterator.hasNext(); ) {
                PeriodicTable periodicTable = (PeriodicTable) iterator.next();
                mapOfSymbolAndElements.put(periodicTable.getSymbol(), periodicTable.getElement());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return mapOfSymbolAndElements;
    }
}