// import java.lang.reflect.Method;

public class AccessModifier {
    public static void main(String[] args) {
        int n = 10;
        AccessModifier cs = new AccessModifier();
        cs.call(n);

    //     Method m = AccessModifier.class.getDeclaredMethod("Sort", int.class);
    //     m.setAccessible(true); // ⚠️ allow access to private method
    //     m.invoke(cs, 10); // or `null` if method is static
    // }
    
    }
    public void call(int n){  // to call a private method with in the class.
        Sort(n);
    }
    private static void Sort(int n){
        System.out.println( "Hello" + " " + n);
    }
}


