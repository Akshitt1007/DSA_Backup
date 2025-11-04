package p_HashSet_n_HashMap;

/*
    Why Use Hashmap?

        - if we have to find any element in a given array
          arr = [2,6,4,5,7,10,9,33,44]

        1. We can traverse the entire array using loop and returning the index when found
           - Time Complexity: O(n)
           - Because in the worst case, you might have to look at every element.

        2. If we sort the array then, we can a make a tree of this arr and search in that
           - Time Complexity: O(log n)
           - Better — you’re narrowing down by half each time.

        3. But if I want to find the given element in O( 1 )
           - we will use HashMaps

    A HashMap uses a hash function to compute a unique “address” (called a hash code) for every key.
    That hash code tells you exactly where the value lives — no searching, no comparing, just direct access.


    So HashMap consists of "Keys" and "Value"

        key     |     value
        Kunal   |       88
        akshit  |       98
        aryan   |       97

    - So when we do map.get("akshit")
    - it will return the value 88 in constant time

    HashMap Key and Value Concept:

        - In a HashMap, data is stored in the form of key–value pairs.
        - The key acts like an index in an array.
        - The value is what you want to store or retrieve.
        - So conceptually:

            map[key] = value
                    |
            arr[index] = value

        * Difference:
            - In an array, the index is a number (0, 1, 2, …).
            - In a HashMap, the key can be any object (String, Integer, etc.).
        - Internally, the key is converted into an index using a hash function → this index decides where the value is stored.
        - Accessing, inserting, or deleting data is O(1) on average.

 */
public class a1_Intro_n_Working {
    public static void main(String[] args) {

        // - Here the String object will get converted into a unique number which is known as HashCode
        // - and this HashCode will only represent the String which have the same data ie aaron here
        // - Two strings with the same content ("aaron" and another "aaron") will always have the same hashCode.
        String name1 = "aaron";
        String name2 = "aaron";

        int code1 = name1.hashCode();
        int code2 = name2.hashCode();

        System.out.println( code1 );
        System.out.println( code2 );


        /*
        Hash Collision:

            A hash code is just an integer (a 32-bit number).
            But there are billions of possible strings in the world, way more than the number of distinct 32-bit integers.

            So, sometimes…
            two different strings can accidentally produce the same hash code.

            That’s called a hash collision.
         */
        System.out.println("FB".hashCode());
        System.out.println("Ea".hashCode());


        // The HashCode of an Integer number is itself
        // upt0 a particular limit.
        Integer x = 10;
        int y = 10;
        int xh = x.hashCode();
//        int yh = hashCode(y);         // We can't have the Hashcode for the primitive datatype that's why we use Integer
        System.out.println( xh );


        /*
         Working of HashMap in Java
         ---------------------------------

         1. Basic Idea:
            - A HashMap internally uses an array of buckets.
            - Each bucket stores key-value pairs.
            - The position of each key in the array is decided by its hash value.
            - Since the hashcode would be big, so we do hashing
            - if the array size = 10, we need all the hash less than 10
            - so we do index = hashcode % 10

         2. Adding (put operation):
            - Suppose we have an internal array of size 10.
            int arr[] = [ , , , , , , , , , ]

            - Example: put("civo", value)
            → "civo".hashCode() → generates a large integer (say 65432123)
            → index = 65432123 % 10 = 3
            → arr[3] = ("civo", value)

            - Example: put("akshit", value)
            → "akshit".hashCode() → say 45678123
            → index = 45678123 % 10 = 7
            → arr[7] = ("akshit", value)

            - Example: put("aryan", value)
            → "aryan".hashCode() → say 98231123
            → index = 98231123 % 10 = 2
            → arr[2] = ("aryan", value)

         3. Accessing (get operation):
            - To access: get("akshit")
            → "akshit".hashCode() → 7
            → arr[7] → returns ("akshit", value)

         4. Collision Handling:
            - Sometimes two keys may produce the same index.
            Example:
            "aryan".hashCode() % 10 = 3
            "civo".hashCode() % 10 = 3

         - Both map to the same bucket → collision occurs.
         - HashMap resolves this using:
         → Linked List (Java 7 and below)
         → Balanced Tree (Java 8 and above)

         5. Summary:
            Step 1 → Compute hash code.
            Step 2 → Compress hash using modulo (hash % array.length).
            Step 3 → Store key-value pair in that index.
            Step 4 → Retrieve by recalculating hash.
            Step 5 → If collision → handle using LinkedList / Tree.

         6. Key Idea:
            - Hashing makes access and insertion very fast.
            - Average time complexity → O(1)
            - Worst case (many collisions) → O(log n)
         */

        /*
         How HashMap Works Internally

         ➤ Example:
            map.put("akshit", 1000);

         ➤ Step 1: Key Conversion
            The key "akshit" (a String) is first converted into a unique number using hashCode().
            Example: "akshit".hashCode() → 93124321 (some integer)

         ➤ Step 2: Hash Reduction
            This large number (93124321) is then reduced using a formula to fit within the array’s index range
            Example: 93124321 % array.length → 3

         ➤ Step 3: Index Determination
            The reduced number (3) decides the bucket or slot (index) where the value will be stored.
            So internally → arr[3] = 1000

         ➤ Step 4: Key as a Reference
            Conceptually, you can imagine "akshit" acting like an index.
            So → arr["akshit"] = 1000

         ➤ Step 5: Retrieving the Value
            When you do map.get("akshit"), it repeats the process:
            hashCode("akshit") → reduce → find same index (3) → return 1000
         */



    }
}
