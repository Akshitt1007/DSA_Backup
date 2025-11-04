package h_OOPS.Collection_Vector_Enum;

public class c2_Enums_with_Method {

    enum Status {

        SUCCESS(200), ERROR(500), LOADING(102);

        private int code;   // field

        // Constructor
        Status(int code) {
            this.code = code;
        }

        public int getCode() {   // method
            return code;
        }
    }

    public static void main(String[] args) {

        Status s = Status.SUCCESS;

        System.out.println("Status: " + s);
        System.out.println("Code: " + s.getCode());

    }
}
