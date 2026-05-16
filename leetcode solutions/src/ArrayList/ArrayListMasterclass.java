package ArrayList;

import java.util.*;

/**
 * THE ULTIMATE ARRAYLIST GUIDE
 * This file covers: CRUD, Sorting (Asc/Desc), Conversions, and Iteration.
 */
public class ArrayListMasterclass {

    public static void main(String[] args) {
        // 1. INITIALIZATION
        // Generic syntax: ArrayList<Type> name = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. CREATE (Adding Elements)
        numbers.add(50);             // Adds to end
        numbers.add(10);             // Adds to end
        numbers.add(30);             // Adds to end
        numbers.add(1, 100);        // Insert 100 at Index 1 (Shifts 10 and 30 to the right)

        System.out.println("Initial List: " + numbers);

        // 3. READ (Accessing Elements)
        int value = numbers.get(2);   // Gets element at Index 2
        int size = numbers.size();    // Current length of the list
        boolean exists = numbers.contains(100); // Check if element exists

        // 4. UPDATE
        numbers.set(0, 500);          // Replaces Index 0 with 500

        // 5. DELETE (Removing Elements)
        numbers.remove(1);            // Remove by Index
        numbers.remove(Integer.valueOf(30)); // Remove by Value (Object)

        System.out.println("After Update/Delete: " + numbers);

        // ---------------------------------------------------------
        // 6. SORTING (The "Comparator" Logic)
        // ---------------------------------------------------------

        // A. Natural Order (Ascending: 1, 2, 3...)
        Collections.sort(numbers);

        // B. Descending Order (Using Anonymous Comparator)
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Logic: if o2 > o1, return positive. This flips the order.
                return o2.compareTo(o1);
            }
        });

        // C. Descending Order (Modern Lambda Style - Recommended)
        numbers.sort((a, b) -> b - a);

        // D. Using built-in reverse helper
        numbers.sort(Comparator.reverseOrder());

        System.out.println("Sorted Descending: " + numbers);

        // ---------------------------------------------------------
        // 7. ITERATION (3 Ways to Loop)
        // ---------------------------------------------------------

        // Standard For-Loop (Good if you need the index i)
        for (int i = 0; i < numbers.size(); i++) {
            // System.out.print(numbers.get(i));
        }

        // Enhanced For-Loop (Cleanest)
        for (Integer num : numbers) {
            // System.out.print(num);
        }

        // Lambda For-Each (Functional Style)
        numbers.forEach(n -> System.out.println("Element: " + n));

        // ---------------------------------------------------------
        // 8. ADVANCED CONVERSIONS
        // ---------------------------------------------------------

        // Convert ArrayList to Standard Array
        Integer[] standardArray = numbers.toArray(new Integer[0]);

        // Convert Standard Array to ArrayList
        String[] colors = {"Red", "Blue", "Green"};
        ArrayList<String> colorList = new ArrayList<>(Arrays.asList(colors));

        // 9. CLEARING
        numbers.clear(); // Removes all elements
        boolean isEmpty = numbers.isEmpty(); // returns true

        System.out.println("Final State: Empty? " + isEmpty);
    }
}