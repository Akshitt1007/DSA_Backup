package h_OOPS.Interfacee.Nice_Car;

public class b_CD_player implements b_Media {

    @Override
    public void start() {
        System.out.println("Music player starts");
    }

    @Override
    public void stop() {
        System.out.println("Music Player stops");
    }
}
