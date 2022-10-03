public class ChildClass extends AbstractClass implements Interface1, Interface2 {
    public ChildClass() {
    }

    public void printMessage() {
        System.out.println("From ChildClass");
    }


    public static void main(String[] args) {
        ChildClass myChild = new ChildClass();
        myChild.printMessage();

        myChild.printMessageInterface1();
        myChild.printMessageInterface2();

        Interface1 test1 = new ChildClass();
        test1.printMessageInterface1();

        AbstractClass test2 = new ChildClass();
        test2.printMessage();
    }

    public void printMessageInterface1() {
        System.out.println("From Interface 1");
    }

    public void printMessageInterface2() {
        System.out.println("From Interface 2");
    }
}
