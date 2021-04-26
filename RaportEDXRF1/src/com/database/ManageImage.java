package com.database;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageImage {
    private static SessionFactory factory;

    public ManageImage() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /* Method to CREATE an Image File in the database */

    public void addNewImage(String photoPath,  String sampleNumber, String description, Account account){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            Image image = new Image(photoPath,  sampleNumber, description, account);
            session.save(image);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to  READ all the files by filepath and account*/
    public List<Image> listOfImages(String photoPath, String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Image> files=null;
        int size=0;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Image where photoPath=? and account=?");
            query.setString(0, photoPath);
            query.setString(1, account);
            //query.setMaxResults(1);
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

    /* Method to  READ all the files by sampleNumber and account*/
    public List<Image> listImages(String sampleNumber, String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Image> files=null;
        int size=0;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Image where sampleNumber=? and account=?");
            query.setString(0, sampleNumber);
            query.setString(1, account);
            //query.setMaxResults(1);
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

    /* Method to  READ all the images by user */
    public List<Image> listOfImages(String account){
        Session session = factory.openSession();
        Transaction tx = null;
        List <Image> images=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Image where account=? ORDER BY photoId ASC");
            query.setString(0, account);
            images = query.list() ;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return images;
    }


    /* Method to UPDATE photoPath, sampleNumber and description for an image */
    public void updateImage(int photoId, String photoPath, String sampleNumber, String description){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Image image = (Image) session.get(Image.class, photoId);
            image.setPhotoId(photoId);
            image.setPhotoPath(photoPath);
            image.setSampleNumber(sampleNumber);
            image.setDescription(description);
            session.update(image);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an files from the records */
    public void deleteFiles(int photoId){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Image image = (Image) session.get(Image.class, photoId);
            session.delete(image);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
