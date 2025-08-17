package h_OOPS;

import java.util.Scanner;

class Event{
    private String name;
    private String detail;
    private String organiserName;
    Event(String name, String detail, String organiserName){
        this.name=name;
        this.detail=detail;
        this.organiserName=organiserName;
    }
    Event(){
        name=null;
        detail=null;
        organiserName=null;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDetail(String detail){
        this.detail=detail;
    }
    public void setOrganiserName(String organiserName){
        this.organiserName=organiserName;
    }
    public String getName(){
        return name;
    }
    public String getDetail(){
        return detail;
    }
    public String getOrganiserName(){
        return organiserName;
    }

    public double projectedRevenue(){
        return 0.0;
    }
}

class Exhibition extends Event {
    private int noOfStalls;
    Exhibition(String name, String detail, String organiserName, int noOfStalls){
        super( name, detail, organiserName);
        this.noOfStalls=noOfStalls;
    }
    public void setNoOfStalls(int n ){
        this.noOfStalls=n;
    }
    public int getNoOfStalls(){
        return noOfStalls;
    }
    @Override
    public double projectedRevenue(){
        return noOfStalls*10000.0;
    }
}

class StageEvent extends Event {
    private int noOfSeats;
    private int noOfSeatsPerShow;
    StageEvent(String name, String detail, String organiserName, int noOfSeats, int noOfSeatsPerShow){
        super( name, detail, organiserName);
        this.noOfSeats=noOfSeats;
        this.noOfSeatsPerShow=noOfSeatsPerShow;
    }
    public void setNoOfSeats(int n ){
        this.noOfSeats=n;
    }
    public int getNoOfSeats(){
        return noOfSeats;
    }
    public void setNoOfSeatsPerShow( int n ){
        this.noOfSeatsPerShow=n;
    }
    public int getNoOfSeatsPerShow(){
        return noOfSeatsPerShow;
    }

    @Override
    public double projectedRevenue(){
        return noOfSeats*noOfSeatsPerShow*50.0;
    }
}

public class x2_Overriding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the event:");
        String name = sc.nextLine();

        System.out.println("Enter the detail of the event:");
        String detail = sc.nextLine();

        System.out.println("Enter the owner name of the event:");
        String ownerName = sc.nextLine();

        System.out.println("Enter the type of the event:");
        System.out.println("1.Exhibition");
        System.out.println("2.StageEvent");
        int eventType = sc.nextInt();

        if (eventType == 1) {
            System.out.println("Enter the number of stalls:");
            int noOfStall = sc.nextInt();
            Exhibition exhibition = new Exhibition(name, detail, ownerName, noOfStall);
            System.out.println("The projected revenue of the event is " + exhibition.projectedRevenue());
        } else if (eventType == 2) {
            System.out.println("Enter the number of shows:");
            int noOfShows = sc.nextInt();
            System.out.println("Enter the number of seats per show:");
            int noOfSeatsPerShow = sc.nextInt();
            StageEvent stageEvent = new StageEvent(name, detail, ownerName, noOfShows, noOfSeatsPerShow);
            System.out.println("The projected revenue of the event is " + stageEvent.projectedRevenue());
        }

        sc.close();
    }
}
