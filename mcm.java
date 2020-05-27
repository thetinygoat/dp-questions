import java.util.*;
class mcm {
	public static int solve(int si, int ei, int[] arr, int[][] dp){
		if(si+1 == ei) return dp[si][ei] = 0;
		if(dp[si][ei] != -1) return dp[si][ei];
		int min = (int) 1e8;
		for(int cut = si + 1; cut < ei;cut++){
			int lc = solve(si,cut,arr,dp);
			int rc = solve(cut,ei,arr,dp);
			int tc = lc + arr[si] * arr[cut] * arr[ei] + rc;
			min = Math.min(min,tc);
		}
		
		return dp[si][ei] = min;
	}
	public static void main(String[] argv){
		int[] arr = {10, 20, 30, 40, 30};
		int[][] dp = new int[arr.length][arr.length];
		for(int[] ar: dp){
			Arrays.fill(ar,-1);
		}
		System.out.println(solve(0,arr.length-1,arr,dp));
		for(int[] a: dp){
			for(int e: a){
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
	}
}
