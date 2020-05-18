class timesAsSubseq{
	public static int solve(String s1, String s2, int i, int j, int[][] dp){
		if(j == 0) return 1;
		if(j > i) return 0;
		if(dp[i][j] != 0) return dp[i][j];
		if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = solve(s1,s2,i-1,j-1,dp) + solve(s1,s2, i-1, j,dp);
		return dp[i][j] = solve(s1,s2, i-1,j,dp);
	}
	public static void main(String[] argv){
		String s1 = "geeksforgeeks", s2 = "gks";
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		System.out.println(solve(s1,s2,s1.length(),s2.length(),dp));
	}
}
