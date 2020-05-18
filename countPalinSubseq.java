class countPalinSubseq {
	public static int solve(String s, int si, int ei, int[][] dp){
		if(si > ei) return 0;
		if(si == ei) return dp[si][ei] = 1;
		if(dp[si][ei] != 0) return dp[si][ei];
		if(s.charAt(si) == s.charAt(ei)) return dp[si][ei] = solve(s, si+1, ei,dp) + solve(s, si, ei-1, dp) + 1;
		return dp[si][ei] = solve(s, si+1, ei,dp) + solve(s, si, ei-1, dp) - solve(s, si+1, ei-1, dp);
		
	}
	public static int dp(String s, int si, int ei, int[][] dp){
		for(int gap = 0; gap < s.length(); gap++){
			for(si = 0, ei = gap; ei < s.length(); ei++, si++){
				if(gap == 0) dp[si][ei] = 1;
				else if(s.charAt(si) == s.charAt(ei)) dp[si][ei] = dp[si+1][ei] + dp[si][ei-1] + 1;
				else dp[si][ei] = dp[si + 1][ei] + dp[si][ei-1] - dp[si+1][ei-1];
			}
		}
		return dp[0][s.length() - 1];
	}
	public static void main(String[] argv){
		String s = "aabcd";
		int[][] dp = new int[s.length()][s.length()];
		System.out.println(dp(s,0,s.length()-1, dp));
	}
}
