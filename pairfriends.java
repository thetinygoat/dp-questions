class pairfriends {
	public static int solve(int n, int[] dp){
		if(n <= 1)
			return 1;
			
		if(dp[n] != 0) return dp[n];
		int pair = solve(n-2, dp) * (n - 1);
		int not_pair = solve(n-1, dp);
		
		return dp[n] = pair + not_pair;
	}
	public static void main(String[] argv){
		int n = 3;
		int[] dp = new int[n+1];
		System.out.println(solve(n,dp));
	}
}
