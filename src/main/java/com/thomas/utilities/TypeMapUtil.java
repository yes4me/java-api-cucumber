/*
 * COLLECTION/LIST: ARRAYLIST(good for reading), LINKEDLIST(good for operation)
 * allow duplicate entries
 * maintain the order of the elements when added
 *
 * COLLECTION/SET: TREESET(keep a sort based on unicode characters) and HASHSET
 * NO duplicate entries
 * does NOT maintain the order of the elements they were inserted
 *
 * MAP: HashMap
 * NO duplicate key
*/

package com.thomas.utilities;

import java.util.*;

public class TypeMapUtil {
    public static <K, V> void display(Map<K, V> myMap) {
        System.out.println("Values of the List:");

        for (Map.Entry<K, V> entry : myMap.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println("key=" + key + ", value=" + value);
        }
    }

  	/* -----------------------------------------------------
    Conversion
	----------------------------------------------------- */

    public static <T> Map<T, List<T>> convert(List<List<T>> myList) {
        Map<T, List<T>> result = new HashMap<>();

        Iterator<List<T>> iterator = myList.iterator();
        while (iterator.hasNext()) {
            List<T> line = (ArrayList) iterator.next();
            T key = line.get(0);

            line.remove(0);
            result.put(key, line);
        }
        return result;
    }

  	/* -----------------------------------------------------
    Others
	----------------------------------------------------- */

    //Get frequency of numbers
    public static Map<Integer, Integer> getFrequency(int[] numbers) {
        Map<Integer, Integer> duplicate = new HashMap<>();
        for (int key : numbers) {
            Integer value = duplicate.get(key);
            duplicate.put(key, (value == null) ? 1 : value + 1);
        }
        return duplicate;
    }

    public static Map<Integer, Integer> getFrequency(Integer[] numbers) {
        Map<Integer, Integer> duplicate = new HashMap<>();
        for (int key : numbers) {
            Integer value = duplicate.get(key);
            duplicate.put(key, (value == null) ? 1 : value + 1);
        }
        return duplicate;
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
        Map<Integer, Integer> duplicate = new HashMap<>();
        // Testing displaying any primitive list
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("key0", 2);
        myMap.put("key1", 0);
        myMap.put("key2", -5);
        display(myMap);

        // Testing the frequency of numbers:
        int[] nb = {2, -5, 0, -5, 0};
        Map<Integer, Integer> frequency_nb = getFrequency(nb);
        display(frequency_nb);

        // Testing the frequency of numbers:
        Integer[] number = new Integer[5];
        number[0] = 2;
        number[1] = -5;
        number[2] = 0;
        number[3] = -5;
        number[4] = 0;
        Map<Integer, Integer> frequency_number = getFrequency(number);
        display(frequency_number);
    }
}
