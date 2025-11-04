package h_OOPS.Interfacee.Nice_Car;

// The Nice_Car class models a car that has both an engine and a music player.
// It uses interfaces for flexibility, allowing different engine or media player implementations.
public class Nice_Car {

    // The engine of the car, using the a_Engine interface for flexible engine types.
    private a_Engine engine;

    // The music player of the car, using the b_Media interface.
    // It is initialized by default to a b_CD_player instance.
    private b_Media musicPlayer = new b_CD_player();
    // Reference type: b_Media (an interface)
    // Actual object: b_CD_player (a class that implements b_Media)
    // When the reference type is an interface, you can only access the properties and methods declared in that interface, even if the actual object has more members.

    // Default constructor: initializes the car with a PowerEngine by default.
    public Nice_Car(){
        engine = new a_PowerEngine();
    }

    // Overloaded constructor: allows the user to specify a custom engine type.
    public Nice_Car(a_Engine engine){
        this.engine = engine;
    }

    // Starts the engine of the car.
    public void start(){
        engine.start();
    }

    // Stops the engine of the car.
    public void stop(){
        engine.stop();
    }

    // Accelerates the car using the engine.
    public void acc(){
        engine.acc();
    }

    // Starts the music player.
    public void Music_start(){
        musicPlayer.start();
    }

    // Stops the music player.
    public void Music_stop(){
        musicPlayer.stop();
    }

    // Upgrades the car's engine to an ElectricEngine.
    public void UpgradetoElectric(){
        this.engine = new a_ElectricEngine();
    }

    // Upgrades the car's engine to a PowerEngine.
    public void UpgradetoPower(){
        this.engine = new a_PowerEngine();
    }
}