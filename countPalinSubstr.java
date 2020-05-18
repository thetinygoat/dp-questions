class countPalinSubstr {
	public static void main(String[] argv){
		String s = "abc";
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int gap = 0; gap < s.length(); gap++){
			for(int si = 0, ei = gap; ei < s.length(); ei++, si++){
				if(gap == 0) dp[si][ei] = true;
				else if(s.charAt(si) == s.charAt(ei) && gap == 1) dp[si][ei] = true;
				else dp[si][ei] = s.charAt(si) == s.charAt(ei) && dp[si+1][ei-1];
			}
		}
		int count = 0;
		for(boolean[] arr: dp){
			for(boolean e: arr)
				if(e == true) count++;
		}
		
		System.out.println(count);
	}
}
