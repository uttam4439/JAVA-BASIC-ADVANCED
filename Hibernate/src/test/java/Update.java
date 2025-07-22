import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update{
    public static void main(String[] args) {
        Student gg = new Student();

        gg.setId(181);
        gg.setName("Java2");
        gg.setMarks(30);

        //configure in one line
        SessionFactory sf = new Configuration().addAnnotatedClasses(Student.class).configure().buildSessionFactory();
        Session kk = sf.openSession(); // To create a new Session

        Transaction ts = kk.beginTransaction();
        kk.merge(gg); // If data is already available it got updated else it get inserted in the database
        ts.commit();

        kk.close();
        sf.close();


        System.out.println((gg));


    }
}
