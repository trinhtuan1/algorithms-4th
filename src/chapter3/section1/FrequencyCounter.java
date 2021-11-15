package chapter3.section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {
   public static void main(String[] args) throws FileNotFoundException {
       Scanner scanner1 = new Scanner(System.in);
       int minLength = scanner1.nextInt();
       ST<String, Integer> st = new ST<String, Integer>();
       File myFile = new File("algs4-data/leipzig1M.txt");
       int words = 0, distinct = 0;
       Scanner scanner2 = new Scanner(myFile);
       while(scanner2.hasNext()) {
           String word = scanner2.next();

           if(word.length() < minLength) continue;
           words++;
           if (st.contains(word)) {
               st.put(word, st.get(word) + 1);
           } else {
               st.put(word, 1);
               distinct++;
           }
       }
       String max = "";
       st.put(max, 0);
       for(String word : st.keys()) {
           if (st.get(word) > st.get(max)) max = word;
       }
       System.out.println(max + " " + st.get(max));
       System.out.println("words: " + words);
       System.out.println("distinct: " + distinct);
   }
}
