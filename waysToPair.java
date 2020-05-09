class waysToPair{
	public static int solve(int n, int[] dp){
		if(n <= 1) return dp[n] = 1;
		if(dp[n] != 0) return dp[n];
		
		int singleWays = solve(n-1, dp);
		int pairWays = solve(n-2, dp) * (n-1);
		
		return dp[n] = singleWays + pairWays;
	}
	public static void main(String[] argv){
		int n = 2;
		int[] dp = new int[n+1];
		System.out.println(solve(n, dp));
	}
}
