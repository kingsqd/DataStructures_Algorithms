import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem to count the amount of swaps in an array using a merge sort, 
// Hakeem K.
public class Solution {
    
    static long count;

    
    static long countInversions(int[] arr) {
        count = 0;
        mergeSort(arr,new int[arr.length], 0, arr.length - 1);
        return count;
    }
    
    static void mergeSort(int[] arr, int[] temp, int left, int right){
        if(left >= right){
            return;
        }
        int half = (left + right)/ 2;

        mergeSort(arr, temp, left, half );
        mergeSort(arr, temp, half + 1 , right);
        mergeHalves(arr, temp, left, right);
    }
    
    static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd){
        int left = leftStart;
        int leftEnd = (left + rightEnd) / 2;
        int right = leftEnd + 1;
        int index = left;
        
        while(left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right]){
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                count += right - index;;
                right++;
                
            }
            index ++;
        }
       
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
    }


    static void swap(int[] arr, int one, int two){
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(Arrays.toString(arr));

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
