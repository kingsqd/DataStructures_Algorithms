import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Class of my solution to adding a string to a dictionary and finding the amount of full words that match a partial
public class Solution {


    public static class Node {
        public HashMap<Character, Node> children;
        public boolean isCompleteWord;
        public int size;
        public Node(){
            children = new HashMap<Character, Node>();
            size = 0;
        }
    }
    public static int findChildren(Node root){
        int count = 0;
        
        for(Character key : root.children.keySet()){
            if(root.children.get(key).isCompleteWord){
                count++;
            }
            count += findChildren(root.children.get(key));
        }
        return count;
    }
    public static int find(Node root, String word){
        Node temp = root;
       
        for(int i = 0; i < word.length(); i++){
            if(!temp.children.containsKey(word.charAt(i))){
                return 0;
            } 
            temp = temp.children.get(word.charAt(i));
        }
        
        return temp.size;
    }
   
    
    
    public static void add(String word, Node root){
        Node temp = root;
        for(int i = 0; i < word.length(); i++){
            if(!temp.children.containsKey(word.charAt(i))){
                temp.children.put(word.charAt(i), new Node());
            }
            
            temp = temp.children.get(word.charAt(i));
            temp.size++;
            
        }
        temp.isCompleteWord = true;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Node root = new Node();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
            if(op.equals("add")){
                add(contact, root);
            } else{
                System.out.println(find(root, contact));
            }
        }

        scanner.close();
    }
}
