class lcsubseq{
	public static int solve(String s1, String s2, int i, int j, int[][] dp){
		if(i == s1.length() || j == s2.length()) return 0;
		if(dp[i][j] != 0) return dp[i][j];
		if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = solve(s1,s2,i+1,j+1,dp) + 1;
		return dp[i][j] = Math.max(solve(s1,s2, i+1, j, dp), solve(s1,s2, i, j+1, dp));
	}
	public static int dp(String s1, String s2, int i, int j, int[][] dp){
		for(i = s1.length() - 1; i >=0; i--){
			for(j = s2.length() - 1; j >= 0; j--){
				if(s1.charAt(i) == s2.charAt(j))dp[i][j] = dp[i+ 1][j+1] + 1;
				else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}
		return dp[0][0];

	}
	
	public static void main(String[] argv){
		String s1 = "abc", s2 = "def";
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		System.out.println(solve(s1,s2, 0,0,dp));
	}
}
