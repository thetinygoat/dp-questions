class dicePath{
	public static int dicePath(int si, int ei, int[] dp){
		if(si == ei)
			return dp[si] = 1;
			
		if(dp[si] != 0 ) return dp[si];
		int count = 0;
		for(int i = 1; i <= 6; i++){
			if(si + i <= ei){
				count += dicePath(si + i, ei, dp);
			}
		}
		
		return dp[si] = count;
	}
	public static int dicePathDP(int si, int ei, int[] dp){
		
		for(si = ei; si >= 0; si--){
			if(si == ei){
				dp[si] = 1;
				continue;
			}
			int count = 0;
			for(int i = 1; i <= 6; i++){
				if(si + i <= ei){
					count += dp[si+i];
				}
			}
			dp[si] = count;
		}
		return dp[0];
	}
	public static void main(String[] argv){
		int target = 10;
		int[] dp = new int[target+1];
		
		System.out.println(dicePathDP(0,10,dp));
	}
}
