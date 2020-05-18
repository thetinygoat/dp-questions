class knapsack01{
	public static int solve(int[] values, int[] weights, int idx, int[][] dp, int w){
		if(w == 0 || idx == weights.length){
			return 0;
		}
		if(dp[idx][w] != 0) return dp[idx][w];
		int p = 0, np = 0;
		if(w - weights[idx] >=0)
			p = solve(values, weights, idx+1, dp, w - weights[idx]) + values[idx];
		np = solve(values, weights, idx+1, dp, w);
		return dp[idx][w] = Math.max(p,np);
	}
	public static void main(String[] argv){
		int w = 50;
		int[] weights = {20,30,10};
		int[] values = {60,100,120};
		int[][] dp = new int[weights.length+1][w+1];
		System.out.println(solve(values,weights,0,dp,w));
	}
}
