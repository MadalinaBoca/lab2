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
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

public class AppTestII {


    @Test
    public void addStudentTest() {
        StudentRepo repo = new StudentRepo(new StudentValidator(), "studenti3.xml");

        String id = "1111";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id, name, group, email, teacher));
    }

    @Test
    public void addAssignmentTest() {
        StudentRepo repo = new StudentRepo(new StudentValidator(), "studenti3.xml");

        String id = "1112";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";

        repo.save(new Student(id, name, group, email, teacher));


        TemeRepo repoteme = new TemeRepo(new TemeValidator(), "teme3.xml");

        int nr = 100;
        String desc = "O descriere";
        int deadline = 10;
        int sapt_primire = 8;

        repoteme.save(new Teme(nr, desc, sapt_primire, deadline));
    }

    @Test
    public void addGrade() {
        StudentRepo repo = new StudentRepo(new StudentValidator(), "studenti3.xml");
        String id = "1113";
        String name = "Popsor Alexandru";
        int group = 931;
        String email = "pbie2206@scs.ubbcluj.ro";
        String teacher = "Profesor X";
        repo.save(new Student(id, name, group, email, teacher));

        TemeRepo repoteme = new TemeRepo(new TemeValidator(), "teme3.xml");
        int nr = 101;
        String desc = "O descriere";
        int deadline = 10;
        int sapt_primire = 8;
        repoteme.save(new Teme(nr, desc, sapt_primire, deadline));

        Student std = repo.findOne(id);
        Teme tema = repoteme.findOne(nr);
        if (std != null && tema != null) {
            Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>(id, nr);
            NoteRepo noteRepo = new NoteRepo(new NotaValidator());
            float nota = 10;
            int data = 9;

            Nota nt = new Nota(nid, std, tema, nota, data);
            float nota2 = nt.getValoare();
            Nota nt2 = new Nota(nid, std, tema, nota2, data);
            noteRepo.save(nt2,"feedback good");
        }
        else throw new NullPointerException();

    }


}
