import java.io.*;
import java.util.*;

public class Main {
    static int counter = 1;
    
    //conessf -> count of non-empty subsets so far
	public static void solution(int cp, int n, int k, int conessf, ArrayList<ArrayList<Integer>> ans) {
		if(cp > n) {
		    if(conessf == k) {
		        System.out.print(counter + ". ");
		        
		        for(int i=0; i < k;i++) {
		            System.out.print(ans.get(i) + " ");
		        }
		        counter++;
		        System.out.println();
		    }
		    return;
		}
		
		for(int i = 0; i < k;i++) {
		    //participate in non-empty subsets
		    if(ans.get(i).size() > 0) {
		        ans.get(i).add(cp);
		        solution(cp+1,n,k,conessf,ans);
		        int size = ans.get(i).size();
		        ans.get(i).remove(size-1);
		    }
		    //be the first person of first empty subset
		    else {
		        ans.get(i).add(cp);
		        solution(cp+1,n,k,conessf + 1,ans);
		        int size = ans.get(i).size();
		        ans.get(i).remove(size-1);
		        break;
		    }
		}
	}
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}