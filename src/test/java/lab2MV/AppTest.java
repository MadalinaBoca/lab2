package lab2MV;

import static org.junit.Assert.assertTrue;

import Domain.Student;
import Repository.StudentRepo;
import Validator.StudentValidator;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addStudentGoodEmail() {
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2206";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206@scs.com";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));

    }

    @Test
    public void addStudentBadEmail() {
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2206";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206@scs.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));

    }

    @Test
    public void addStudentBadId(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");
        int nrStud = repo.size();

        String id = "-1";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206scs";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }
}
