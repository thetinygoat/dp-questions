class minCostClimbingStairs{
	public static int solve(int[] cost, int si, int ei, int[] dp){
		if(si == ei)
			return dp[si] = 0;
		if(dp[si] != 0) return dp[si];
		int a = 0, b = 0;
		if(si + 1 <= ei){
			a = solve(cost, si + 1, ei, dp);
		}
		if(si + 2 <= ei){
			b = solve(cost, si + 2, ei, dp);
		}
		int c = Math.min(a,b);
		return dp[si] = c + cost[si];
	}
	public static void main(String[] argv){
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int[] dp = new int[cost.length + 1];
		System.out.println(Math.min(solveDP(cost,1,dp.length-1, dp), solveDP(cost,0,dp.length-1, dp)));
	}
}
