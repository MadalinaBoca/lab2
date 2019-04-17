package lab2MV;

import Domain.Nota;
import Domain.Student;
import Domain.Teme;
import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.AbstractMap;
import java.util.Map;

public class AppTestBigBang {

    @Test
    public void addAssignmentTest(){
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme2.xml");

        int nr = 100;
        String desc = "O descriere";
        int deadline = 10;
        int sapt_primire = 8;

        repo.save(new Teme(nr,desc, sapt_primire, deadline));
    }

    @Test(expected = ValidationException.class)
    public void addStudentTest(){
        StudentRepo repo =new StudentRepo(new StudentValidator(),"studenti2.xml");

        String id = "2207";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "2Profesor X";

        repo.save(new Student(id,name,group,email,teacher));
    }

    @Test
    public void addGradeTest(){
        NoteRepo noteRepo=new NoteRepo(new NotaValidator());
        String id = "2207";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "2Profesor X";
        Student student=new Student(id,name,group,email,teacher);

        int nr = 100;
        String desc = "O descriere";
        int deadline = 10;
        int sapt_primire = 8;
        Teme tema=new Teme(nr,desc,sapt_primire,deadline);

        Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>(id, nr);

        float nota = 10;
        int data = 9;
        Nota nt = new Nota(nid, student, tema, nota, data);

        float nota2 = nt.getValoare();
        Nota nt2 = new Nota(nid, student, tema, nota, data);

        noteRepo.save(nt2,"feedback good");

    }


    @Test
    public void integration(){
        TemeRepo repoTeme = new TemeRepo(new TemeValidator(), "teme2.xml");
        StudentRepo repoStudenti =new StudentRepo(new StudentValidator(),"studenti2.xml");
        NoteRepo noteRepo=new NoteRepo(new NotaValidator());

        assertTrue(repoStudenti.size() == 1);
        assertTrue(repoTeme.size() == 1);

    }

}
