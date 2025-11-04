package h_OOPS;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Hall{
    private String name;
    private long  contactNumber;
    private double costPerDay;
    private String Owner;
    private Date date;

    Hall( String name, long contactNumber, double costPerDay, String Owner, Date date ){
        this.name=name;
        this.contactNumber=contactNumber;
        this.costPerDay=costPerDay;
        this.Owner=Owner;
        this.date=date;
    }
    public String getName(){
        return name;
    }
    public long getContactNumber(){
        return contactNumber;
    }
    public double getCostPerDay(){
        return costPerDay;
    }
    public String getOwner(){
        return Owner;
    }
    public Date getDate(){
        return date;
    }

    public boolean equals( Object obj ){
        if ( this == obj ){
            return true;
        }
        if( obj == null ){
            return false;
        }
        Hall currHall = (Hall) obj;
        return name.equals(currHall.name) &&
                contactNumber==(currHall.contactNumber) &&
                costPerDay==(currHall.costPerDay) &&
                Owner.equals(currHall.Owner) &&
                date.equals(currHall.date);
    }
}


public class x1_Hall_Equality {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the details of Hall 1");
        System.out.print("Name :\n");
        String name1 = scanner.nextLine();
        System.out.print("Contact Number :\n");
        Long contactNumber1 = scanner.nextLong();
        System.out.print("Cost Per Day :\n");
        Double costPerDay1 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Owner Name :\n");
        String ownerName1 = scanner.nextLine();
        System.out.print("Booking Date(dd/mm/yyyy) :\n");
        Date bookingDate1 = sdf.parse(scanner.nextLine());

        Hall hall1 = new Hall(name1, contactNumber1, costPerDay1, ownerName1, bookingDate1);

        System.out.println("Enter the details of Hall 2");
        System.out.print("Name :\n");
        String name2 = scanner.nextLine();
        System.out.print("Contact Number :\n");
        Long contactNumber2 = scanner.nextLong();
        System.out.print("Cost Per Day :\n");
        Double costPerDay2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Owner Name :\n");
        String ownerName2 = scanner.nextLine();
        System.out.print("Booking Date(dd/mm/yyyy) :\n");
        Date bookingDate2 = sdf.parse(scanner.nextLine());

        Hall hall2 = new Hall(name2, contactNumber2, costPerDay2, ownerName2, bookingDate2);

        if (hall1.equals(hall2)) {
            System.out.println("Halls are same");
        } else {
            System.out.println("Halls are different");
        }

        scanner.close();
    }
}
