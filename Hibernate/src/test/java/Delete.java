import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete{
    public static void main(String[] args) {
        Student gg = new Student();

        //configure in one line
        SessionFactory sf = new Configuration().addAnnotatedClasses(Student.class).configure().buildSessionFactory();
        Session kk = sf.openSession(); // To create a new Session

        gg = kk.getReference(Student.class,212);  // First we are fetching data

        Transaction ts = kk.beginTransaction();

        kk.remove(gg);  // remove from the database

        ts.commit();

        kk.close();
        sf.close();


        System.out.println((gg));


    }
}

