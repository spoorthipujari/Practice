package ArraysStringsProblems;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

/**
 * Created by quikr on 07/05/18.
 */
public class StringProblems {

    public static boolean isAllCharactersUnique(String str){
        boolean[] charCountArray = new boolean[256];
        if(str.length()>256)
            return false;
        for(int i =0; i<str.length();i++){
            int val = str.charAt(i);
            if(charCountArray[val])
                return false;
            charCountArray[val] = true;
        }

        return true;
    }

    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        return Arrays.equals(s1Arr,s2Arr);
    }

    public static char[] urlify(char[] arr, int len){
        int index = arr.length-1;
        for(int i = len-1;i>=0;i--){
            if(arr[i]== ' '){
                arr[index]= '0';
                arr[index - 1] = '2';
                arr[index - 2] = '%';
                index = index -3;
            }
            else{
                arr[index] = arr[i];
                --index;
            }
        }
        return arr;
    }

    public static boolean isPalindromePermutation(String str){
        char[] arr = str.toLowerCase().toCharArray();
        Map<Character,Integer> charCountMap = new HashMap<>();
        for (char c:arr) {
            if(c == ' ')
                continue;
            if(charCountMap.containsKey(c))
                charCountMap.put(c,charCountMap.get(c)+1);
            else
                charCountMap.put(c,1);
        }
        //for palindrome, either all characters should be in pairs,
        //or all in pairs, except one
        //or all in pais, one in odd
        int nonPairCount = 0;
        for (Map.Entry<Character,Integer> entry:charCountMap.entrySet()) {
            if(entry.getValue()%2 == 1)
                ++nonPairCount;
        }
        if(nonPairCount==0 || nonPairCount==1)
            return true;
        else
            return false;
    }


    public static void main(String[] args){
        System.out.println(isAllCharactersUnique("fhfjvhvvh"));
        System.out.println(isAllCharactersUnique("asdfghjk"));
        String str = "Mr John Smith    ";
        System.out.println(urlify(str.toCharArray(),13));
        System.out.println(isPalindromePermutation("listensilent"));
    }
}
