class lcsubstr{
	static int max = 0;
	public static int solve(String s1, String s2, int i, int j, int[][] dp){
		if(i == s1.length() || j == s2.length()) return 0;
		if(dp[i][j] != 0) return dp[i][j];
		if(s1.charAt(i) == s2.charAt(j)){
			dp[i][j] = solve(s1,s2, i+1, j+1, dp) + 1;
			max = Math.max(dp[i][j], max);
		}
		solve(s1,s2, i+1, j, dp);
		solve(s1,s2, i, j+1, dp);
		return dp[i][j];
	}
	public static void main(String[] argv){
		String s1 = "abacdefgh", s2 = "abxcdefgh";
		int[][] dp = new int[s1.length()][s2.length()];
		System.out.println(solve(s1,s2,0,0,dp));
		System.out.println(max);
	}
}
