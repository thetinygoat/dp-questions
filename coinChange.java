class coinChnage {
	public static int solve(int target, int[] coins, int[] dp){
		if(target == 0) return 0;
		if(dp[target] != 0) return dp[target];
		int height = (int) 1e8;
		for(int c: coins){
			if(target - c >=0)
				int rech = solve(target - c, coins, dp);
				if(rech != (int) 1e8)
					height = Math.min(height, rech + 1);
		}
		
		return dp[target] = height;
	}
	public static void main(String[] argv){
		int target = 10;
		int[] dp = new int[target + 1];
		int ans = solve(target, coins, dp);
		return ans == (int) 1e8 ? -1: ans;
	}
}
