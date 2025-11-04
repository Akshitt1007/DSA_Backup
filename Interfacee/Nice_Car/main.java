package h_OOPS.Interfacee.Nice_Car;

public class main {
    public static void main(String[] args) {

        Nice_Car car = new Nice_Car();

        car.start();
        car.stop();
        car.Music_start();
        car.Music_stop();

        System.out.println();
        car.UpgradetoElectric();
        car.start();
        car.stop();

        // Nice_Car carII = new Nice_Car( a_ElectricEngine );
        // Error: You’re passing a type (the class itself), not an object.
        // Fix: Pass an object instance (new a_ElectricEngine()), not the class name.

        System.out.println();
        Nice_Car carII = new Nice_Car(new a_ElectricEngine() );
        carII.start();
        carII.stop();

        System.out.println();
        carII.UpgradetoPower();
        carII.start();
        carII.stop();
    }
}
