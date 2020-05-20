class coinChangedp {
	public static int solve(int n, int[] dp, int[] coins){
		dp[0] = 1;
		for(int c: coins){
			for(int t = 0; t <= n; t++){
				if(t-c >=0)
					dp[t] += dp[t-c];
			}
		}
		return dp[n];
	}
	public static void main(String[] argv){
		int[] coins = {1,2,3};
		int n = 4;
		int[] dp = new int[n+1];
		System.out.println(solve(n,dp,coins));
	}
}
