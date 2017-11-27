import Entity.User;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Muhammad Umer
 */
public class UserTest extends TestCase {
@Test    
public void testUsersEquality(){
    User student=new User("Muhammad","Umer","Student");
    User instructor=new User("Muhammad","Umer","Instructor");
    User student1=new User("Muhammad","Umer","Instructor");
    User instructor1=new User("Muhammad","Umer","Student");
    User student2=new User("Muhammad","Umer","Student");
    User student3=new User("Muhammad","Umer","Student",0);
    assertFalse(student.equals(instructor));
    assertFalse(student1.equals(instructor1));
    assertFalse(student2.equals(student3));
}
    
}
