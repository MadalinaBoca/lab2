package lab2MV;

import static org.junit.Assert.assertTrue;

import Domain.Student;
import Repository.StudentRepo;
import Validator.StudentValidator;
import Validator.ValidationException;
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
    public void addStudentGoodId(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");
        //int nrStudBefore = repo.size();

        String id = "21";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));

        //int nrStudAfter = repo.size();
    }

    @Test(expected = ValidationException.class)
    public void addStudentBadId(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");
        int nrStud = repo.size();

        String id = "-1";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentNullId(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");
        int nrStud = repo.size();

        String id = null;
        String name = "Alex";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentEmptyStringId(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");
        int nrStud = repo.size();

        String id = "";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
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

    @Test(expected = ValidationException.class)
    public void addStudentBadEmail() {
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2206";
        String name = "Alex";
        int group = 931;
        String email = "pbie2206scsro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = NullPointerException.class)
    public void addStudendNullEmail(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2206";
        String name = "Alex";
        int group = 931;
        String email = null;
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudendEmptyStringEmail(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2206";
        String name = "Alex";
        int group = 931;
        String email = "";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test
    public void addStudentGoodName(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentBadName(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = "2Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = NullPointerException.class)
    public void addStudentNullName(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = null;
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentEmptyStringName(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = "";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test
    public void addStudentGoodProfessor(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2208";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentBadProfessor(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "2Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = NullPointerException.class)
    public void addStudentNullProfessor(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = null;

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentEmptyStringProfessor(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2207";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test
    public void addStudentGoodGroup(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2209";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Boca Madalina";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test(expected = ValidationException.class)
    public void addStudentBadGroup(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2209";
        String name = "Popsor Alexandru";
        int group = 100;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Boca Madalina";

        repo.save(new Student(id,name,group,email,teacher));
    }

   @Test(expected = ValidationException.class)
   public void addStudentBadSecondDigitGroup(){
       StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

       String id = "2209";
       String name = "Popsor Alexandru";
       int group = 991;
       String email = "pbie2206@scs.ubbcluj.ro";
       String teacher = "Boca Madalina";

       repo.save(new Student(id,name,group,email,teacher));
   }

    @Test(expected = ValidationException.class)
    public void addStudentBadLastDigitGroup(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti.xml");

        String id = "2209";
        String name = "Popsor Alexandru";
        int group = 930;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Boca Madalina";

        repo.save(new Student(id,name,group,email,teacher));
    }
}
