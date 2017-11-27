/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import static DAO.QuizerDao.session;
import Entity.User;
import Util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

public class UserDao {
    
       @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void saveUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public static User getUser(User usr) {
      @SuppressWarnings("unchecked")
      List<User> users = session.createQuery("from User").list();
      	Iterator<User> it = users.iterator();
		User tempUser;
		for(;it.hasNext(); )
		{
			tempUser = it.next();
                        if(tempUser.getUserName().equals(usr.getUserName())&&tempUser.getPassword().equals(usr.getPassword()))
                            return tempUser;
		}
//      return query.getResultList();
   }

//	static ServiceRegistry  serviceRegistry ;
//	static SessionFactory sessionFactory;
//        static Session session;
//	
//	public UserDao(){
//		// TODO Auto-generated method stub
//        sessionFactory = HibernateUtil.getSessionFactory();
//        session = sessionFactory.openSession();
//        //nested Transactions are not supported. Once you have started transaction here
//        // can't do that in the saveEmployee method.
//        //session.beginTransaction();
//	}
//	
//	public static void saveUser(User user){
//		Transaction t=session.beginTransaction();  
//                session.persist(user);
//      		t.commit(); 
//	}
//
//	public static User getUser(User usr)
//	{
//		List<User> users = session.createQuery("from User").list();
//		Iterator<User> it = users.iterator();
//		User tempUser;
//		for(;it.hasNext(); )
//		{
//			tempUser = it.next();
//                        if(tempUser.getUserName().equals(usr.getUserName())&&tempUser.getPassword().equals(usr.getPassword()))
//                            return tempUser;
//		}
//                return new User();
//	}
//	
//	public void closeSession()
//	{
//        session.close();
//        sessionFactory.close();
//	}
}
