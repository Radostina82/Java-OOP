
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {

    public static String disemvowel(String str) {
        // Code away...
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            if (element == 'a' || element == 'A' || element == 'e' || element == 'E' || element == 'i' || element == 'I' ||
            element == 'o' || element == 'O'){
                builder.append("");
            }else {
                builder.append(element);
            }
        }
        return builder.toString();
    }
}

