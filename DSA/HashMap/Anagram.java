import java.util.HashMap;
import java.util.TreeMap;

public class Anagram {

    static boolean areAnagram (String str1, String str2) {

        // if both strings length are not same. They are not anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        // A hashmap that stored each unique char as Key and value as int
        // the value is actually the count of each char in the string
        HashMap<Character, Integer> charMap = new HashMap<>();

        // store each char from str1 to make
        // if any char repeats, increment its value by 1
        for (char c : str1.toCharArray()) {
            /*
             * put each char key into map with the value 0 when putting
             * for the first time and then, if the same char comes again
             * then get the current value of that char key and increment by 1.
             */
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        // Now all characters from str1 are put into HashMap with count as its value.

        // take each char from str2
        /*
         * compare if that char contains in HashMap we formed from adding
         * char from string 1.
         * If no, it means, that char is only present in str2.
         * so return false (not an anagram).
         * else, it's present in both strings, so take the count of that char.
         * if count is 1, the char appeared only once in that str1,
         * so remove it from the hashMap.
         * else, that char has appeared more than once, in that case,
         * just decrement its count value by 1. At some point, it'll
         * hit 1 and be removed.
         */

        for (char c : str2.toCharArray()) {
            if (!charMap.containsKey(c)) {
                return false;
            }

            int countofChar = charMap.get(c);

            if (countofChar == 1) {
                charMap.remove(c);
            } else {
                charMap.put(c, countofChar - 1);
            }
        }

        /*
         * by this time, all characters must be removed and the
         * HashMap must be empty. If not, then some char key's count
         * is still not 1, and not removed. So, some chars on string1
         * appeared more than on string 2. So, they aren't anagram.
         */

        return charMap.isEmpty();
    }
    static boolean isTreeAnagram (String str1, String str2){

        TreeMap<Character,Integer > tree1 = new TreeMap<>();

        for(Character Char : str1.toLowerCase().toCharArray()){
            tree1.put(Char,tree1.getOrDefault(Char,0) +1);
        }

//        TreeMap<Character,Integer > tree2 = new TreeMap<>();


        for(Character Char : str2.toLowerCase().toCharArray()){

            if(!tree1.containsKey(Char)){
                return false;
            }

            Integer charCount = tree1.get(Char);

            if (charCount == 1){
                tree1.remove(Char);
            }
            else{
                tree1.put(Char, (charCount - 1));
            }



        }

        return tree1.isEmpty();


    }

        public static void main(String[] args) {
        HashMap<String,Integer> ana = new HashMap<>();
            System.out.println(isTreeAnagram("Vada", "Daav"));
//            System.out.println(areAnagram("momm","ooms"));
    }
}
