package com.ani.orm.ormdetails.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.List;
import java.util.Properties;

public class ManageStudent {

    public static void main(String[] args) {
        try {
            final SessionFactory factory = sessionFactory();

            final ManageStudent ms = new ManageStudent();
            ms.save(factory);
            ms.findAll(factory);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SessionFactory sessionFactory() throws Exception {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.h2.Driver");
        properties.put(Environment.URL, "jdbc:h2:mem:testdb");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "password");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");

        return new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    private void save(final SessionFactory factory) {
        final Session session = factory.openSession();
        final Transaction txn = session.beginTransaction();
        session.save(
                new Student(
                        1L, "anc", 10
                )
        );
        txn.commit();
    }

    private void findAll(final SessionFactory factory) {
        final Session session = factory.openSession();
        final Transaction txn = session.beginTransaction();
        List<Student> students = session.createQuery("from Student").list();
        students.forEach(System.out::println);
        txn.commit();
    }
}
