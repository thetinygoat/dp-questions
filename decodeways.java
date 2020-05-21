class decodeways {
	public static int solve(String s, int idx, int[] dp){
		if(idx == s.length())
			return dp[idx] = 1;
		if(dp[idx] != 0) return dp[idx];
		char ch = s.charAt(idx);
		int count = 0;
		if(ch != '0')
			count += solve(s,idx+1, dp);		
		if(idx + 1 < s.length()){
			char ch2 = s.charAt(idx+1);
			int val = (ch - '0') * 10 + (ch2 - '0');
			if(val >= 10 && val <=26){
				count += solve(s, idx+2, dp);
			}
		}
		
		return dp[idx] = count;
	}
	public static void main(String[] argv){
		String s = "226";
		int[] dp = new int[s.length() + 1];
		System.out.println(solve(s,0,dp));
	}
}
