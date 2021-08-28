import java.io.*;
import java.util.*;

public class Main {

  public static void solution(char[][] arr, String[] words, int vidx) {
    if(vidx == words.length) {
        print(arr);
        return;
    }
    
    String word = words[vidx];
    
    for(int i=0; i < arr.length;i++) {
        for(int j=0; j < arr[0].length;j++) {
            if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                //horizontally
                if(canPlaceHorz(arr,i,j,word) == true) {
                    boolean[]pbm = placeHorz(arr,i,j,word);
                    solution(arr,words,vidx+1);
                    unplaceHorz(arr,i,j,word,pbm);
                }
                
                //vertically
                if(canPlaceVert(arr,i,j,word) == true) {
                    boolean[]pbm = placeVert(arr,i,j,word);
                    solution(arr,words,vidx+1);
                    unplaceVert(arr,i,j,word,pbm);
                }
            }
        }
    }

  }
  
  //horizontal helper functions
  public static boolean canPlaceHorz(char[][]arr,int i,int j,String word) {
      if(j-1 >= 0 && arr[i][j-1] != '+') {
          return false;
      }
      else if(j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
          return false;
      }
      
      for(int c = 0; c < word.length(); c++) {
          if(j + c >= arr[0].length) {
              return false;
          }
          
          if(arr[i][j + c] != '-' && arr[i][j + c] != word.charAt(c)) {
              return false;
          }
      }
      
      return true;
  }
  
  public static boolean[] placeHorz(char[][]arr,int i,int j,String word) {
      boolean[]pbm = new boolean[word.length()]; //placed by me
      
      for(int c = 0 ; c < word.length();c++) {
          if(arr[i][j+c] == '-') {
            arr[i][j+c] = word.charAt(c);
            pbm[c] = true;
          }
      }
      
      return pbm;
  }
  
  public static void unplaceHorz(char[][]arr,int i,int j,String word,boolean[]pbm) {
      for(int c = 0 ; c < word.length();c++) {
          if(pbm[c] == true) {
            arr[i][j+c] = '-';
          }
      }
  }
  
  
  //vertical helper functions
   public static boolean canPlaceVert(char[][]arr,int i,int j,String word) {
      if(i-1 >= 0 && arr[i-1][j] != '+') {
          return false;
      }
      else if(i + word.length() < arr[0].length && arr[i + word.length()][j] != '+') {
          return false;
      }
      
      for(int c = 0; c < word.length(); c++) {
          if(i + c >= arr.length) {
              return false;
          }
          
          if(arr[i + c][j] != '-' && arr[i + c][j] != word.charAt(c)) {
              return false;
          }
      }
      
      return true;
      
  }
  
  public static boolean[] placeVert(char[][]arr,int i,int j,String word) {
      boolean[]pbm = new boolean[word.length()]; //placed by me
      
      for(int c = 0 ; c < word.length();c++) {
          if(arr[i + c][j] == '-') {
            arr[i + c][j] = word.charAt(c);
            pbm[c] = true;
          }
      }
      
      return pbm;
  }
  
  public static void unplaceVert(char[][]arr,int i,int j,String word,boolean[]pbm) {
      for(int c = 0 ; c < word.length();c++) {
          if(pbm[c] == true) {
            arr[i + c][j] = '-';
          }
      }
  }
  
  


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}