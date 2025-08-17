package h_OOPS.Interfacee.Nice_Car;

public class a_ElectricEngine implements a_Engine{

    @Override
    public void start() {
        System.out.println("Electric Engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Electric Engine stops");
    }

    @Override
    public void acc() {
        System.out.println("Electric Engine accelerate");
    }
}
