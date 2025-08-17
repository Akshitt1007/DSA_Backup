package h_OOPS.Interfacee.Nice_Car;

public class a_PowerEngine implements a_Engine {

    @Override
    public void start() {
        System.out.println("Power Engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Power Engine stops");
    }

    @Override
    public void acc() {
        System.out.println("Power Engine accelerate");
    }
}
