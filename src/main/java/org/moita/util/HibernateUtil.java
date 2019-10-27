package org.moita.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final String HIBERNATE_CFG_XML = "hibernate.cfg.xml";

    public static Session getSession() {

        final SessionFactory sf = new Configuration().configure(HIBERNATE_CFG_XML).buildSessionFactory();

        return sf.openSession();
    }
}