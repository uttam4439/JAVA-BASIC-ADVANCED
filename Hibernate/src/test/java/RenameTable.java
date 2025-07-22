import jakarta.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

// @Entity(name = "My_Table")   this help in renaming table without changing Class name (JPQL and HQL)
@Entity
// @Table(name = "Hello")   Only Changing Table Name not Entity
public class RenameTable {

    @Id
    private int pid;
    // @Column(name = "g_name") This is for changing column name
    private String pname;

    // @Transient     This is used if I don't want to save data for this column in table
    private int pvalue;

    public int getPvalue() {
        return pvalue;
    }

    public void setPvalue(int pvalue) {
        this.pvalue = pvalue;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "RenameTable{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pvalue=" + pvalue +
                '}';
    }

    public static void main(String[] args){
        RenameTable r1 = new RenameTable();

        r1.setPid(2);
        r1.setPname("Kumar");
        r1.setPvalue(101);

        SessionFactory gg = new Configuration().addAnnotatedClasses(RenameTable.class).configure().buildSessionFactory();
        Session kk = gg.openSession();

        Transaction ts = kk.beginTransaction(); // Every Time data is saved it follows transaction
        kk.persist(r1);
        ts.commit();

        kk.close();
        gg.close();
    }
}
