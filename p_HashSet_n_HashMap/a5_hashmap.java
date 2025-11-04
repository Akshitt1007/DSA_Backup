package p_HashSet_n_HashMap;

// To import the hashmap
import java.util.HashMap;

public class a5_hashmap {
    public static void main(String[] args) {

        // String -> the thing that will get converted into Hashcode which will provide as the index
        // Integer -> the value we want to store
        HashMap<String, Integer> map = new HashMap<>();

        // 1. Adding Elements
        map.put("Akshit", 1769);
        map.put("Blueberry", 69);

        // 2. Accessing the Element
        System.out.println( map.get("Akshit") );


        // 3. If we add a key that already exists, it overwrites the old value.
        System.out.println( map.get("Blueberry"));

        map.put("Blueberry", 67);                   // price gets replaced
        System.out.println( map.get("Blueberry"));


        // 4.Checking if Key or Value Exists
        System.out.println( map.containsKey( "Blueberry" )  );
        System.out.println( map.containsKey( "Aryan" )  );

        System.out.println( map.containsValue(1769) );
        System.out.println( map.containsValue(1111) );


        // 5. chck whether there is a key mapped in Map
        // If yes returns the stored value
        // If not, returns the default value we have given
        System.out.println( map.getOrDefault( "Akshit", 9999) );
        System.out.println( map.getOrDefault( "Rohit", 9999) );

        // 6. Chck whether the map is empty or not
        System.out.println( map.isEmpty() );


        // 7. Returns the size of the map
        System.out.println( map.size() );

        // 8. Shows all the key with their value mapped in the HashMap
        System.out.println( map.entrySet() );


        // 9. Clear all Elements in the map
        map.clear();



    }
}
