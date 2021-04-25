import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][]mat = new int[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0;j < m;j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        shellRotate(mat,s,r);
        display(mat);
    }
    
    
    public static int[] fill1DArray(int[][]mat,int s) {
        int row = mat.length;
        int col = mat[0].length;
        
        int rs = s-1;
        int cs = s-1;
        int re = row-s;
        int ce = col-s;
        
        int tes = 2*(re-rs) + 2*(ce-cs) ; //total elements in s shell 
        int[]arr = new int[tes];
        int idx = 0;
        
        //left wall
        for(int i=rs;i <= re;i++) {
            arr[idx] = mat[i][cs];
            idx++;
        }
        cs++;
        
        //bottom wall
        for(int j=cs; j <= ce;j++) {
            arr[idx] = mat[re][j];
            idx++;
        }
        re--;
        
        //right wall
        for(int i=re; i >= rs;i--) {
            arr[idx] = mat[i][ce];
            idx++;
        }
        ce--;
        
        //top wall
        for(int j=ce; j >= cs;j--) {
            arr[idx] = mat[rs][j];
            idx++;
        }
        rs++;
        
        return arr;
    }
    
    public static void reverse(int[]arr,int lo,int hi) {
        while(lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            
            lo++;
            hi--;
        }
    }
    
    public static void rotate(int[]arr,int k) {
        
        int n = arr.length;
        
        k = k % n;
        
        if(k < 0) {
            k = k + n;
        }
        
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    
    public static void fill2DMatrix(int[][]mat,int s,int[]arr) {
        int row = mat.length;
        int col = mat[0].length;
        
        int rs = s-1;
        int cs = s-1;
        int re = row-s;
        int ce = col-s;
        
        int tes = 2*(re-rs) + 2*(ce-cs) ; //total elements in s shell 
        int idx = 0;
        
        //left wall
        for(int i=rs;i <= re;i++) {
            mat[i][cs] = arr[idx];
            idx++;
        }
        cs++;
        
        //bottom wall
        for(int j=cs; j <= ce;j++) {
            mat[re][j] = arr[idx];
            idx++;
        }
        re--;
        
        //right wall
        for(int i=re; i >= rs;i--) {
            mat[i][ce] = arr[idx];
            idx++;
        }
        ce--;
        
        //top wall
        for(int j=ce; j >= cs;j--) {
            mat[rs][j] = arr[idx];
            idx++;
        }
        rs++;
        
    }
    
    public static void shellRotate(int[][]mat,int s,int r) {
        //1. fill 1d array using s shell of matrix
        int[]arr = fill1DArray(mat,s);
        
        //2. rotate this 1d array
        rotate(arr,r);
        
        //3. fill s shell of matrix with this rotated array
        fill2DMatrix(mat,s,arr);
    }
    

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}