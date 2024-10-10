package org.example.hibernate.starter;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    public static SessionFactory getSessionFactory()
    {
        Configuration confinuration = new Configuration();
        confinuration.configure("hibernate.cfg.xml");
//        confinuration.addAnnotatedClass(User.class);
        return confinuration.buildSessionFactory();
    }
}
