import java.io.*;
import java.util.*;

public class Main {
    
    static String[]items = {"+-","-+","XX"};
    
    
    public static boolean isValidCountWise(char[][]ans,int[]top,int[]left,int[]right,int[]bottom) {
        //left -> row wise '+'' count 
        //right -> row wise '-'' count
        //top -> col wise '+' count
        //bottom -> col wise '-' count
        
        //row wise travel
        for(int r=0; r < ans.length;r++) {
            int pc = 0; //'+' count
            int nc = 0;  //'-' count
            
            for(int c=0;c < ans[0].length;c++) {
                if(ans[r][c] == '+') {
                    pc++;
                }
                else if(ans[r][c] == '-'){
                    nc++;
                }
            }
            
            if(left[r] != -1 && left[r] != pc) {
                return false;
            }
            
            if(right[r] != -1 && right[r] != nc) {
                return false;
            }
            
        }
        
        
        //col wise travel
        for(int c=0; c < ans[0].length;c++) {
            int pc = 0; //'+' count
            int nc = 0;  //'+' count
            
            for(int r=0;r < ans.length;r++) {
                if(ans[r][c] == '+') {
                    pc++;
                }
                else if(ans[r][c] == '-'){
                    nc++;
                }
            }
            
            if(top[c] != -1 && top[c] != pc) {
                return false;
            }
            
            if(bottom[c] != -1 && bottom[c] != nc) {
                return false;
            }
            
        }
        
        
        return true;
        
        
    }
    
	public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
			int row, int col) {
        if(col == arr[0].length) {
            row++;
            col = 0;
        }
        
        if(row == arr.length) {
            if(isValidCountWise(ans,top,left,right,bottom) == true) {
                print(ans);
                return true;
            }
            return false;
        }
	    
	    if(arr[row][col] == 'L') {
	        //place items horizontally
	        
	        for(int i=0; i < items.length;i++) {
	            String item = items[i];
	            
	            if(canPlaceHorz(ans,row,col,item) == true) {
	                //place
	                ans[row][col] = item.charAt(0);
	                ans[row][col+1] = item.charAt(1);
	                
	                //call
	                boolean isSol = solution(arr,top,left,right,bottom,ans,row,col+1);
	                if(isSol == true) {
	                    return true;
	                }
	                
	                //unplace
	                ans[row][col] = '.';
	                ans[row][col+1] = '.';
	                
	            }
	        }
	    
	   
	    }



	    else if(arr[row][col] == 'T') {
	        //place items vertically
	        for(int i=0; i < items.length;i++) {
	            String item = items[i];
	            
	            if(canPlaceVert(ans,row,col,item) == true) {
	                //place
	                ans[row][col] = item.charAt(0);
	                ans[row+1][col] = item.charAt(1);
	                
	                //call
	                boolean isSol = solution(arr,top,left,right,bottom,ans,row,col+1);
	                if(isSol == true) {
	                    return true;
	                }
	                
	                //unplace
	                ans[row][col] = '.';
	                ans[row+1][col] = '.';
	                
	            }
	        }
	    }
	    else {
	        //go to next box
	        boolean isSol = solution(arr,top,left,right,bottom,ans,row,col+1);
	        if(isSol == true) {
	            return true;
	        }
	    }

		return false;
	}
	
	
	public static boolean canPlaceHorz(char[][]ans,int i,int j,String item) {
	    if(item.equals("XX") == true) {
	        return true;
	    }
	    
	    char ch0 = item.charAt(0);
	    char ch1 = item.charAt(1);
	    
	    
	    //check ch0 nbr
	    if((i-1 >= 0 && ans[i-1][j] == ch0) || (j-1 >= 0 && ans[i][j-1] == ch0) || (i+1 < ans.length && ans[i+1][j] == ch0)){
	        return false;
	    }
	    
	    //check ch1 nbr
	    if((i-1 >= 0 && j+1 < ans[0].length && ans[i-1][j+1] == ch1) || (j+2 < ans[0].length && ans[i][j+2] == ch1) || (i+1 < ans.length && j+1 < ans[0].length && ans[i+1][j+1] == ch1)){
	        return false;
	    }
	    
	    return true;
	    
	}
	
	
	public static boolean canPlaceVert(char[][]ans,int i,int j,String item) {
	    if(item.equals("XX") == true) {
	        return true;
	    }
	    
	    char ch0 = item.charAt(0);
	    char ch1 = item.charAt(1);
	    
	    
	    //check ch0 nbr
	    if((i-1 >= 0 && ans[i-1][j] == ch0) || (j-1 >= 0 && ans[i][j-1] == ch0) || (j+1 < ans[0].length && ans[i][j+1] == ch0)) {
	        return false;
	    }
	    
	    //check ch1 nbr
	    if((i+1 < ans.length && j+1 < ans[0].length && ans[i+1][j+1] == ch1) || (i+2 < ans.length && ans[i+2][j] == ch1) || (i+1 < ans.length && j-1 >= 0 && ans[i+1][j-1] == ch1)) {
	        return false;
	    }
	    
	    return true;
	}
	
	

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		char[][] arr = new char[m][n];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			top[i] = scn.nextInt();
		}
		int[] left = new int[m];
		for (int i = 0; i < m; i++) {
			left[i] = scn.nextInt();
		}
		int[] right = new int[m];
		for (int i = 0; i < m; i++) {
			right[i] = scn.nextInt();
		}
		int[] bottom = new int[n];
		for (int i = 0; i < n; i++) {
			bottom[i] = scn.nextInt();
		}
        
        char[][]ans = new char[m][n];
        
        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                ans[i][j] = '.';
            }
        }
        
        boolean isSol = solution(arr,top,left,right,bottom,ans,0,0);
        
        if(isSol == false) {
            System.out.println("No Solution");
        }
		//write your code here
		
	}

	
}