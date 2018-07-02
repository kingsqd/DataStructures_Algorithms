import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//Given an input stream of  integers, you must perform the following task for each  integer:

//Add the  integer to a running list of integers.
//Find the median of the updated list (i.e., for the first element through the  element).
//Print the list's updated median on a new line. The printed value must be a double-precision number scaled to  decimal place 
public class Solution {



    private static final Scanner scanner = new Scanner(System.in);
    
   public static float getMedian(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else if (list.size() % 2 == 1) {
            return list.get((list.size()) / 2);
        } else {
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2f;
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];
       
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int lo = 0;
            int hi = list.size();
            int mid = lo + (hi - lo)/2;
            if(list.isEmpty()){
                list.add(aItem);
                double print = aItem;
                System.out.println(print);
                continue;
            }   
            while(lo <= hi && lo < list.size()){                
                mid = lo + (hi - lo)/2;
                if(aItem < list.get(mid)){
                    hi = mid - 1;;
                } else {
                    lo = mid + 1;
                }
            }
            if(lo == list.size()){
                list.add(aItem);
            }else {
                list.add(lo, aItem);
            }
            System.out.println(String.format( "%.1f", getMedian(list)));
        }
        

        scanner.close();
    }
}
