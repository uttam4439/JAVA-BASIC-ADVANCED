class Utility {
    //A method marked static belongs to the class, not to instances.
    static void showMessage() { 
        System.out.println("Hello from static method!");
    }
}
// Cannot use this or super inside it

/* 
class Test {
    int age = 25;  // non-static
    static void show() {
        System.out.println(age);  // ❌ Error: Cannot access non-static field from static context
    }
} 
    */
public class AboutStatic{

/* All About Static  */
int roll;

AboutStatic(int r){
    roll = r;
}
static String college = "Galgotias";
void display(){
    System.out.println(college + " " + roll);
}

public static void main(String args[]){
    AboutStatic a1 = new AboutStatic(101);
    AboutStatic a2 = new AboutStatic(102);

    AboutStatic.college = "IIT";  // If static variable then changed to new Value to both 
    a1.display(); // Here both print Galgotias which is share by static keyword
    a2.display();

    Utility.showMessage(); 
    //Test.show();
}
}