package com.epsi.projectaps.model;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageUser {

    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            //factory = new Configuration().configure().buildSessionFactory();

            Configuration config = new Configuration();
            config.addClass(User.class);
            factory = config.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageUser ME = new ManageUser();

        /* Add few user records in database */
        Integer empID1 = ME.addUser("Zara", "Ali", "zaraali@mail.com");
        Integer empID2 = ME.addUser("Daisy", "Das", "daisydas@mail.com");
        Integer empID3 = ME.addUser("John", "Paul", "johnpaul@mail.com");

        /* List down all the users */
        ME.listUsers();

        /* Update user's records */
        ME.updateUser(empID1, "UPADTE@MAIL.COM", "UPDATE_USER");

        /* Delete an user from the database */
        ME.deleteUser(empID2);

        /* List down new list of the users */
        ME.listUsers();
    }

    /* Method to CREATE an user in the database */
    public Integer addUser(String username, String password, String usermail){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = null;

        try {
            tx = session.beginTransaction();
            User user = new User(username, password, usermail);
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }

    /* Method to  READ all the users */
    public void listUsers( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM User").list();
            for (Iterator iterator = users.iterator(); iterator.hasNext();){
                User user = (User) iterator.next();
                System.out.print("Username : " + user.getUserName());
                System.out.print("UserMail : " + user.getUserMail());
                System.out.println("UserPassword : " + user.getPassword());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE salary for an user */
    public void updateUser(Integer UserID, String userMail, String userName){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = (User)session.get(User.class, UserID);
            user.setUserMail(userMail);
            user.setUserName(userName);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an user from the records */
    public void deleteUser(Integer UserID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = (User)session.get(User.class, UserID);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}