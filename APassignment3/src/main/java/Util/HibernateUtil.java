package Util;

import Entity.Question;
import Entity.Quiz;
import Entity.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	// A SessionFactory is set up once for an application!
        private static SessionFactory sessionFactory=null;

private static SessionFactory buildSessionFactory() {

    try {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Question.class);
        cfg.addAnnotatedClass(Quiz.class);
        cfg.addAnnotatedClass(User.class);
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
        
    }
    catch (HibernateException e) {
        // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
        // so destroy it manually.
        
        throw new ExceptionInInitializerError(e);
    }
}

public static SessionFactory getSessionFactory() {
    if(sessionFactory==null){
        buildSessionFactory();
    }
    return sessionFactory;
}
}