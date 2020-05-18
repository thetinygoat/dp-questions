class editDistance{
	public static int solve(String s1, String s2, int i, int j, int[][] dp){
		if(i == s1.length() && j == s2.length()) return 0;
		if(i == s1.length()) return s2.length() - j;
		if(j == s2.length()) return s1.length() - i;
		if(dp[i][j] != 0) return dp[i][j];
		if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = solve(s1,s2, i+1, j+1, dp);
		int insert = solve(s1,s2,i,j+1,dp);
		int delete = solve(s1,s2,i+1,j,dp);
		int replace = solve(s1,s2,i+1,j+1,dp);
		return dp[i][j] = Math.min(insert, Math.min(delete,replace)) + 1;
	}
	public static void main(String[] argv){
		String s1 = "horse", s2 = "ros";
		int[][] dp = new int[s1.length()][s2.length()];
		System.out.println(solve(s1,s2,0,0,dp));
	}
}
