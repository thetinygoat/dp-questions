class divideKSubsets{
	public static int solve(int n, int k, int[][] dp){
		if(n < k) return 0; // no further division possible
		if(n == k || k == 1) return dp[n][k] = 1;
		if(dp[n][k] != 0) return dp[n][k];
		
		int newset = solve(n-1, k-1, dp);
		int combine = solve(n-1, k, dp) * k;
		
		return dp[n][k] = newset + combine;
	}
	public static void main(String[] argv){
		int n = 3, k = 2;
		int[][] dp = new int[n + 1][k + 1];
		System.out.println(solve(n,k,dp));
	}
}
