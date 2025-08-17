package h_OOPS.Access;

class Sub extends Access_Modifiers{
    public Sub(int default_num, String name) {
        super(default_num, name);
    }
}

class Sub_class{
    public static void main(String[] args) {
        Sub x = new Sub(10, "Ron" );
        System.out.println( x.name );
    }
}
