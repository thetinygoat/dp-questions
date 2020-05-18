class longestPalinSubseq{
	public static void main(String[] argv){
		String s = "geeksforgeeks";
		int[][] dp = new int[s.length()][s.length()];
		for(int gap = 0; gap < s.length(); gap++){
			for(int si = 0, ei = gap; ei < s.length(); ei++, si++){
				if(gap == 0) dp[si][ei] = 1;
				else if(s.charAt(si) == s.charAt(ei) && gap == 1) dp[si][ei] = 2;
				else if(s.charAt(si) == s.charAt(ei) && dp[si+1][ei-1] != 0) dp[si][ei] = dp[si+1][ei-1] + 2;
				else dp[si][ei] = Math.max(dp[si+1][ei], dp[si][ei-1]);
			}
		}
		
		for(int[] a: dp){
			for(int e: a) System.out.print(e + " ");
			System.out.println();
		}
	}
}
