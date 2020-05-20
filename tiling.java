public class tiling {
	public static int solve(int n, int[]dp){
		if(n == 0) return 0;
		if(n == 1 || n == 2) return dp[n] = n;
		if(dp[n] != 0) return dp[n];
		return dp[n] = solve(n-1,dp) + solve(n-2,dp);
	}
	public static void main(String[] argv){
		int n = 4;
		int[] dp = new int[n+1];
		System.out.println(solve(n, dp));
	}
}
