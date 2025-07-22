import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetching {
    public static void main(String[] args) {
        Student gg = new Student();

//        gg.setId(17);
//        gg.setName("Hibernate");
//        gg.setMarks(30);

        System.out.println(gg);
        Student s2 = null;

        //configure in one line
        SessionFactory sf = new Configuration().addAnnotatedClasses(Student.class).configure().buildSessionFactory();
        Session kk = sf.openSession(); // To create a new Session

        s2 = kk.getReference(Student.class ,212);
        System.out.println((s2));
//        kk.close();
////        sf.close();

    }
    //We put all the xml files in resources folder
}

