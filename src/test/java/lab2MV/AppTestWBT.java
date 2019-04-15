package lab2MV;

import Domain.Teme;
import Repository.TemeRepo;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTestWBT {

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void TC_1(){
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");

        int nr = 100;
        String desc = "O descriere";
        int deadline = 10;
        int sapt_primire = 8;

        repo.save(new Teme(nr,desc, sapt_primire, deadline));
    }

    @Test(expected = ValidationException.class)
    public void TC_2(){
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml");

        int nr = 0;
        String desc = "O descriere";
        int deadline = 15;
        int sapt_primire = 0;

        repo.save(new Teme(nr,desc, sapt_primire, deadline));
    }
}
