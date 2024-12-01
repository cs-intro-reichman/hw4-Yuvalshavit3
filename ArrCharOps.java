/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));
        System.out.println(indexOf(arr1,'l'));
        System.out.println(indexOf(arr1,'l',3));
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        char charAt = arr[index];

        return charAt;
    }

    /** If the two arrays have the same value in every index,
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        boolean areEqual = false;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++){
                if(arr1[i] != arr2[i]){
                    break;
                }
                if(i == arr1.length - 1){
                    areEqual = true;
                }
            }
        }
        return areEqual;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        int charNum = -1;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == ch){
                charNum = i;
                break;
            }
        }
        return charNum;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        int charNum = -1;
        for(int i = fromIndex; i < arr.length; i ++){
            if(arr[i] == ch){
                charNum = i;
                break;
            }
        }
        return charNum;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        int charNum = -1;
        for(int i = arr.length - 1; i > 0; i --){
            if(arr[i] == ch){
                charNum = i;
                break;
            }
        }
        return charNum;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        char [] arr3 = new char [arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i ++){
            arr3[i] = arr1[i];
        }
        for(int i = 0; i < arr2.length; i ++){
            arr3[i + arr1.length] = arr2[i];
        }
        return arr3;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] subArray = new char[endIndex - beginIndex];
        for(int i = 0; i < endIndex - beginIndex; i++){
            subArray[i] = arr[i + beginIndex];
        }
        return subArray;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        long hashCo = 0;
        int length = arr.length - 1;
        for(int i = 0; i < arr.length; i++){
            hashCo = hashCo + arr[i] * (long) Math.pow(7, length);
            length--;
        }
        return hashCo;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        int answer = -2;
        if(str1.length() == 0){
            return answer;
        }
        if(str2.length() == 0){
            return answer;
        }
        for(int i = 0; i < str1.length(); i++){
            char charat = str1.charAt(i);
            if(charat < 91 && charat > 64){
                charat = (char) (charat + 32);
                if(i > 0){
                    str1 = str1.substring(0, i - 1) + charat + str1.substring(i + 1, str1.length());
                } else {
                    str1 = charat + str1.substring(i + 1, str1.length());
                }
                
            }
        }
        for(int i = 0; i < str2.length(); i++){
            char charat = str2.charAt(i);
            if(charat < 91 && charat > 64){
                charat = (char) (charat + 32);
                if(i > 0){
                    str2 = str2.substring(0, i - 1) + charat + str2.substring(i + 1, str2.length());
                } else {
                    str2 = charat + str2.substring(i + 1, str2.length());
                }            }
        }
        

        if (str1.length() == str2.length()) {
            for(int i = 0; i < str1.length(); i++){
                if(str1.charAt(i) < str2.charAt(i)){
                    return -1;
                } else if(str1.charAt(i) > str2.charAt(i)){
                    return 1;
                } else if (i == str1.length() - 1) {
                    return 0;
                }
            }
        }

        if (str1.length() != str2.length()){
            String smaller = (str1.length() < str2.length()) ? str1 : str2;
            String bigger = (str1.length() < str2.length()) ? str2 : str1;
            for(int i = 0; i < bigger.length() - smaller.length(); i++){
                if(smaller.charAt(0) == bigger.charAt(i)){
                    for(int j = 0; j < smaller.length(); j++){
                        if(smaller.charAt(j) != bigger.charAt(i + j)){
                            break;
                        }
                        if(j == smaller.length() - 1){
                            answer = (str1.length() < str2.length()) ? -1 : 1;
                        }
                    }
                }
                if(i == bigger.length() - smaller.length() - 1 && answer == -2){
                    answer = (str1.charAt(0) < str2.charAt(0)) ? -1 : 1;
                }
            }
        }
        
        return answer;
    }
}
