import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student gg = new Student();

        gg.setId(212);
        gg.setName("Hibernate");
        gg.setMarks(30);

        System.out.println(gg);

//        Configuration cfg = new Configuration(); // We have to configure how to save data. what requires
//        cfg.addAnnotatedClasses(Student.class); // if package the name should be here
//        cfg.configure();

        //configure in one line
        SessionFactory sf = new Configuration().addAnnotatedClasses(Student.class).configure().buildSessionFactory();
        Session kk = sf.openSession(); // To create a new Session
        //To fetch the session i need fetch session

        Transaction ts = kk.beginTransaction(); // Every Time data is saved it follows transaction
        kk.persist(gg);
        ts.commit();

        kk.close();
        sf.close();

    }
    //We put all the xml files in resources folder
}
