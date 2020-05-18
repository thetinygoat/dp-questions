class targetSumOT {
	public static int solve(int target, int[] coins, int idx, int[][] dp){
		if(target == 0 || idx == coins.length){
			return dp[idx][target] = target == 0 ? 1 : 0;
		}
		if(dp[idx][target] != 0) return dp[idx][target];
		int count = 0;
		if(target - coins[idx] >= 0)
			count += solve(target - coins[idx], coins, idx + 1, dp);
			
		count += solve(target, coins, idx + 1, dp);
		return dp[idx][target] = count;
	}
	public static void print(int target, int[] coins, int idx, int[][] dp, String ans){
		if(target == 0 || idx == coins.length){
			if(target == 0){
				System.out.println(ans);
			}
			return;
		}
		if(dp[idx + 1][target-coins[idx]] > 0){
			if(target - coins[idx] >= 0)
				print(target - coins[idx], coins, idx + 1, dp, ans + coins[idx]);	
		}
				
		if(dp[idx + 1][target] > 0){
			print(target, coins, idx + 1, dp, ans + coins[idx]);
		}
	}
	public static void soldp(int target, int[] coins, int idx, int[][] dp){
		dp[0][0] = 1;
		for(int i = 1; i < dp.length; i++){
			for(int t = 0; t <= target; t++){
				int count = 0;
				if(t-coins[i-1] >=0)
					count += dp[i - 1][t-coins[i]];
				count += dp[i-1][t];
				dp[i][t] = count;
			}
		}
	}
	public static void main(String[] argv){
		int target = 10;
		int[] coins = {2,3,1,5,6};
		int[][] dp = new int[coins.length + 1][target + 1];
		//System.out.println(solve(target, coins, 0, dp));
		soldp(target, coins, 0, dp);
		print(target, coins, 0, dp,"");
		for(int[] a: dp){
			for(int e: a)
				System.out.print(e + " ");
			System.out.println();
		}
	}
}
