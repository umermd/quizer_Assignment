/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Quiz;
import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

public class QuizerDao {
	static ServiceRegistry  serviceRegistry ;
	static SessionFactory sessionFactory;
        static Session session;
	
	public QuizerDao(){
		// TODO Auto-generated method stub
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        //nested Transactions are not supported. Once you have started transaction here
        // can't do that in the saveEmployee method.
        //session.beginTransaction();
	}
	
	public static void saveQuiz(Quiz qz){
		Transaction t=session.beginTransaction();  
                session.persist((Quiz) qz);
      		t.commit(); 
	}

	public static List<Quiz> getQuizzes()
	{
		List<Quiz> quizzes = session.createQuery("from Quiz").list();
		return quizzes;
	}
	
        public static Quiz getQuiz(String title){
            List<Quiz> quizzes=session.createQuery("from Quiz").list();
            Iterator<Quiz> it=quizzes.iterator();
            Quiz tempQuiz;
            for(;it.hasNext();){
                tempQuiz = it.next();
                        if(tempQuiz.getTitle().equals(title))
                            return tempQuiz;
            }
                return new Quiz();
        }
        
	public void closeSession()
	{
        session.close();
        sessionFactory.close();
	}
}
