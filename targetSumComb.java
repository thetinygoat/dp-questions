class targetSumComb {
	public static int solve(int target, int[] coins, int[] dp){
		dp[0] = 1;
		for(int c: coins){
			for(int i = 0; i <= target; i++){
				if(i - c >=0){
					dp[i] += dp[i-c];
				}
			}
		}
		return dp[target];
	}
	public static void main(String[] argv){
		int target = 10;
		int[] coins = {2,3,5,7};
		int[] dp = new int[target + 1];
		System.out.println(solve(target, coins, dp));
	}
}
