package h_OOPS.Abstracts_Classes;

public class Son extends Parent{

    Son(int age){
        super(age);
    }

    @Override
    public void Carrier() {
        System.out.println( "I want to be a Coder");
    }

    @Override
    public void Choice() {
        System.out.println( "I love willis");
    }
}
