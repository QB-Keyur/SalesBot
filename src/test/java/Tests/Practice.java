package Tests;

import groovy.transform.builder.InitializerStrategy;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Practice {

    //Reverse String
    @Test
    public void reverseString(){

        //Create one string
        String str = "Selenium";

        //Create one empty string when I have to store the reverse string
        String rev = "";

        // Loop को last index से start कर रहे हैं (पीछे से)
        // str.length() - 1 इसलिए क्योंकि index 0 से शुरू होता है
        //For loop j pachad thi agad jase
        //ChatAt che e ae position no number lese for example ---> chatAt(0) to e 0 index ni position no number lese
        for(int i = str.length() - 1; i>=0; i--){

            // charAt(i) → current index का character देता है
            // rev + character → पुराने characters के साथ नया जोड़ता है
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }

    @Test
    public void reverseStringUsingAnStringBuilder(){
        String str = "Selenium";
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(reversed);
    }

    @Test
    public void checkPolindromeString(){
        String str = "madamasdfdsaf";
        String rev = "";

        for (int i = str.length()-1; i>=0; i--){
            rev = rev+str.charAt(i);
        }

        if(str.equals(rev)){
            System.out.println("Pollidrome string");
        } else {
            System.out.println("Not pollidrome string");
        }
    }

    @Test
    public void swapTwoNumberWithoutCreatingAThirdVariable(){
        int a = 10, b = 20;

        a = a+b;
        b = a-b;
        a = a-b;

        System.out.println(a + " " + b);
        //now a = 20 b=10
    }

    @Test
    public void countOccurrenceOfCharacterInString(){

        String str = "automation";
        char ch = 'a';
        int count = 0;

        for (char c: str.toCharArray()){
            if (c==ch) count++;
        }

        System.out.println(count);

    }

    //Java collections
    //Find Duplicate Elements in Array
    @Test
    public void findDuplicateElementInArray(){

        //Crate one array
        int[] arr = {1,2,3,4,5,6,1,2};

        //Now create one set who never save duplicate values
        //Set कभी भी duplicate value allow नहीं करता
        //अगर value नई है → add हो जाएगी
        //अगर value पहले से है → add नहीं होगी
        Set<Integer> set = new HashSet<>();

        for(int num:arr){
            if (!set.add(num)){
                System.out.println("Duplicate: "+arr);
            }
        }
    }




}
