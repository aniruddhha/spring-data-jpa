package com.ani.orm.ormdetails.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManageEmployee {

    public static void main(String[] args) {
        final SessionFactory factory = new Configuration().configure().buildSessionFactory();
        ManageEmployee em = new ManageEmployee();
        em.save(factory);

        em.findAll(factory);
    }

    public void save(final SessionFactory factory) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        Employee emp = new Employee(12L, "abc", "pqr", 45);
        session.save(emp);
        tx.commit();
    }

    public void findAll(final SessionFactory factory) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee").list();
        employees.forEach(System.out::println);

        tx.commit();
    }
}
