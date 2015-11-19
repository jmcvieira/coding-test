package org.nuxeo;


import java.util.Arrays;
import java.util.HashMap;

/**
 * This is where you have to code.
 * 
 * See javadoc and associated unit tests to understand what is expected
 * 
 * @author tiry
 *
 */
public class ThisIsWhereYouCode {

    /**
     * input will be a string, but it may not have a file extension. return the file
     * extension (with no period) if it has one, otherwise null
     * 
     * @param filename
     * @return null if input is null or filename has no extension and the
     *         extension without the period otherwise
     */
    public String getFileNameExtension(String filename) {
        if (filename == null || !filename.contains("."))
            return null;
        else {
            String[] split = filename.split("\\.");
            if (split.length == 1)
                return "";
            else
                return split[1];
        }
    }

    /**
     * return the longest string contained inside the input array
     * 
     * @param array input Array of values
     * @return null if input is null and the longest string otherwise
     */
    public String getLongestString(Object[] array) {
        if (array == null)
            return null;
        else {
            // Falta verificar arrays de objectos dentro do array inicial
            String[] stringArray = Arrays.copyOf(array, array.length, String[].class);
            String longest = null;
            int maxLength = 0;
            for (String s : stringArray) {
                int length = s.length();
                if (length > maxLength) {
                    maxLength = length;
                    longest = s;
                }
            }
            return longest;
        }
    }

    /**
     * Returns true is both arrays contains the same values
     * 
     * @param array1 first Array to test
     * @param array2 second Array to test
     * @return true if both arrays contains the same values
     */
    public boolean areArraysEquals(String[] array1, String[] array2) {
        if (array1 == null && array2 == null)
            return true;

        if (array1 == null || array2 == null)
            return false;

        int n1 = array1.length;
        int n2 = array2.length;

        if (n1 != n2)
            return false;

        for (int i = 0; i < n1; i++) {
            if (!array1[i].equals(array2[i]))
                return false;
        }

        return true;
    }

    /**
     * Compress the input string with a very dummy algorithm : repeated letters
     * are replaced by {n}{letter} where n is the number of repetition and
     * {letter} is the letter. n must be superior to 1 (otherwise, simply output
     * the letter)
     * 
     * @param input the input string that can only contains letters
     * @return the compressed String or null if the input is null
     */
    public String getCompressedString(String input) {
        if (input == null)
            return null;
        else {
            String compressed = "";
            int length = input.length();
            for (int i = 0; i < length;) {
                char c1 = input.charAt(i);
                int count = 0;
                for (int j = 0; j < length; j++) {
                    char c2 = input.charAt(j);
                    if (c1 == c2) {
                        count++;
                        i++;
                    }
                }
                if (count == 1)
                    compressed += new StringBuilder().append("").append(c1).toString();
                else
                    compressed += count + new StringBuilder().append("").append(c1).toString();
            }
            return compressed;
        }
    }

    /**
     * Sort the input array of string based on lexicographic order of the
     * corresponding compressed string
     * 
     * @param array the Array to sort
     * @return the sorted array
     */
    public String[] getSortedArray(String[] array) {
        int length = array.length;
        String[] newArray = new String[length];
        HashMap<String, String> corresponding = new HashMap<String, String>();
        for (int i = 0; i < length; i++) {
            corresponding.put(getCompressedString(array[i]), array[i]);
            newArray[i] = getCompressedString(array[i]);
        }

        Arrays.sort(newArray);
        String[] returningArray = new String[length];
        for (int i = 0; i < length; i++) {
            returningArray[i] = corresponding.get(newArray[i]);
        }

        return returningArray;
    }
}
