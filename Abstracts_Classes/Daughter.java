package h_OOPS.Abstracts_Classes;

public class Daughter extends Parent{

    Daughter(int age){
        super(age);
    }

    @Override
    public void Carrier() {
        System.out.println( "I want to be a Doctor");
    }

    @Override
    public void Choice() {
        System.out.println( "I love malkova");
    }
}
