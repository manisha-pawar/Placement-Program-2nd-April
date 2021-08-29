import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	static int sca = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
		
		for(int i=0; i < arr.length;i++) {
		    for(int j=0; j < arr[0].length;j++) {
		        if(arr[i][j] != 0) {
		            sca = 0;
		            dfs(arr,i,j);
		            
		            if(max < sca) {
		                max = sca;
		            }
		        }
		    }
		}
	}
	
	public static void dfs(int[][]arr,int i,int j) {
	    if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0) {
	        return;
	    }
	    
	    sca += arr[i][j];
	    
	    arr[i][j] = 0;
	    
	    //top
	    dfs(arr,i-1,j);
	    
	    //left
	    dfs(arr,i,j-1);
	    
	    //down
	    dfs(arr,i+1,j);
	    
	    //right
	    dfs(arr,i,j+1);
	}

    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}