abstract class Abstraction{
    abstract void run();
}

class Dog extends Abstraction{

    @Override  // not necessary if you convention is right but recommended to use in more 
    void run(){
        System.out.println("Running");
    }
}
class Cat extends Dog{
    @Override
    void run(){
        System.out.println("Fast running");
    }
}

public class Binding{
    public static void main(String[] args) {
        // Abstraction d1 = new Abstraction();   obejct can't be created of abstarct class
        Abstraction d1 = new Dog();
        Abstraction d2 = new Cat();
        d1.run();
        d2.run();
        }
    }

